package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\panke\\eclipse-workspace\\E1-Vtiger-crm\\src\\test\\resources\\commonData.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value= pobj.getProperty(key);
		return value;
		

	}
	
	
	public String getDataFromExcelFile(String sheetName,int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\panke\\eclipse-workspace\\E1-Vtiger-crm\\src\\test\\resources\\org.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		JavaUtility jutil = new JavaUtility();
		 String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue() + jutil.generateRandomNumber();
		 
		return value;
		
	}
	
	


}
