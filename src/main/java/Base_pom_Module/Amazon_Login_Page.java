package Base_pom_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Login_Page {

	
	public Amazon_Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
