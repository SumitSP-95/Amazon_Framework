package base_utility_Module;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Utility_class {

	WebDriver driver;
	public Utility_class(WebDriver _driver) {
		driver = _driver;
	}
	
	
	public String Get_deta(int Row_Ind,int Column_Ind) throws EncryptedDocumentException, IOException {
		
		FileInputStream DCTC = new FileInputStream("C:\\Users\\Gopal\\Desktop\\Excle1\\Gopal.xlxe");
	    
		Sheet Amazon = WorkbookFactory.create(DCTC).getSheet("Amazon");
		
		Cell cell_Info = Amazon. getRow(Row_Ind).getCell(Column_Ind);
		
		try {
			return cell_Info.getStringCellValue();
		} catch (Exception e) {
			return cell_Info.getNumericCellValue()+"";
		}
		
	}
	
}
