package in.srssprojects.keximbank;

import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {
	@BeforeClass(groups = { "datadriven", "role", "employee", "branch", "cancel", "valid", "reset", "invalid",
			"create" })
	public void browserLaunch() {
		launchBrowser(readProperty("br_name"), readProperty("url"));
		bankHomePageObj = new BankHomePage(driver);
	}
}
