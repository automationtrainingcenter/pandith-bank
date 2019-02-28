package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestExecution {
	WebDriver driver;
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	RolesDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	BranchDetailsPage branchdetailobj;
	BranchCreationPage branchcreationobj;
	Alert alert;

	@Test(priority = 0)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.srssprojects.in");
		bankHomePageObj = new BankHomePage(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPasword("Admin");
		bankHomePageObj.clickLogin();
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
	}

	@Test(priority = 3)
	public void createRole() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("managerTen");
		roleCreationPageObj.fillRoleDescription("tenth manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(priority = 2)
	public void branckinfo() throws Exception {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		// driver.switchTo().frame(0);
		System.out.println("clicked on new barnch");
		branchcreationobj.branchnam("computerscience");
		Thread.sleep(1000);
		branchcreationobj.aDDress("7-8-78 hyderabad");
		branchcreationobj.aDDress2("H-no 4-58-95 hyderabad");
		branchcreationobj.aDDress3("h no:5-698  secendrabad");
		// alert.accept();
		branchcreationobj.aDDress3(" na 523 plot num chandanager");

		branchcreationobj.aRea("hyderabad");
		branchcreationobj.zIPcod("502032");
		Thread.sleep(1000);

		branchcreationobj.selcontry("INDIA");
		Thread.sleep(1000);
		branchcreationobj.selstate("GOA");
		Thread.sleep(1000);
		branchcreationobj.seltcity("GOA");

		alert = branchcreationobj.subbutton();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("sucessfuly searched the information");

	}
}
