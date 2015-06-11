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

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
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
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
		
		System.out.println("Usable Space "+folder.getUsableSpace());
		System.out.println("Absolute File Path "+filePath.getAbsolutePath());
		System.out.println("Total Space "+filePath.getTotalSpace());
		System.out.println("Free Space "+filePath.getFreeSpace());
		System.out.println("Name "+filePath.getName());
		System.out.println("Is absolute "+filePath.isAbsolute());
		System.out.println("Separator "+filePath.separator);
		System.out.println("Can Read "+filePath.canRead());
		System.out.println("Can Write "+filePath.canWrite());
		System.out.println("Set Readable "+filePath.setReadable(true));
		System.out.println("Set Writable "+filePath.setWritable(true));
		
		// Move the existing temporary file to new location.
		FileUtil.copyFile(uploadedFile, filePath);
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(uploadedFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error on Reading File" + e.getMessage());
		}
		if(uploadedFile.toString().endsWith("xls")) {
			readXLSFile(inputStream, request);
		} else if(uploadedFile.toString().endsWith("xlsx")) {
			readXLSXFile(inputStream, request);
		} else {
			SessionErrors.add(request, "file-upload-wrong-type");
			response.setRenderParameter("success", "false");
		}
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
		
		/*Row headerRow = sheet.getRow(0);
		for (Cell cell : headerRow) {
			String cellValue = cell.getRichStringCellValue().toString();
			System.out.println(cellValue);
		}*/
		
		Iterator<Row> rowIterator = sheet.iterator();
		
		boolean header = true;
		int rowcount = 1;
		String rowerrors = "";
		
		int sampleId_column = -1;
		int sampleCollectionDbId_column = -1;
		int biobankDbId_column = -1;
		int hashedSampleId_column = -1;
		int materialType_column = -1;
		int container_column = -1;
		int storageTemperature_column = -1;
		int sampledTime_column = -1;
		int anatomicalPartOntology_column = -1;
		int anatomicalPartOntologyVersion_column = -1;
		int anatomicalPartOntologyCode_column = -1;
		int anatomicalPartDescription_column = -1;
		int anatomicalPartFreeText_column = -1;
		int sex_column = -1;
		int ageHigh_column = -1;
		int ageLow_column = -1;
		int ageUnit_column = -1;
		int diseaseOntology_column = -1;
		int diseaseOntologyVersion_column = -1;
		int diseaseOntologyCode_column = -1;
		int diseaseDescription_column = -1;
		int diseaseFreeText_column = -1;
		
		
		while (rowIterator.hasNext()) {
			//Row row = rowIterator.next();
			XSSFRow row = (XSSFRow) rowIterator.next();
			
			int cellcounter = 0;
			if (header) {
				Iterator<Cell> cellIterator = row.cellIterator();
				String column_missing = "";
				
				while (cellIterator.hasNext()) {
					//Cell cell = cellIterator.next();
					XSSFCell cell = (XSSFCell)cellIterator.next();
					
					switch(cell.getStringCellValue().trim()){
						case "sampleId":
							sampleId_column = cellcounter;
							break;
						case "sampleCollectionDbId":
							sampleCollectionDbId_column = cellcounter;
							break;
						case "biobankDbId":
							biobankDbId_column = cellcounter;
							break;
						case "hashedSampleId":
							hashedSampleId_column = cellcounter;
							break;
						case "materialType":
							materialType_column = cellcounter;
							break;
						case "container":
							container_column = cellcounter;
							break;
						case "storageTemperature":
							storageTemperature_column = cellcounter;
							break;
						case "sampledTime":
							sampledTime_column = cellcounter;
							break;
						case "anatomicalPartOntology":
							anatomicalPartOntology_column = cellcounter;
							break;
						case "anatomicalPartOntologyVersion":
							anatomicalPartOntologyVersion_column = cellcounter;
							break;
						case "anatomicalPartOntologyCode":
							anatomicalPartOntologyCode_column = cellcounter;
							break;
						case "anatomicalPartDescription":
							anatomicalPartDescription_column = cellcounter;
							break;
						case "anatomicalPartFreeText":
							anatomicalPartFreeText_column = cellcounter;
							break;
						case "sex":
							sex_column = cellcounter;
							break;
						case "ageHigh":
							ageHigh_column = cellcounter;
							break;
						case "ageLow":
							ageLow_column = cellcounter;
							break;
						case "ageUnit":
							ageUnit_column = cellcounter;
							break;
						case "diseaseOntology":
							diseaseOntology_column = cellcounter;
							break;
						case "diseaseOntologyVersion":
							diseaseOntologyVersion_column = cellcounter;
							break;
						case "diseaseOntologyCode":
							diseaseOntologyCode_column = cellcounter;
							break;
						case "diseaseDescription":
							diseaseDescription_column = cellcounter;
							break;
						case "diseaseFreeText":
							diseaseFreeText_column = cellcounter;
							break;
						default:
							if(!column_missing.equalsIgnoreCase("")) {
			        			column_missing += ";";
			        		}
			        		column_missing += cell.getStringCellValue().trim();
			        		System.err.println("[" + date_format_apache_error.format(new Date()) + "] "
			        				+ "[info] [BCNetBiobank-portlet::com.bcnet.portlet.sample::readXLSXFile] "
			        				+ "The field " + cell.getStringCellValue().trim() + " could not be mapped for header.");
					}
					System.out.println("Header: " + cellcounter + ":" + cell.getStringCellValue());
					cellcounter++;
					
					/*switch (cell.getCellType()) {
		                //case Cell.CELL_TYPE_STRING:
						case XSSFCell.CELL_TYPE_STRING:
		                    System.out.println("String "+cell.getRichStringCellValue().getString());
		                    break;
		                //case Cell.CELL_TYPE_NUMERIC:
						case XSSFCell.CELL_TYPE_NUMERIC:
		                    if (DateUtil.isCellDateFormatted(cell)) {
		                        System.out.println("Date Numeric "+cell.getDateCellValue());
		                        System.out.println(new CellDateFormatter(cell.getCellStyle().getDataFormatString()).format(cell.getDateCellValue()));
		                    } else {
		                        System.out.println("Numeric "+cell.getNumericCellValue());
		                        cell.setCellType(Cell.CELL_TYPE_STRING);
		                    }
		                    break;
		                //case Cell.CELL_TYPE_BOOLEAN:
						case XSSFCell.CELL_TYPE_BOOLEAN:
		                    System.out.println("Boolean "+cell.getBooleanCellValue());
		                    break;
		                //case Cell.CELL_TYPE_FORMULA:
						case XSSFCell.CELL_TYPE_FORMULA:
		                    System.out.println("Formula "+cell.getCellFormula());
		                    break;
		                default:
		                    System.out.println();
					}*/
					/*SampleImpl sample = new SampleImpl();
					sample.setSampleId(Long.valueOf(cell.toString()));
					//sample.setSampleId(Long.valueOf(stringFromCell(cell)));
					sample.setSampleCollectionDbId(Long.valueOf(cell.toString()));
					sample.setBiobankDbId(Long.valueOf(cell.toString()));
					sample.setHashedSampleId(cell.toString());
					sample.setMaterialType(cell.toString());
					sample.setContainer(cell.toString());
					sample.setStorageTemperature(cell.toString());
					sample.setSampledTime(cell.toString());
					sample.setAnatomicalPartOntology(cell.toString());
					sample.setAnatomicalPartOntologyVersion(cell.toString());
					sample.setAnatomicalPartOntologyCode(cell.toString());
					sample.setAnatomicalPartDescription(cell.toString());
					sample.setAnatomicalPartFreeText(cell.toString());
					sample.setSex(cell.toString());
					sample.setAgeHigh(Long.valueOf(cell.toString()));
					sample.setAgeLow(Long.valueOf(cell.toString()));
					sample.setAgeUnit(cell.toString());
					sample.setDiseaseOntology(cell.toString());
					sample.setDiseaseOntologyVersion(cell.toString());
					sample.setDiseaseOntologyCode(cell.toString());
					sample.setDiseaseDescription(cell.toString());
					sample.setDiseaseFreeText(cell.toString());
					
					SampleLocalServiceUtil.addSample(sample);*/
					//System.out.println(cell);
				}
				
				request.setAttribute("xls-header-not-defined-column_missing", column_missing);
				SessionMessages.add(request, "xls-header-not-defined");
				header = false;
				
			}
			else{
				rowcount ++;
				try{
					SampleImpl sample = new SampleImpl();
					sample.setSampleId(Long.valueOf(fmt.formatCellValue(row.getCell(sampleId_column))));
					sample.setSampleCollectionDbId(Long.valueOf(fmt.formatCellValue(row.getCell(sampleCollectionDbId_column))));
					sample.setBiobankDbId(Long.valueOf(fmt.formatCellValue(row.getCell(biobankDbId_column))));
					sample.setHashedSampleId(row.getCell(hashedSampleId_column).toString());
					sample.setMaterialType(row.getCell(materialType_column).toString());
					sample.setContainer(row.getCell(container_column).toString());
					sample.setStorageTemperature(row.getCell(storageTemperature_column).toString());
					//sample.setSampledTime(sdf.parse(row.getCell(sampledTime_column).toString()));
					sample.setAnatomicalPartOntology(row.getCell(anatomicalPartOntology_column).toString());
					sample.setAnatomicalPartOntologyVersion(row.getCell(anatomicalPartOntologyVersion_column).toString());
					sample.setAnatomicalPartOntologyCode(row.getCell(anatomicalPartOntologyCode_column).toString());
					sample.setAnatomicalPartDescription(row.getCell(anatomicalPartDescription_column).toString());
					sample.setAnatomicalPartFreeText(row.getCell(anatomicalPartFreeText_column).toString());
					sample.setSex(row.getCell(sex_column).toString());
					sample.setAgeHigh(Long.valueOf(fmt.formatCellValue(row.getCell(ageHigh_column))));
					sample.setAgeLow(Long.valueOf(fmt.formatCellValue(row.getCell(ageLow_column))));
					sample.setAgeUnit(row.getCell(ageUnit_column).toString());
					sample.setDiseaseOntology(row.getCell(diseaseOntology_column).toString());
					sample.setDiseaseOntologyVersion(row.getCell(diseaseOntologyVersion_column).toString());
					sample.setDiseaseOntologyCode(row.getCell(diseaseOntologyCode_column).toString());
					sample.setDiseaseDescription(row.getCell(diseaseDescription_column).toString());
					sample.setDiseaseFreeText(row.getCell(diseaseFreeText_column).toString());
					
					//sample.setSampledTime(row.getCell(sampledTime_column).toString());
					/*sample.setSampleCollectionDbId(Long.valueOf(cell.toString()));
					sample.setBiobankDbId(Long.valueOf(cell.toString()));
					
					sample.setMaterialType(cell.toString());
					sample.setContainer(cell.toString());
					sample.setStorageTemperature(cell.toString());
					sample.setSampledTime(cell.toString());
					sample.setAnatomicalPartOntology(cell.toString());
					sample.setAnatomicalPartOntologyVersion(cell.toString());
					sample.setAnatomicalPartOntologyCode(cell.toString());
					sample.setAnatomicalPartDescription(cell.toString());
					sample.setAnatomicalPartFreeText(cell.toString());
					sample.setSex(cell.toString());
					sample.setAgeHigh(Long.valueOf(cell.toString()));
					sample.setAgeLow(Long.valueOf(cell.toString()));
					sample.setAgeUnit(cell.toString());
					sample.setDiseaseOntology(cell.toString());
					sample.setDiseaseOntologyVersion(cell.toString());
					sample.setDiseaseOntologyCode(cell.toString());
					sample.setDiseaseDescription(cell.toString());
					sample.setDiseaseFreeText(cell.toString());*/
					
					SampleLocalServiceUtil.addSample(sample);
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
