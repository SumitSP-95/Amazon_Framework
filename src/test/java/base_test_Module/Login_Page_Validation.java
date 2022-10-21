package base_test_Module;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base_utility_Module.Base_class;

@Listeners(base_utility_Module.Listener.class)
public class Login_Page_Validation extends Base_class {

	@BeforeClass
	public void Initial_Activity() throws IOException {
		Launch_Browser(getpropertyvalue("BN"));
		Initialize();
	}
	@Test
	public void Amazon_Welcome_Text_validation() throws InterruptedException, EncryptedDocumentException, IOException {
		String Actual = amazon_login_page.Amazon_Cart_Empty_TextAquire();
		Static_wait(3);
		String Expecte = utility_class.Get_Excel_Data(0, 0);
		Assert.assertEquals(Actual, Expecte);
	}
	@AfterClass
	public void Terminate_Activity() throws InterruptedException {
		Static_wait(4);
		Quite_Browser();
	}
}
