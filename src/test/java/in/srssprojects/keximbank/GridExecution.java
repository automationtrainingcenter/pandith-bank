package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {
	@BeforeClass(groups = { "datadriven", "role", "employee", "branch", "cancel", "valid", "reset", "invalid",
			"create" })
	@Parameters({ "url", "browserName", "nodeURL", "os" })
	public void browserLaunch(String u, String brName, String node, String os) {
		launchBrowser(brName, u, node, os);
		bankHomePageObj = new BankHomePage(driver);
	}
}
