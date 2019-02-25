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
	
	@Test(priority = 2)
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
	
	@Test(priority = 3)
	public void createRoleWithDuplicateData() {
		 roleDetailsPageObj = adminHomePageObj.clickRoles();
		 roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		 roleCreationPageObj.fillRoleName("managerTen");
		 roleCreationPageObj.fillRoleDescription("tenth manager");
		 roleCreationPageObj.selectRoleType("E");
		 alert = roleCreationPageObj.clickSubmit();
		 System.out.println(alert.getText());
		 alert.accept();
	}
	
	@Test(priority = 4)
	public void createRoleWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		alert = roleCreationPageObj.clickSubmit();
		System.out.println("alert Text");
		alert.accept();
		
	}
	
	@Test(priority = 5)
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("mangerEleven");
		roleCreationPageObj.fillRoleDescription("eleventh manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
	}
	
	@Test(priority = 6)
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleDetailsPageObj = roleCreationPageObj.clickCancle();
	}
	
	//branch creation with valid data
	
	// branch creation with duplicate data
	
	// branch creation with blank data
	
	
	//branch creation reset
	
	//branch creation cancel
	
	
	// employee creation with valid data
	
	//employee creation with duplicate data
	
	// employee creation with blank data
	
	//employee creation reset
	
	//employee creatin cancel
	
	

}
