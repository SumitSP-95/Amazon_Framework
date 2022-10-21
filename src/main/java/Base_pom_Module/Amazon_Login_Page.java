package Base_pom_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Login_Page {
		
		
	// constructor
	public Amazon_Login_Page(WebDriver _driver) {

		PageFactory.initElements(_driver, this);
	}
	
	// in order

	@FindBy(xpath = "//span[text()='& Orders']")
	private WebElement Cart_Button_Tab;

	@FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	private WebElement Amazon_Cart_Empty_TextAquire;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement Sign_up_now_PageOpen;

	public void Cart_PageFind() {
		Cart_Button_Tab.click();
	}

	public String Amazon_Cart_Empty_TextAquire() {
		return Amazon_Cart_Empty_TextAquire.getText();

	}

	public void SignUpPage() {
		Sign_up_now_PageOpen.click();
	}

	
}
