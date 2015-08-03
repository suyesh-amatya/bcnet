package com.bcnet.portlet.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
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
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	
	
	public void uploadSample(ActionRequest request, ActionResponse response) throws Exception {
		
		final int ONE_GB = 1073741824;
		
		//final String baseDir = "/Users/suyeshamatya/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		final String baseDir = "C:/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		
		final String fileInputName = "fileupload";
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		System.out.println(uploadRequest.getFileName(fileInputName));
		 
		long sizeInBytes = uploadRequest.getSize(fileInputName);
 
		if (uploadRequest.getSize(fileInputName) == 0) {
			throw new Exception("Received file is 0 bytes!");
		}
 
		// Get the uploaded file as a file.
		File uploadedFile = uploadRequest.getFile(fileInputName);
 
		String sourceFileName = uploadRequest.getFileName(fileInputName);
 
		
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

		boolean header = true;
		int rowcount = 1;
		String rowerrors = "";

		int sampleCollectionId_column = -1;
		int biobankId_column = -1;
		int hashedSampleId_column = -1;
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


		while (rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();

			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				String column_missing = "";

				while (cellIterator.hasNext()) {
					XSSFCell cell = (XSSFCell)cellIterator.next();
					System.out.println("CID"+cell.getColumnIndex());
					switch(cell.getStringCellValue().trim()){
					case "sampleCollectionId":
						//sampleCollectionId_column = cellcounter;
						sampleCollectionId_column = cell.getColumnIndex();
						break;
					case "biobankId":
						//biobankId_column = cellcounter;
						biobankId_column = cell.getColumnIndex();
						break;
					case "hashedSampleId":
						//hashedSampleId_column = cellcounter;
						hashedSampleId_column = cell.getColumnIndex();
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
					default:
						if(!column_missing.equalsIgnoreCase("")) {
							column_missing += "; ";
						}
						column_missing += cell.getStringCellValue().trim();
						System.err.println(column_missing);
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
								+ "The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
					}
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;

				}
				if(!column_missing.equalsIgnoreCase("")){
					request.setAttribute("xls-header-not-defined-columns-missing", column_missing);
					SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					return;
				}

				header = false;

			}
			else{
				rowcount ++;
				try{
					SampleImpl sample = new SampleImpl();
					long sampleDbId = CounterLocalServiceUtil.increment();
					sample.setSampleDbId(sampleDbId);
					try{
						sample.setSampleCollectionId(fmt.formatCellValue(row.getCell(sampleCollectionId_column)));
					}
					catch(Exception e){
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
								+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
								+ " Problem adding row " + rowcount + " to the database. Make sure the header of the column is \"sampleCollectionId\"");
					}
					sample.setBiobankId(fmt.formatCellValue(row.getCell(biobankId_column)));
					sample.setHashedSampleId(row.getCell(hashedSampleId_column).toString());
					sample.setMaterialType(row.getCell(materialType_column).toString());
					sample.setContainer(row.getCell(container_column).toString());
					sample.setStorageTemperature(row.getCell(storageTemperature_column).toString());
					sample.setSampledTime(sdf.parse(row.getCell(sampledTime_column).toString()));
					sample.setAnatomicalPartOntology(row.getCell(anatomicalPartOntology_column).toString());
					sample.setAnatomicalPartOntologyVersion(row.getCell(anatomicalPartOntologyVersion_column).toString());
					sample.setAnatomicalPartOntologyCode(row.getCell(anatomicalPartOntologyCode_column).toString());
					sample.setAnatomicalPartOntologyDescription(row.getCell(anatomicalPartOntologyDescription_column).toString());
					sample.setAnatomicalPartFreeText(row.getCell(anatomicalPartFreeText_column).toString());
					sample.setSex(row.getCell(sex_column).toString());
					sample.setAgeHigh(Long.valueOf(fmt.formatCellValue(row.getCell(ageHigh_column))));
					sample.setAgeLow(Long.valueOf(fmt.formatCellValue(row.getCell(ageLow_column))));
					sample.setAgeUnit(row.getCell(ageUnit_column).toString());
					sample.setDiseaseOntology(row.getCell(diseaseOntology_column).toString());
					sample.setDiseaseOntologyVersion(row.getCell(diseaseOntologyVersion_column).toString());
					sample.setDiseaseOntologyCode(row.getCell(diseaseOntologyCode_column).toString());
					sample.setDiseaseOntologyDescription(row.getCell(diseaseOntologyDescription_column).toString());
					sample.setDiseaseFreeText(row.getCell(diseaseFreeText_column).toString());

					SampleLocalServiceUtil.addSample(sample);
					request.setAttribute("sample", sample);

				}
				catch(Exception e){
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
							+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
							+ " Problem adding row " + rowcount + " to the database.");
					e.printStackTrace();
					if(!rowerrors.equalsIgnoreCase("")) {
						rowerrors += ";";
					}
					rowerrors += rowcount;
				}



			}



		}
		if(!rowerrors.equalsIgnoreCase("")) {
			request.setAttribute("xls-row-import-errors", rowerrors);
			SessionMessages.add(request, "xls-row-import-errors");
		}
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
