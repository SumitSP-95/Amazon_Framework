package base_utility_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;



public class Base_class {
	
	public static WebDriver driver;
	public static Amazon_login amazon_login;
	
	
	public static void Initialize() {
		
		amazon_login = new Amazon_login(driver);
		
	}
	
	
	public static Properties properties;
	
	public static String getpropertyvalue(String key) throws IOException {
		
		properties = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\user\\git\\Amazon_Framewor\\src\\test\\resources\\Property_File_Only\\Property_Amazon.properties");
		
		properties.load(file);
		
		return properties.getProperty(key);
	}
	public static void Launch_Browser(String Browser_Name) throws IOException {
		
		switch (Browser_Name) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Automation Tools\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			
			driver = new ChromeDriver();
			break;
		case "FireFox":
			System.setProperty("webdriver.gecko.driver","D:\\Automation Tools\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			break;
		default:
			Reporter.log("No browser found with given name = "+Browser_Name,true);
			break;
		}
		driver.manage().window().maximize();
		driver.get(getpropertyvalue("URL"));

	}
	public static void Quite_Browser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	public static void Static_wait(int sec) throws InterruptedException {
		Thread.sleep(sec*1000);
	}
	
}
