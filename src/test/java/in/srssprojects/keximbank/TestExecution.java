package in.srssprojects.keximbank;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestExecution extends BaseClass {
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	RolesDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	Alert alert;
	String alertText;

	@BeforeClass
	public void browserLaunch() {
		launchBrowser(readProperty("br_name"), readProperty("url"));
		bankHomePageObj = new BankHomePage(driver);
	}

	@Test(priority = 1)
	public void loginTest() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPasword("Admin");
		bankHomePageObj.clickLogin();
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePageObj.isAdminHomePageDisplayed());
	}

	@Test(priority = 2)
	public void createRole() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("managerTwenty");
		roleCreationPageObj.fillRoleDescription("tenth manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came "+alertText);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "created Sucessfully"));
	}

	@Test(priority = 3, dependsOnMethods = {"createRole"})
	public void createRoleWithDuplicateData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("managerTen");
		roleCreationPageObj.fillRoleDescription("tenth manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came "+alertText);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "already existed"));
	}

	@Test(priority = 4)
	public void createRoleWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came "+alertText, true);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "please fill in the following fields"));

	}

	@Test(priority = 5)
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("mangerEleven");
		roleCreationPageObj.fillRoleDescription("eleventh manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
		Assert.assertTrue(roleCreationPageObj.isRoleNameEmpty());
	}

	@Test(priority = 6)
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleDetailsPageObj = roleCreationPageObj.clickCancle();
		Assert.assertTrue(roleDetailsPageObj.isNewRoleButtonDisplayed());
	}

	// branch creation with valid data

	// branch creation with duplicate data

	// branch creation with blank data

	// branch creation reset

	// branch creation cancel

	// employee creation with valid data

	// employee creation with duplicate data

	// employee creation with blank data

	// employee creation reset

	// employee creation cancel
	
	@AfterClass
	public void closeBrowser() {
		adminHomePageObj.clickLogout();
		driver.close();
	}

}
