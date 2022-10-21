package base_utility_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import Base_pom_Module.Amazon_Login_Page;

public class Base_class {
	
	public static WebDriver driver;
	public static Amazon_Login_Page amazon_login_page;
	public static SoftAssert softassert;
	public static Utility_class utility_class;
	
	
	public static void Initialize() {
		amazon_login_page = new Amazon_Login_Page(driver);
		softassert = new SoftAssert();
		utility_class = new Utility_class(driver);
		
	}
	public static Properties properties;
	
	public static String getpropertyvalue(String key) throws IOException {
		
		properties = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\user\\git\\Amazon_Framewor\\src\\test\\resources\\Property_File_Only\\Property_Amazon.properties");
		
		properties.load(file);
		
		return properties.getProperty(key);
	}
	public static void Launch_Browser(String Browser_Name) throws IOException {
		
		if (Browser_Name.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Automation Tools\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			Reporter.log("Launching Browser Chrome",true);
			driver = new ChromeDriver();
		}else if(Browser_Name.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Automation Tools\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			Reporter.log("Launching Browser FireFox",true);
			driver = new FirefoxDriver();
		}else {
			Reporter.log("No browser found with given name = "+Browser_Name,true);
		}
		driver.manage().window().maximize();
		driver.get(getpropertyvalue("URL"));

	}
	public static void Quite_Browser() throws InterruptedException {
		Static_wait(5);
		driver.quit();
	}
	
	public static void Static_wait(int sec) throws InterruptedException {
		try {
			Thread.sleep(sec*1000);
		} catch (Exception e) {
			// TODO: handle exception
			Reporter.log("Unable to Wait",true);
		}
		
	}
	
}
