package base_utility_Module;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("On test failure Block running",true);
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("On test success Block running",true);
		try {
			Base_class.utility_class.Take_Screen_Shot(result.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("On test Skip Block running",true);
		
	}

	
	
}
