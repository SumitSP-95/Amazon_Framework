package base_utility_Module;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Utility_class {
	WebDriver ul_driver;

	public Utility_class(WebDriver driver) {
		ul_driver = driver;
	}

	public String Get_Excel_Data(int Row_Ind, int Cell_ind) throws EncryptedDocumentException, IOException {

		FileInputStream File = new FileInputStream("C:\\Users\\Gopal\\Desktop\\Excle1\\Gopal.xlsx");

		Sheet sheet = WorkbookFactory.create(File).getSheet("Amazon");

		Cell cell = sheet.getRow(Row_Ind).getCell(Cell_ind);

		try {
			return cell.getStringCellValue();
		} catch (Exception e) {
			return (int) cell.getNumericCellValue() + "";
		}
	}
}
