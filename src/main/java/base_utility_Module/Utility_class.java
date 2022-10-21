package base_utility_Module;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

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
		
		public void Take_Screen_Shot(String TC_Name) throws IOException {
			

			Date d = new Date();
			SimpleDateFormat DF = new SimpleDateFormat("_mm_ss_hh_dd_MM_yyyy");
			String FormatedDate = DF.format(d);
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\DELL\\Desktop"+TC_Name+FormatedDate+".png");
			FileHandler.copy(src, dest);
        }
	}
}
