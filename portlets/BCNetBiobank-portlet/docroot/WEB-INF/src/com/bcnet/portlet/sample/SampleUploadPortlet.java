package com.bcnet.portlet.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SampleUploadPortlet
 */
public class SampleUploadPortlet extends MVCPortlet {

	public void uploadSample(ActionRequest request, ActionResponse response) throws Exception {
		final int ONE_GB = 1073741824;
		
		final String baseDir = "/Users/suyeshamatya/CodeHome/plugins/liferay-plugins-sdk-6.2/uploaded/";
		
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
		
		Row headerRow = sheet.getRow(0);
		for (Cell cell : headerRow) {
			String cellValue = cell.getRichStringCellValue().toString();
			System.out.println(cellValue);
		}
		
		Iterator<Row> rowIterator = sheet.iterator();
		int counter = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			/*Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.println(cell);
				SampleImpl sample = new SampleImpl();
				sample.setSampleId(Long.valueOf(cell.toString()));
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
				
				SampleLocalServiceUtil.addSample(sample);
			}*/
			counter++;
			System.out.println(counter);
		}
		System.out.println("Counter: "+counter);
	}

	private void readXLSFile(InputStream inputStream, ActionRequest request) {
		// TODO Auto-generated method stub
		System.out.println("readXLSFile");
	}

}
