package com.bcnet.portlet.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionException;
import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.model.SampleImportLog;
import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.model.impl.SampleImportLogImpl;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
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
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static final String FORM_FILE_INPUT = "fileupload";
	private static final String TEMPLATE_FILE_NAME = "BCNet_SampleImport_Template";
	private static String sourceFileName;
	private static long biobankDbId;
	private String errorStr;
	
	public void uploadSample(ActionRequest request, ActionResponse response) throws IOException, SystemException {
		
		//final String baseDir = "/Users/suyeshamatya/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		final String baseDir = "C:/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		
		//Normally the form data is accessed like ParamUtil.getString(request, "biobankDbId") or request.getParameter("biobankDbId").
		//But since the form has enctype="multipart/form-data", it cannot be accessed via request but instead UploadPortletRequest should be used.
		//So the ways to access the form data in such case will be: ParamUtil.getString(uploadRequest, "biobankDbId") or uploadRequest.getParameter("biobankDbId").
		
		biobankDbId = Long.parseLong(uploadRequest.getParameter("biobankDbId"));
		
		long sizeInBytes = uploadRequest.getSize(FORM_FILE_INPUT);
 
		if (sizeInBytes == 0) {
			SessionErrors.add(request, "file-size-zero");
			System.err.println("Received file is 0 bytes!");
			return;
		}
 
		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(FORM_FILE_INPUT);
 
		sourceFileName = uploadRequest.getFileName(FORM_FILE_INPUT);
 
		
		// Where should we store this file?
		File folder = new File(baseDir);
  
		// This is our final file path.
		File filePath = new File(folder.getAbsolutePath() + File.separator + sourceFileName);
				
		// Move the existing temporary file to new location.
		FileUtil.copyFile(uploadedFile, filePath);
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(uploadedFile);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			SessionErrors.add(request, "file-not-found");
			System.err.println("Error on Reading File" + e.getMessage());
			return;
		}
		
		if(uploadedFile.toString().endsWith("xls")) {
			readXLSFile(inputStream, request);
		} 
		else if(uploadedFile.toString().endsWith("xlsx")) {
			readXLSXFile(inputStream, request);
		} 
		else {
			SessionErrors.add(request, "file-upload-wrong-type");
			System.err.println("The file you specified is not the correct type (only xls and xlsx are allowed)");
		}
		
		inputStream.close();
		sendRedirect(request, response);
	}
	
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		String templateFileName = TEMPLATE_FILE_NAME;
		String cmd = resourceRequest.getParameter(Constants.CMD);
		String errorFileName = ParamUtil.getString(resourceRequest, "errorFileName");
		Workbook wb = null;
		
		if(cmd.equalsIgnoreCase("xlsxTemplate")){
			wb = generateXLSXTemplateFile();
			templateFileName += ".xlsx";
		}
		else if(cmd.equalsIgnoreCase("xlsTemplate")){
			wb = generateXLSTemplateFile();
			templateFileName += ".xls";
		}
		
		if(cmd.equalsIgnoreCase("xlsxTemplate") || cmd.equalsIgnoreCase("xlsTemplate")){
			OutputStream out = resourceResponse.getPortletOutputStream();
			resourceResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.addProperty("Content-disposition", "attachment; filename=" + templateFileName);
			wb.write(out);
			out.flush();
			out.close();
		}
			
		if(cmd.equalsIgnoreCase("error")){
			OutputStream errorout = resourceResponse.getPortletOutputStream();
			resourceResponse.setContentType("Content-type: application/octet-stream");
			PortalUtil.getHttpServletResponse(resourceResponse).setHeader("Content-disposition", "attachment; filename=ImportErrorReport("+errorFileName+")"+new Date()+".txt");
			//resourceResponse.addProperty("Content-disposition", "attachment; filename=errorfile.txt");
			if(errorStr != null){
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
		
		// Get the sample sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("sample");
		
		if(sheet == null) {
			SessionErrors.add(request, "xls-sheet-not-found");
			System.err.println("No Sample sheet found.");
			workbook.close();
			return;
		}

		if(sheet.getPhysicalNumberOfRows() < 2){
			SessionErrors.add(request, "xls-sheet-no-data");
			System.err.println("Sample sheet seems to be empty.");
			workbook.close();
			return;
		}
		
		if(sheet.getPhysicalNumberOfRows() > 1000){
			SessionErrors.add(request, "xls-sheet-too-many-rows");
			System.err.println("Sample sheet seems to have too many rows.");
			workbook.close();
			return;
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
					String cellHeaderTitle = null;
					
					try{
						cellHeaderTitle = cell.getStringCellValue().trim();
					}
					catch(IllegalStateException e){
						e.printStackTrace();
						SessionErrors.add(request, "xls-headers-not-string");
						System.err.println("Only string format are allowed for the headers in the excel file.");
						workbook.close();
						return;
					}
						
					
					switch(cellHeaderTitle){
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
						case "ageLow":
							//ageLow_column = cellcounter;
							ageLow_column = cell.getColumnIndex();
							break;
						case "ageHigh":
							//ageHigh_column = cellcounter;
							ageHigh_column = cell.getColumnIndex();
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
									+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUploadPortlet::readXLSXFile] "
									+ "The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
							break;
					}
					
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
					

				}
				
				header = false;
				if(!extra_columns.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-extra-columns", extra_columns);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					workbook.close();
					return;
				}
				
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
				
				if(!column_missing.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-columns-missing", column_missing);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					workbook.close();
					return;
				}

			}
			else{

				rowcount ++;

				Sample sample = new SampleImpl();
				sample.setUuid_(uuid_);
				long sampleDbId = CounterLocalServiceUtil.increment();
				sample.setSampleDbId(sampleDbId);
				
				//Try to add sampleCollectionDbId
				String sampleCollectionId = fmt.formatCellValue(row.getCell(sampleCollectionId_column)).trim();
				if(!sampleCollectionId.equalsIgnoreCase("")){
					try {
						SampleCollection sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollectionBySampleCollectionId(sampleCollectionId);
						sample.setSampleCollectionDbId(sampleCollection.getSampleCollectionDbId());
					} catch (NoSuchSampleCollectionException e) {
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
								+ " Problem adding sampleCollectionId from row " + rowcount + " to the database.");
						e.printStackTrace();
						if(!rowerrors.equalsIgnoreCase("")) {
							rowerrors += "; ";
						}
						rowerrors += rowcount;
						errorStr += " The sampleCollectionId from row " + rowcount + " has not already been created. \n";
					}
				}
				

				//Try to add biobankDbId
				//sample.setBiobankDbId(fmt.formatCellValue(row.getCell(biobankId_column)));
				sample.setBiobankDbId(biobankDbId);

				//Try to add hashedSampleId
				String hashedSampleId = fmt.formatCellValue(row.getCell(hashedSampleId_column)).trim();
				if(hashedSampleId.equalsIgnoreCase("")){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
							+ " Problem adding hashedSampleId from row " + rowcount + " to the database.");
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The hashedSampleId from row " + rowcount + " is empty. \n";
				}
				else{
					sample.setHashedSampleId(hashedSampleId);
				}
					
				//Try to add hashedIndividualId
				String hashedIndividualId = fmt.formatCellValue(row.getCell(hashedIndividualId_column)).trim();
				sample.setHashedIndividualId(hashedIndividualId);

				//Try to add materialType
				String materialType = fmt.formatCellValue(row.getCell(materialType_column)).trim();
				if(materialType.equalsIgnoreCase("")){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
							+ " Problem adding materialType from row " + rowcount + " to the database.");
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The materialType from row " + rowcount + " is empty. \n";
				}
				else{
					sample.setMaterialType(materialType);
				}
					
				//Try to add container
				String container = fmt.formatCellValue(row.getCell(container_column)).trim();
				sample.setContainer(container);

				//Try to add storageTemperature
				String storageTemperature = fmt.formatCellValue(row.getCell(storageTemperature_column)).trim();
				sample.setStorageTemperature(storageTemperature);

				//Try to add sampledTime
				String sampledTime = fmt.formatCellValue(row.getCell(sampledTime_column)).trim();
				if(!sampledTime.equalsIgnoreCase("")){
					try{
						Cell sampledTimeCell = row.getCell(sampledTime_column);
						if(sampledTimeCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							if(DateUtil.isCellDateFormatted(sampledTimeCell)){
								sample.setSampledTime(sdf.parse(sdf.format(sampledTimeCell.getDateCellValue())));
							}
							else{
								System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
										+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
										+ " Problem adding sampledTime from row " + rowcount + " to the database.");
								if(!rowerrors.equalsIgnoreCase("")) {
									rowerrors += "; ";
								}
								rowerrors += rowcount;
								errorStr += " The sampledTime from row " + rowcount + " has incorrect format. \n";
							}
						}
						else{
							System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
									+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
									+ " Problem adding sampledTime from row " + rowcount + " to the database.");
							if(!rowerrors.equalsIgnoreCase("")) {
								rowerrors += "; ";
							}
							rowerrors += rowcount;
							errorStr += " The sampledTime from row " + rowcount + " is not in numeric format. \n";
						}
					}
					catch(IllegalStateException | ParseException  e){
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
								+ " Problem adding sampledTime from row " + rowcount + " to the database.");
						e.printStackTrace();
						if(!rowerrors.equalsIgnoreCase("")) {
							rowerrors += "; ";
						}
						rowerrors += rowcount;
						errorStr += " The sampledTime from row " + rowcount + " has incorrect format. \n";
					}
				}
				

				//Try to add anatomicalPartOntology
				String anatomicalPartOntology = fmt.formatCellValue(row.getCell(anatomicalPartOntology_column)).trim();
				sample.setAnatomicalPartOntology(anatomicalPartOntology);

				//Try to add anatomicalPartOntologyVersion
				String anatomicalPartOntologyVersion = fmt.formatCellValue(row.getCell(anatomicalPartOntologyVersion_column)).trim();
				sample.setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);

				//Try to add anatomicalPartOntologyCode
				String anatomicalPartOntologyCode = fmt.formatCellValue(row.getCell(anatomicalPartOntologyCode_column)).trim();
				sample.setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);

				//Try to add anatomicalPartOntologyDescription
				String anatomicalPartOntologyDescription = fmt.formatCellValue(row.getCell(anatomicalPartOntologyDescription_column)).trim();
				sample.setAnatomicalPartOntologyDescription(anatomicalPartOntologyDescription);

				//Try to add anatomicalPartFreeText
				String anatomicalPartFreeText = fmt.formatCellValue(row.getCell(anatomicalPartFreeText_column)).trim();
				sample.setAnatomicalPartFreeText(anatomicalPartFreeText);
	
				//Try to add sex
				String sex = fmt.formatCellValue(row.getCell(sex_column)).trim();
				sample.setSex(sex);
				
				//Try to add ageLow
				try{
					String ageLowValue = fmt.formatCellValue(row.getCell(ageLow_column)).trim();
					if(!ageLowValue.equals("")){
						long ageLow = Long.valueOf(ageLowValue);
						sample.setAgeLow(ageLow);
					}
				}
				catch(NumberFormatException e){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
							+ " Problem adding ageLow from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The ageLow from row " + rowcount + " is not a number. \n";
				}

				//Try to add ageHigh
				try{
					String ageHighValue = fmt.formatCellValue(row.getCell(ageHigh_column)).trim();
					if(!ageHighValue.equals("")){
						long ageHigh = Long.valueOf(ageHighValue);
						sample.setAgeHigh(ageHigh);
					}
				}
				catch(NumberFormatException e){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSXFile] "
							+ " Problem adding ageHigh from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The ageHigh from row " + rowcount + " is not a number. \n";
				}

				//Try to add ageUnit
				String ageUnit = fmt.formatCellValue(row.getCell(ageUnit_column)).trim();
				sample.setAgeUnit(ageUnit);

				//Try to add diseaseOntology
				String diseaseOntology = fmt.formatCellValue(row.getCell(diseaseOntology_column)).trim();
				sample.setDiseaseOntology(diseaseOntology);

				//Try to add diseaseOntologyVersion
				String diseaseOntologyVersion = fmt.formatCellValue(row.getCell(diseaseOntologyVersion_column)).trim();
				sample.setDiseaseOntologyVersion(diseaseOntologyVersion);

				//Try to add diseaseOntologyCode
				String diseaseOntologyCode = fmt.formatCellValue(row.getCell(diseaseOntologyCode_column)).trim();
				sample.setDiseaseOntologyCode(diseaseOntologyCode);

				//Try to add diseaseOntologyDescription
				String diseaseOntologyDescription = fmt.formatCellValue(row.getCell(diseaseOntologyDescription_column)).trim();
				sample.setDiseaseOntologyDescription(diseaseOntologyDescription);

				//Try to add diseaseFreeText
				String diseaseFreeText = fmt.formatCellValue(row.getCell(diseaseFreeText_column)).trim();
				sample.setDiseaseFreeText(diseaseFreeText);
				
				//Try to add countryOfOrigin
				String countryOfOrigin = fmt.formatCellValue(row.getCell(countryOfOrigin_column)).trim();
				sample.setCountryOfOrigin(countryOfOrigin);

				sampleList.add(sample);
				
				System.out.println(sample);

			}
			
		
		}
		
		if(errorStr.trim().equals("")){
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
		else{
			request.setAttribute("error", errorStr);
			SessionErrors.add(request, "xls-import-errors");
			request.setAttribute("errorFileName", sourceFileName);
		}
		
		if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		
		workbook.close();
		
		return;
	}

	private void readXLSFile(InputStream inputStream, ActionRequest request) throws IOException, SystemException {
		// TODO Auto-generated method stub
		System.out.println("readXLSFile");

		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		
		// Get the sample sheet from the workbook
		HSSFSheet sheet = workbook.getSheet("sample");
		
		if(sheet == null) {
			SessionErrors.add(request, "xls-sheet-not-found");
			System.err.println("No Sample sheet found.");
			workbook.close();
			return;
		}

		if(sheet.getPhysicalNumberOfRows() < 2){
			SessionErrors.add(request, "xls-sheet-no-data");
			System.err.println("Sample sheet seems to be empty.");
			workbook.close();
			return;
		}
		
		if(sheet.getPhysicalNumberOfRows() > 1000){
			SessionErrors.add(request, "xls-sheet-too-many-rows");
			System.err.println("Sample sheet seems to have too many rows.");
			workbook.close();
			return;
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
			HSSFRow row = (HSSFRow) rowIterator.next();
			
			
			
			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				String column_missing = "";
				String extra_columns = "";
				
				while (cellIterator.hasNext()) {
					HSSFCell cell = (HSSFCell)cellIterator.next();
					String cellHeaderTitle = null;
					
					try{
						cellHeaderTitle = cell.getStringCellValue().trim();
					}
					catch(IllegalStateException e){
						e.printStackTrace();
						SessionErrors.add(request, "xls-headers-not-string");
						System.err.println("Only string format are allowed for the headers in the excel file.");
						workbook.close();
						return;
					}
						
					
					switch(cellHeaderTitle){
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
						case "ageLow":
							//ageLow_column = cellcounter;
							ageLow_column = cell.getColumnIndex();
							break;
						case "ageHigh":
							//ageHigh_column = cellcounter;
							ageHigh_column = cell.getColumnIndex();
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
									+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUploadPortlet::readXLSFile] "
									+ "The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
							break;
					}
					
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
					

				}
				
				header = false;
				if(!extra_columns.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-extra-columns", extra_columns);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					workbook.close();
					return;
				}
				
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
				
				if(!column_missing.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-columns-missing", column_missing);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					workbook.close();
					return;
				}

			}
			else{

				rowcount ++;

				Sample sample = new SampleImpl();
				sample.setUuid_(uuid_);
				long sampleDbId = CounterLocalServiceUtil.increment();
				sample.setSampleDbId(sampleDbId);
				
				
				//Try to add sampleCollectionDbId
				String sampleCollectionId = fmt.formatCellValue(row.getCell(sampleCollectionId_column)).trim();
				if(!sampleCollectionId.equalsIgnoreCase("")){
					try {
						SampleCollection sampleCollection = SampleCollectionLocalServiceUtil.getSampleCollectionBySampleCollectionId(sampleCollectionId);
						sample.setSampleCollectionDbId(sampleCollection.getSampleCollectionDbId());
					} catch (NoSuchSampleCollectionException e) {
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
								+ " Problem adding sampleCollectionId from row " + rowcount + " to the database.");
						e.printStackTrace();
						if(!rowerrors.equalsIgnoreCase("")) {
							rowerrors += "; ";
						}
						rowerrors += rowcount;
						errorStr += " The sampleCollectionId from row " + rowcount + " has not already been created. \n";
					}
				}
				

				//Try to add biobankDbId
				//sample.setBiobankDbId(fmt.formatCellValue(row.getCell(biobankId_column)));
				sample.setBiobankDbId(biobankDbId);

				//Try to add hashedSampleId
				String hashedSampleId = fmt.formatCellValue(row.getCell(hashedSampleId_column)).trim();
				if(hashedSampleId.equalsIgnoreCase("")){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
							+ " Problem adding hashedSampleId from row " + rowcount + " to the database.");
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The hashedSampleId from row " + rowcount + " is empty. \n";
				}
				else{
					sample.setHashedSampleId(hashedSampleId);
				}
					
				//Try to add hashedIndividualId
				String hashedIndividualId = fmt.formatCellValue(row.getCell(hashedIndividualId_column)).trim();
				sample.setHashedIndividualId(hashedIndividualId);

				//Try to add materialType
				String materialType = fmt.formatCellValue(row.getCell(materialType_column)).trim();
				if(materialType.equalsIgnoreCase("")){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
							+ " Problem adding materialType from row " + rowcount + " to the database.");
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The materialType from row " + rowcount + " is empty. \n";
				}
				else{
					sample.setMaterialType(materialType);
				}
					
				//Try to add container
				String container = fmt.formatCellValue(row.getCell(container_column)).trim();
				sample.setContainer(container);

				//Try to add storageTemperature
				String storageTemperature = fmt.formatCellValue(row.getCell(storageTemperature_column)).trim();
				sample.setStorageTemperature(storageTemperature);

				//Try to add sampledTime
				String sampledTime = fmt.formatCellValue(row.getCell(sampledTime_column)).trim();
				if(!sampledTime.equalsIgnoreCase("")){
					try{
						Cell sampledTimeCell = row.getCell(sampledTime_column);
						if(sampledTimeCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							if(DateUtil.isCellDateFormatted(sampledTimeCell)){
								sample.setSampledTime(sdf.parse(sdf.format(sampledTimeCell.getDateCellValue())));
							}
							else{
								System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
										+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
										+ " Problem adding sampledTime from row " + rowcount + " to the database.");
								if(!rowerrors.equalsIgnoreCase("")) {
									rowerrors += "; ";
								}
								rowerrors += rowcount;
								errorStr += " The sampledTime from row " + rowcount + " has incorrect format. \n";
							}
						}
						else{
							System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
									+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
									+ " Problem adding sampledTime from row " + rowcount + " to the database.");
							if(!rowerrors.equalsIgnoreCase("")) {
								rowerrors += "; ";
							}
							rowerrors += rowcount;
							errorStr += " The sampledTime from row " + rowcount + " is not in numeric format. \n";
						}
					}
					catch(IllegalStateException | ParseException  e){
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
								+ " Problem adding sampledTime from row " + rowcount + " to the database.");
						e.printStackTrace();
						if(!rowerrors.equalsIgnoreCase("")) {
							rowerrors += "; ";
						}
						rowerrors += rowcount;
						errorStr += " The sampledTime from row " + rowcount + " has incorrect format. \n";
					}
				}
				

				//Try to add anatomicalPartOntology
				String anatomicalPartOntology = fmt.formatCellValue(row.getCell(anatomicalPartOntology_column)).trim();
				sample.setAnatomicalPartOntology(anatomicalPartOntology);

				//Try to add anatomicalPartOntologyVersion
				String anatomicalPartOntologyVersion = fmt.formatCellValue(row.getCell(anatomicalPartOntologyVersion_column)).trim();
				sample.setAnatomicalPartOntologyVersion(anatomicalPartOntologyVersion);

				//Try to add anatomicalPartOntologyCode
				String anatomicalPartOntologyCode = fmt.formatCellValue(row.getCell(anatomicalPartOntologyCode_column)).trim();
				sample.setAnatomicalPartOntologyCode(anatomicalPartOntologyCode);

				//Try to add anatomicalPartOntologyDescription
				String anatomicalPartOntologyDescription = fmt.formatCellValue(row.getCell(anatomicalPartOntologyDescription_column)).trim();
				sample.setAnatomicalPartOntologyDescription(anatomicalPartOntologyDescription);

				//Try to add anatomicalPartFreeText
				String anatomicalPartFreeText = fmt.formatCellValue(row.getCell(anatomicalPartFreeText_column)).trim();
				sample.setAnatomicalPartFreeText(anatomicalPartFreeText);
	
				//Try to add sex
				String sex = fmt.formatCellValue(row.getCell(sex_column)).trim();
				sample.setSex(sex);
				
				//Try to add ageLow
				try{
					String ageLowValue = fmt.formatCellValue(row.getCell(ageLow_column)).trim();
					if(!ageLowValue.equals("")){
						long ageLow = Long.valueOf(ageLowValue);
						sample.setAgeLow(ageLow);
					}
				}
				catch(NumberFormatException e){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
							+ " Problem adding ageLow from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The ageLow from row " + rowcount + " is not a number. \n";
				}

				//Try to add ageHigh
				try{
					String ageHighValue = fmt.formatCellValue(row.getCell(ageHigh_column)).trim();
					if(!ageHighValue.equals("")){
						long ageHigh = Long.valueOf(ageHighValue);
						sample.setAgeHigh(ageHigh);
					}
				}
				catch(NumberFormatException e){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample.SampleUloadPortlet::readXLSFile] "
							+ " Problem adding ageHigh from row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += "; ";
					}
					rowerrors += rowcount;
					errorStr += " The ageHigh from row " + rowcount + " is not a number. \n";
				}

				//Try to add ageUnit
				String ageUnit = fmt.formatCellValue(row.getCell(ageUnit_column)).trim();
				sample.setAgeUnit(ageUnit);

				//Try to add diseaseOntology
				String diseaseOntology = fmt.formatCellValue(row.getCell(diseaseOntology_column)).trim();
				sample.setDiseaseOntology(diseaseOntology);

				//Try to add diseaseOntologyVersion
				String diseaseOntologyVersion = fmt.formatCellValue(row.getCell(diseaseOntologyVersion_column)).trim();
				sample.setDiseaseOntologyVersion(diseaseOntologyVersion);

				//Try to add diseaseOntologyCode
				String diseaseOntologyCode = fmt.formatCellValue(row.getCell(diseaseOntologyCode_column)).trim();
				sample.setDiseaseOntologyCode(diseaseOntologyCode);

				//Try to add diseaseOntologyDescription
				String diseaseOntologyDescription = fmt.formatCellValue(row.getCell(diseaseOntologyDescription_column)).trim();
				sample.setDiseaseOntologyDescription(diseaseOntologyDescription);

				//Try to add diseaseFreeText
				String diseaseFreeText = fmt.formatCellValue(row.getCell(diseaseFreeText_column)).trim();
				sample.setDiseaseFreeText(diseaseFreeText);
				
				//Try to add countryOfOrigin
				String countryOfOrigin = fmt.formatCellValue(row.getCell(countryOfOrigin_column)).trim();
				sample.setCountryOfOrigin(countryOfOrigin);

				sampleList.add(sample);
				
				System.out.println(sample);

			}
			
		
		}
		
		if(errorStr.trim().equals("")){
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
		else{
			request.setAttribute("error", errorStr);
			SessionErrors.add(request, "xls-import-errors");
			request.setAttribute("errorFileName", sourceFileName);
		}
		
		if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}
		
		workbook.close();
		
		return;
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
