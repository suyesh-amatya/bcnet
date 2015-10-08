package com.bcnet.portlet.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.SampleImportLog;
import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.model.impl.SampleImportLogImpl;
import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleUploadPortlet
 */
public class SampleUploadPortlet extends MVCPortlet {
    
	/**
	 * Error Format for date
	 */
	private static final String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	private static final SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	private static final DataFormatter fmt = new DataFormatter();
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	//private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static String sourceFileName;
	private static String biobankId;
	private String errorStr;
	
	public void uploadSample(ActionRequest request, ActionResponse response) throws Exception {
		
		final int ONE_GB = 1073741824;
		
		//final String baseDir = "/Users/suyeshamatya/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		final String baseDir = "C:/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		
		final String fileInputName = "fileupload";
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		//Normally the form data is accessed like ParamUtil.getString(request, "biobankId") or request.getParameter("biobankId").
		//But since the form has enctype="multipart/form-data", it cannot be accessed via request but instead UploadPortletRequest should be used.
		//So the ways to access the form data in such case will be: ParamUtil.getString(uploadRequest, "biobankId") or uploadRequest.getParameter("biobankId").
		
		biobankId = uploadRequest.getParameter("biobankId");
		
		
		System.out.println(uploadRequest.getFileName(fileInputName));
		 
		long sizeInBytes = uploadRequest.getSize(fileInputName);
 
		if (uploadRequest.getSize(fileInputName) == 0) {
			throw new Exception("Received file is 0 bytes!");
		}
 
		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(fileInputName);
 
		sourceFileName = uploadRequest.getFileName(fileInputName);
 
		
		// Where should we store this file?
		File folder = new File(baseDir);
 
		// Check minimum 1GB storage space to save new files...
		
		if (folder.getUsableSpace() < ONE_GB) {
			//throw new Exception("Out of disk space!");
		}
 
		// This is our final file path.
		File filePath = new File(folder.getAbsolutePath() + File.separator + sourceFileName);
		
		/*System.out.println("Usable Space "+folder.getUsableSpace());
		System.out.println("Absolute File Path "+filePath.getAbsolutePath());
		System.out.println("Total Space "+filePath.getTotalSpace());
		System.out.println("Free Space "+filePath.getFreeSpace());
		System.out.println("Name "+filePath.getName());
		System.out.println("Is absolute "+filePath.isAbsolute());
		System.out.println("Separator "+filePath.separator);
		System.out.println("Can Read "+filePath.canRead());
		System.out.println("Can Write "+filePath.canWrite());
		System.out.println("Set Readable "+filePath.setReadable(true));
		System.out.println("Set Writable "+filePath.setWritable(true));*/
		
		// Move the existing temporary file to new location.
		FileUtil.copyFile(uploadedFile, filePath);
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(uploadedFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error on Reading File" + e.getMessage());
			SessionErrors.add(request, "file-not-found");
		}
		
		if(uploadedFile.toString().endsWith("xls")) {
			readXLSFile(inputStream, request);
		} else if(uploadedFile.toString().endsWith("xlsx")) {
			readXLSXFile(inputStream, request);
		} else {
			SessionErrors.add(request, "file-upload-wrong-type");
		}
		
		sendRedirect(request, response);
	}
	
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		System.out.println(errorStr);
		String templateFileName = "BCNet_SampleImport_Template";
		String cmd = resourceRequest.getParameter(Constants.CMD);
		Workbook wb = null;
		OutputStream out = resourceResponse.getPortletOutputStream();
		if(cmd.equalsIgnoreCase("xlsxTemplate")){
			wb = generateXLSXTemplateFile();
			templateFileName += ".xlsx";
		}
		else if(cmd.equalsIgnoreCase("xlsTemplate")){
			wb = generateXLSTemplateFile();
			templateFileName += ".xls";
		}
		
		if(cmd.equalsIgnoreCase("xlsxTemplate") || cmd.equalsIgnoreCase("xlsTemplate")){
			resourceResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.addProperty("Content-disposition", "attachment; filename=" + templateFileName);
			wb.write(out);
			out.flush();
			out.close();
		}
		System.out.println(errorStr);
			
		if(cmd.equalsIgnoreCase("error")){
			OutputStream errorout = resourceResponse.getPortletOutputStream();
			resourceResponse.setContentType("Content-type: application/octet-stream");
			PortalUtil.getHttpServletResponse(resourceResponse).setHeader("Content-disposition", "attachment; filename=errorfile.txt");
			//resourceResponse.addProperty("Content-disposition", "attachment; filename=errorfile.txt");
			if(errorStr!=null){
				errorout.write(errorStr.getBytes(Charset.forName("UTF-8")));
			}
			errorout.flush();
			errorout.close();
		}
		
		
		
	}
	
	private Workbook generateXLSXTemplateFile() {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sample");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("sampleCollectionId");
		row.createCell(1).setCellValue("hashedSampleId");
		row.createCell(2).setCellValue("hashedIndividualId");
		row.createCell(3).setCellValue("materialType");
		row.createCell(4).setCellValue("container");
		row.createCell(5).setCellValue("storageTemperature");
		row.createCell(6).setCellValue("sampledTime");
		row.createCell(7).setCellValue("anatomicalPartOntology");
		row.createCell(8).setCellValue("anatomicalPartOntologyVersion");
		row.createCell(9).setCellValue("anatomicalPartOntologyCode");
		row.createCell(10).setCellValue("anatomicalPartOntologyDescription");
		row.createCell(11).setCellValue("anatomicalPartFreeText");
		row.createCell(12).setCellValue("sex");
		row.createCell(13).setCellValue("ageLow");
		row.createCell(14).setCellValue("ageHigh");
		row.createCell(15).setCellValue("ageUnit");
		row.createCell(16).setCellValue("diseaseOntology");
		row.createCell(17).setCellValue("diseaseOntologyVersion");
		row.createCell(18).setCellValue("diseaseOntologyCode");
		row.createCell(19).setCellValue("diseaseOntologyDescription");
		row.createCell(20).setCellValue("diseaseFreeText");
		row.createCell(21).setCellValue("countryOfOrigin");
		return workbook;
	}
	
	private Workbook generateXLSTemplateFile() {
		// TODO Auto-generated method stub
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sample");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("sampleCollectionId");
		row.createCell(1).setCellValue("hashedSampleId");
		row.createCell(2).setCellValue("hashedIndividualId");
		row.createCell(3).setCellValue("materialType");
		row.createCell(4).setCellValue("container");
		row.createCell(5).setCellValue("storageTemperature");
		row.createCell(6).setCellValue("sampledTime");
		row.createCell(7).setCellValue("anatomicalPartOntology");
		row.createCell(8).setCellValue("anatomicalPartOntologyVersion");
		row.createCell(9).setCellValue("anatomicalPartOntologyCode");
		row.createCell(10).setCellValue("anatomicalPartOntologyDescription");
		row.createCell(11).setCellValue("anatomicalPartFreeText");
		row.createCell(12).setCellValue("sex");
		row.createCell(13).setCellValue("ageLow");
		row.createCell(14).setCellValue("ageHigh");
		row.createCell(15).setCellValue("ageUnit");
		row.createCell(16).setCellValue("diseaseOntology");
		row.createCell(17).setCellValue("diseaseOntologyVersion");
		row.createCell(18).setCellValue("diseaseOntologyCode");
		row.createCell(19).setCellValue("diseaseOntologyDescription");
		row.createCell(20).setCellValue("diseaseFreeText");
		row.createCell(21).setCellValue("countryOfOrigin");
		return workbook;
	}


	


	private void readXLSXFiles(InputStream inputStream, ActionRequest request) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("sample");
		
		/*sheet.getRow(0).getCell(22).setCellValue("test");
		File file = new File("C:\\Users\\suyama\\Desktop\\sample to upload\\BCNet catalog template-Prolifica.xlsx");
		try{
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			System.out.println("can write");
		}
		catch(FileNotFoundException e) {
			System.out.println("File is open");
		}*/
		/*UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		File uploadedFile = uploadRequest.getFile("fileupload");
		System.out.println(uploadedFile.getAbsolutePath()+ " "+uploadedFile.getName());*/
		errorStr = "";
/*		if(errorStr!=""){
			System.out.println("errorStr"+errorStr);
		}
*/		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			System.out.println(row.getRowNum()+" "+ isRowEmpty(row));
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell)cellIterator.next();
				switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        System.out.println(cell.getDateCellValue());
                    } else {
                        System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_BLANK:
                	errorStr+="Empty value in:"+ cell.getRowIndex()+" "+cell.getColumnIndex();
                	//System.out.println("Empty value in:"+ cell.getRowIndex()+" "+cell.getColumnIndex());
                	break;
                default:
                    System.out.println();
				}
				/*if(cell.getCellType() != Cell.CELL_TYPE_BLANK){
					System.out.println(cell.getStringCellValue());
				}
				else{
					errorStr+="Empty value in:"+ cell.getRowIndex()+cell.getColumnIndex();
					System.out.println("Empty value in:"+ cell.getRowIndex()+cell.getColumnIndex());
				}
				*/
				
			}
		}
		if(errorStr!=""){
			System.out.println("errorStr"+errorStr);
			request.setAttribute("error", errorStr);
		}
		else{
			
		}
		
	}

	private static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}

	private void readXLSXFile(InputStream inputStream, ActionRequest request) throws IOException, SystemException {
		// TODO Auto-generated method stub
		System.out.println("readXLSXFile");

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("sample");
		if(sheet == null) {
			System.out.println("No Sample Sheet found.");
		}
		else{
			System.out.println("Sample Sheet found.");
		}
		if(workbook.getSheetAt(0) != null){
			System.out.println("Sheet found.");
		}
		else{
			System.out.println("Sheet not found.");
		}

		
		Iterator<Row> rowIterator = sheet.rowIterator();
		
		errorStr = "";
		boolean header = true;
		boolean importLog = true;
		int rowcount = 1;
		String rowerrors = "";
		String uuid_ = PortalUUIDUtil.generate();
		List<Sample> sampleList = new ArrayList<Sample>();

		int sampleCollectionId_column = -1;
		int biobankId_column = -1;
		int hashedSampleId_column = -1;
		int hashedIndividualId_column = -1;
		int materialType_column = -1;
		int container_column = -1;
		int storageTemperature_column = -1;
		int sampledTime_column = -1;
		int anatomicalPartOntology_column = -1;
		int anatomicalPartOntologyVersion_column = -1;
		int anatomicalPartOntologyCode_column = -1;
		int anatomicalPartOntologyDescription_column = -1;
		int anatomicalPartFreeText_column = -1;
		int sex_column = -1;
		int ageHigh_column = -1;
		int ageLow_column = -1;
		int ageUnit_column = -1;
		int diseaseOntology_column = -1;
		int diseaseOntologyVersion_column = -1;
		int diseaseOntologyCode_column = -1;
		int diseaseOntologyDescription_column = -1;
		int diseaseFreeText_column = -1;
		int countryOfOrigin_column = -1;
		
		
		while (rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();

			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				String column_missing = "";
				String extra_columns = "";
				
				while (cellIterator.hasNext()) {
					XSSFCell cell = (XSSFCell)cellIterator.next();

					switch(cell.getStringCellValue().trim()){
						case "sampleCollectionId":
							//sampleCollectionId_column = cellcounter;
							sampleCollectionId_column = cell.getColumnIndex();
							break;
						case "biobankId":
							//biobankId_column = cellcounter;
							//Not necessary to define this case. The biobankId is provided via the form.
							biobankId_column = cell.getColumnIndex();
							break;
						case "hashedSampleId":
							//hashedSampleId_column = cellcounter;
							hashedSampleId_column = cell.getColumnIndex();
							break;
						case "hashedIndividualId":
							//hashedIndividualId_column = cellcounter;
							hashedIndividualId_column = cell.getColumnIndex();
							break;
						case "materialType":
							//materialType_column = cellcounter;
							materialType_column = cell.getColumnIndex();
							break;
						case "container":
							//container_column = cellcounter;
							container_column = cell.getColumnIndex();
							break;
						case "storageTemperature":
							//storageTemperature_column = cellcounter;
							storageTemperature_column = cell.getColumnIndex();
							break;
						case "sampledTime":
							//sampledTime_column = cellcounter;
							sampledTime_column = cell.getColumnIndex();
							break;
						case "anatomicalPartOntology":
							//anatomicalPartOntology_column = cellcounter;
							anatomicalPartOntology_column = cell.getColumnIndex();
							break;
						case "anatomicalPartOntologyVersion":
							//anatomicalPartOntologyVersion_column = cellcounter;
							anatomicalPartOntologyVersion_column = cell.getColumnIndex();
							break;
						case "anatomicalPartOntologyCode":
							//anatomicalPartOntologyCode_column = cellcounter;
							anatomicalPartOntologyCode_column = cell.getColumnIndex();
							break;
						case "anatomicalPartOntologyDescription":
							//anatomicalPartOntologyDescription_column = cellcounter;
							anatomicalPartOntologyDescription_column = cell.getColumnIndex();
							break;
						case "anatomicalPartFreeText":
							//anatomicalPartFreeText_column = cellcounter;
							anatomicalPartFreeText_column = cell.getColumnIndex();
							break;
						case "sex":
							//sex_column = cellcounter;
							sex_column = cell.getColumnIndex();
							break;
						case "ageHigh":
							//ageHigh_column = cellcounter;
							ageHigh_column = cell.getColumnIndex();
							break;
						case "ageLow":
							//ageLow_column = cellcounter;
							ageLow_column = cell.getColumnIndex();
							break;
						case "ageUnit":
							//ageUnit_column = cellcounter;
							ageUnit_column = cell.getColumnIndex();
							break;
						case "diseaseOntology":
							//diseaseOntology_column = cellcounter;
							diseaseOntology_column = cell.getColumnIndex();
							break;
						case "diseaseOntologyVersion":
							//diseaseOntologyVersion_column = cellcounter;
							diseaseOntologyVersion_column = cell.getColumnIndex();
							break;
						case "diseaseOntologyCode":
							//diseaseOntologyCode_column = cellcounter;
							diseaseOntologyCode_column = cell.getColumnIndex();
							break;
						case "diseaseOntologyDescription":
							//diseaseOntologyDescription_column = cellcounter;
							diseaseOntologyDescription_column = cell.getColumnIndex();
							break;
						case "diseaseFreeText":
							//diseaseFreeText_column = cellcounter;
							diseaseFreeText_column = cell.getColumnIndex();
							break;
						case "countryOfOrigin":
							//countryOfOrigin_column = cellcounter;
							countryOfOrigin_column = cell.getColumnIndex();
							break;
						default:
							if(!extra_columns.equalsIgnoreCase("")) {
								extra_columns += "; ";
							}
							extra_columns += cell.getStringCellValue().trim();
							
							System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
									+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
									+ "The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
							break;
					}
					
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
					

				}
				
				header = false;
				/*if(!extra_columns.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-extra-columns", extra_columns);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					workbook.close();
					return;
				}*/
				
				if(sampleCollectionId_column < 0){
					column_missing += "sampleCollectionId, ";
				}
				if(hashedSampleId_column < 0){
					column_missing += "hashedSampleId, ";
				}
				if(hashedIndividualId_column < 0){
					column_missing += "hashedIndividualId, ";
				}
				if (materialType_column < 0){
					column_missing += "materialType, ";
				}
				if (container_column < 0){
					column_missing += "container, ";
				}
				if (storageTemperature_column < 0){
					column_missing += "storageTemperature, ";
				}
				if (sampledTime_column < 0){
					column_missing += "sampledTime, ";
				}
				if (anatomicalPartOntology_column < 0){
					column_missing += "anatomicalPartOntology, ";
				}
				if (anatomicalPartOntologyVersion_column < 0){
					column_missing += "anatomicalPartOntologyVersion, ";
				}
				if (anatomicalPartOntologyCode_column < 0){
					column_missing += "anatomicalPartOntologyCode, ";
				}
				if (anatomicalPartOntologyDescription_column < 0){
					column_missing += "anatomicalPartOntologyDescription, ";
				}
				if (anatomicalPartFreeText_column < 0){
					column_missing += "anatomicalPartFreeText, ";
				}
				if (sex_column < 0){
					column_missing += "sex, ";
				}
				if (ageLow_column < 0){
					column_missing += "ageLow, ";
				}
				if (ageHigh_column < 0){
					column_missing += "ageHigh, ";
				}
				if (ageUnit_column < 0){
					column_missing += "ageUnit, ";
				}
				if (diseaseOntology_column < 0){
					column_missing += "diseaseOntology, ";
				}
				if (diseaseOntologyVersion_column < 0){
					column_missing += "diseaseOntologyVersion, ";
				}
				if (diseaseOntologyCode_column < 0){
					column_missing += "diseaseOntologyCode, ";
				}
				if (diseaseOntologyDescription_column < 0){
					column_missing += "diseaseOntologyDescription, ";
				}
				if (diseaseFreeText_column < 0){
					column_missing += "diseaseFreeText, ";
				}
				if (countryOfOrigin_column < 0){
					column_missing += "countryOfOrigin, ";
				}
				
				request.setAttribute("xls-header-not-defined-columns-missing", column_missing);
				SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
				workbook.close();
				return;
					
					

				

			}
			else{

				rowcount ++;

				Sample sample = new SampleImpl();
				sample.setUuid_(uuid_);
				long sampleDbId = CounterLocalServiceUtil.increment();
				sample.setSampleDbId(sampleDbId);
				
				//Try to add sampleCollectionId
				try{
					sample.setSampleCollectionId(fmt.formatCellValue(row.getCell(sampleCollectionId_column)));
				}
				catch(Exception e){
					sample.setSampleCollectionId("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding sampleCollectionId from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add biobankId
				try{
					//sample.setBiobankId(fmt.formatCellValue(row.getCell(biobankId_column)));
					sample.setBiobankId(biobankId);
				}
				catch(Exception e){
					sample.setBiobankId("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding biobankId from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add hashedSampleId
				try{
					sample.setHashedSampleId(row.getCell(hashedSampleId_column).toString());
				}
				catch(Exception e){
					sample.setHashedSampleId("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding hashedSampleId from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}
				
				//Try to add hashedIndividualId
				try{
					sample.setHashedIndividualId(row.getCell(hashedIndividualId_column).toString());
				}
				catch(Exception e){
					sample.setHashedIndividualId("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding hashedIndividualId from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add materialType
				try{
					sample.setMaterialType(row.getCell(materialType_column).toString());
				}
				catch(Exception e){
					sample.setMaterialType("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding materialType from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add container
				try{
					sample.setContainer(row.getCell(container_column).toString());
				}
				catch(Exception e){
					sample.setContainer("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding container from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add storageTemperature
				try{
					sample.setStorageTemperature(row.getCell(storageTemperature_column).toString());
				}
				catch(Exception e){
					sample.setStorageTemperature("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding storageTemperature from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add sampledTime
				try{
					//sample.setSampledTime(sdf.parse(row.getCell(sampledTime_column).toString()));
					sample.setSampledTime(sdf.parse(sdf.format(row.getCell(sampledTime_column).getDateCellValue())));
				}
				catch(Exception e){
					sample.setSampledTime(null);
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding sampledTime from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add anatomicalPartOntology
				try{
					sample.setAnatomicalPartOntology(row.getCell(anatomicalPartOntology_column).toString());
				}
				catch(Exception e){
					sample.setAnatomicalPartOntology("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding anatomicalPartOntology from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add anatomicalPartOntologyVersion
				try{
					sample.setAnatomicalPartOntologyVersion(row.getCell(anatomicalPartOntologyVersion_column).toString());
				}
				catch(Exception e){
					sample.setAnatomicalPartOntologyVersion("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding anatomicalPartOntologyVersion from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add anatomicalPartOntologyCode
				try{
					sample.setAnatomicalPartOntologyCode(row.getCell(anatomicalPartOntologyCode_column).toString());
				}
				catch(Exception e){
					sample.setAnatomicalPartOntologyCode("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding anatomicalPartOntologyCode from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add anatomicalPartOntologyDescription
				try{
					sample.setAnatomicalPartOntologyDescription(row.getCell(anatomicalPartOntologyDescription_column).toString());
				}
				catch(Exception e){
					sample.setAnatomicalPartOntologyDescription("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding anatomicalPartOntologyDescription from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add anatomicalPartFreeText
				try{
					sample.setAnatomicalPartFreeText(row.getCell(anatomicalPartFreeText_column).toString());
				}
				catch(Exception e){
					sample.setAnatomicalPartFreeText("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding anatomicalPartFreeText from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add sex
				try{
					sample.setSex(row.getCell(sex_column).toString());
				}
				catch(Exception e){
					sample.setSex("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding sex from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add ageHigh
				try{
					sample.setAgeHigh(Long.valueOf(fmt.formatCellValue(row.getCell(ageHigh_column))));
				}
				catch(Exception e){
					sample.setAgeHigh(0);
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding ageHigh from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add ageLow
				try{
					sample.setAgeLow(Long.valueOf(fmt.formatCellValue(row.getCell(ageLow_column))));
				}
				catch(Exception e){
					sample.setAgeLow(0);
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding ageLow from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add ageUnit
				try{
					sample.setAgeUnit(row.getCell(ageUnit_column).toString());
				}
				catch(Exception e){
					sample.setAgeUnit("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding ageUnit from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add diseaseOntology
				try{
					sample.setDiseaseOntology(row.getCell(diseaseOntology_column).toString());
				}
				catch(Exception e){
					sample.setDiseaseOntology("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding diseaseOntology from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add diseaseOntologyVersion
				try{
					sample.setDiseaseOntologyVersion(row.getCell(diseaseOntologyVersion_column).toString());
				}
				catch(Exception e){
					sample.setDiseaseOntologyVersion("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding diseaseOntologyVersion from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add diseaseOntologyCode
				try{
					sample.setDiseaseOntologyCode(row.getCell(diseaseOntologyCode_column).toString());
				}
				catch(Exception e){
					sample.setDiseaseOntologyCode("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding diseaseOntologyCode from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add diseaseOntologyDescription
				try{
					sample.setDiseaseOntologyDescription(row.getCell(diseaseOntologyDescription_column).toString());
				}
				catch(Exception e){
					sample.setDiseaseOntologyDescription("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding diseaseOntologyDescription from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				//Try to add diseaseFreeText
				try{
					sample.setDiseaseFreeText(row.getCell(diseaseFreeText_column).toString());
				}
				catch(Exception e){
					sample.setDiseaseFreeText("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding diseaseFreeText from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}
				
				//Try to add countryOfOrigin
				try{
					sample.setCountryOfOrigin(row.getCell(countryOfOrigin_column).toString());
				}
				catch(Exception e){
					sample.setCountryOfOrigin("");
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding countryOfOrigin from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
				}

				sampleList.add(sample);
				//SampleLocalServiceUtil.addSample(sample);
				//request.setAttribute("sample", sample);
				
				

			}
			
			if(errorStr != ""){
				for(Sample sample : sampleList){
					SampleLocalServiceUtil.addSample(sample);
				}
				
				if(importLog){
					SampleImportLog sampleImportLog = new SampleImportLogImpl();
					sampleImportLog.setUuid(uuid_);
					long importId = CounterLocalServiceUtil.increment();
					sampleImportLog.setImportId(importId);
					sampleImportLog.setFileName(sourceFileName);
					sampleImportLog.setUserId(PortalUtil.getUserId(request));
					sampleImportLog.setDateOfImport(new Date());
					SampleImportLogLocalServiceUtil.addSampleImportLog(sampleImportLog);
					importLog = false;
				}
			}

		}
		
		/*if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}*/
		
		workbook.close();
		
		return;
	}

	private void readXLSFile(InputStream inputStream, ActionRequest request) {
		// TODO Auto-generated method stub
		System.out.println("readXLSFile");
	}
	
	
	private String stringFromCell(Cell cell) {
		if(cell == null) {
			return "";
		}
		String returnvalue = "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				returnvalue = String.valueOf((long) cell.getNumericCellValue()).trim();
				break;
			case Cell.CELL_TYPE_STRING:
				returnvalue = cell.getStringCellValue().trim();
				break;
			default:
				returnvalue = cell.getStringCellValue().trim();
				break;
		}
		
		return returnvalue;
	}

}
