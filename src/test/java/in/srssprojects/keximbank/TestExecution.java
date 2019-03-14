package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestExecution extends BaseClass {
	BankHomePage bankHomePageObj;
	AdminHomePage adminHomePageObj;
	RolesDetailsPage roleDetailsPageObj;
	RoleCreationPage roleCreationPageObj;
	BranchDetailsPage branchdetailobj;
	BranchCreationPage branchcreationobj;
	EmployeeCreation employeeCreationobj;
	EmployeeDetails employeeDetailsobj;

	Alert alert;
	String alertText;
	ExcelHelper excel;

	@Test(priority = 1, groups = { "datadriven", "role", "employee", "branch", "cancel", "valid", "reset", "invalid",
			"create" })
	public void loginTest() {
		bankHomePageObj.fillUserName("Admin");
		bankHomePageObj.fillPasword("Admin");
		bankHomePageObj.clickLogin();
		adminHomePageObj = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePageObj.isAdminHomePageDisplayed());
	}

	@Test(priority = 2, groups = { "role", "create", "valid", })
	public void createRole() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("managerTwenty");
		roleCreationPageObj.fillRoleDescription("tenth manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came " + alertText);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "created Sucessfully"));
	}

	@Test(priority = 3, dependsOnMethods = { "createRole" }, groups = { "role", "create", "invalid" })
	public void createRoleWithDuplicateData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("managerTen");
		roleCreationPageObj.fillRoleDescription("tenth manager");
		roleCreationPageObj.selectRoleType("E");
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came " + alertText);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "already existed"));
	}

	@Test(priority = 4, groups = { "role", "create", "invalid" })
	public void createRoleWithBlankData() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came " + alertText, true);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "please fill in the following fields"));

	}

	@Test(priority = 5, groups = { "role", "reset", "valid" })
	public void roleCreationReset() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName("mangerEleven");
		roleCreationPageObj.fillRoleDescription("eleventh manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
		Assert.assertTrue(roleCreationPageObj.isRoleNameEmpty());
	}

	@Test(priority = 6, groups = { "role", "cancel", "valid" })
	public void roleCreationCancel() {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleDetailsPageObj = roleCreationPageObj.clickCancle();
		Assert.assertTrue(roleDetailsPageObj.isNewRoleButtonDisplayed());
	}

	// branch creation with valid data
	@Test(priority = 8, groups = { "branch", "create", "valid" })
	public void branchCreationValidData() throws InterruptedException {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
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

	// branch creation with duplicate data
	@Test(priority = 9, groups = { "branch", "create", "invalid" })
	public void branchCreationDuplicateData() throws Exception {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
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

	// branch creation with blank data
	@Test(priority = 11, groups = { "branch", "create", "invalid" })
	public void branchCreaitonBlankData() throws Exception {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		alert = branchcreationobj.subbutton();
		System.out.println(alert.getText());
		alert.accept();
	}

	// branch creation reset
	@Test(priority = 12, groups = { "branch", "reset", "valid" })
	public void resetData() throws Exception {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		System.out.println("clicked on new barnch");
		branchcreationobj.branchnam("electronics");
		branchcreationobj.aDDress("7-81-78 hyderabad");
		branchcreationobj.aDDress2("H-no 41-58-95 hyderabad");
		branchcreationobj.aDDress3("h no:54-698  secendrabad");
		branchcreationobj.aRea("hyb");
		branchcreationobj.zIPcod("502036");
		branchcreationobj.selcontry("INDIA");
		branchcreationobj.selstate("GOA");
		branchcreationobj.seltcity("GOA");
		branchcreationobj.clickrest();
	}

	// branch creation cancel
	@Test(priority = 13, groups = { "branch", "cancel", "valid" })
	public void creationCancel() {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		branchdetailobj = branchcreationobj.clickcancel();

	}

	// employee creation with valid data
	@Test(priority = 14, groups = { "employee", "create", "valid" })
	public void employeeValidData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickEmployeeName("securemaster");
		employeeCreationobj.loginPassword("secure");
		employeeCreationobj.selectRole("manager");
		employeeCreationobj.selectBranch("@");
		employeeCreationobj.clickOnSumit();
		System.out.println(alert.getText());
		alert.accept();
	}

	// employee creation with duplicate data
	@Test(priority = 15, groups = { "employee", "create", "invalid" })
	public void employeeDuplicateDAta() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickEmployeeName("securemaster");
		employeeCreationobj.loginPassword("secure");
		employeeCreationobj.selectRole("manager");
		employeeCreationobj.selectBranch("@");
		employeeCreationobj.clickOnSumit();
		System.out.println(alert.getText());
		alert.accept();
	}

	// employee creation with blank data
	@Test(priority = 16, groups = { "employee", "create", "invalid" })
	public void employeeBlankData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickOnSumit();
		System.out.println(alert.getText());
		alert.accept();
	}

	// employee creation reset
	@Test(priority = 17, groups = { "employee", "reset", "valid" })
	public void employeeResetData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickEmployeeName("securemaster");
		employeeCreationobj.loginPassword("secure");
		employeeCreationobj.selectRole("manager");
		employeeCreationobj.selectBranch("@");
		employeeCreationobj.clickOnReset();
		Assert.assertTrue(false);

	}

	// employee creatiOn cancel
	@Test(priority = 18, groups = { "employee", "cancel", "valid" })
	public void employeecancelData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeDetailsobj = employeeCreationobj.clickOnCancel();
	}

	// branch creation with multiple sets of data from excel file without using
	// DataProvider annotation
	@Test(priority = 19, groups = { "datadriven" })
	public void branchCreationDDWithoutDP() {
		excel = new ExcelHelper();
		branchdetailobj = adminHomePageObj.clickBranches();
		excel.setExcelToReadData("testdata.xls", "branchdata");
		int nor = excel.getRowCount();
		for (int r = 1; r < nor; r++) {
			String bName = excel.readData(r, 0);
			String add1 = excel.readData(r, 1);
			String zipcode = excel.readData(r, 2);
			String country = excel.readData(r, 3);
			String state = excel.readData(r, 4);
			String city = excel.readData(r, 5);
			branchcreationobj = branchdetailobj.clicknewbranch();
			branchcreationobj.branchnam(bName);
			branchcreationobj.aDDress(add1);
			branchcreationobj.zIPcod(zipcode);
			branchcreationobj.selcontry(country);
			branchcreationobj.selstate(state);
			branchcreationobj.seltcity(city);
			alert = branchcreationobj.subbutton();
			alertText = alert.getText();
			Reporter.log("alert came " + alertText);
			alert.accept();
			Assert.assertTrue(validateAlertText(alertText, "created Sucessfully"));
		}
	}

	// role creation with multiple sets of data using DataProvider annotation
	@Test(priority = 20, groups = {
			"datadriven" }, dataProviderClass = DataProviderClass.class, dataProvider = "role_data")
	public void roleCreationWithDDusingDP(String roleName, String roleType) {
		roleDetailsPageObj = adminHomePageObj.clickRoles();
		roleCreationPageObj = roleDetailsPageObj.clickNewRole();
		roleCreationPageObj.fillRoleName(roleName);
		roleCreationPageObj.selectRoleType(roleType);
		alert = roleCreationPageObj.clickSubmit();
		alertText = alert.getText();
		Reporter.log("alert came " + alertText);
		alert.accept();
		Assert.assertTrue(validateAlertText(alertText, "created Sucessfully"));
	}

	@AfterClass(groups = { "datadriven", "role", "employee", "branch", "cancel", "valid", "reset", "invalid",
			"create" })
	public void closeBrowser() {
		adminHomePageObj.clickLogout();
		driver.close();

	}

}
