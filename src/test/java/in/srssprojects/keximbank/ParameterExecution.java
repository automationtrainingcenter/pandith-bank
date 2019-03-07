package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class ParameterExecution extends TestExecution{
	@BeforeClass(groups = {"datadriven", "role", "employee", "branch", "cancel", "valid", "reset", "invalid", "create"})
	@Parameters({"url", "browserName"})
	public void browserLaunch(String u, String brName) {
		launchBrowser(brName, u);
		bankHomePageObj = new BankHomePage(driver);
	}
}
