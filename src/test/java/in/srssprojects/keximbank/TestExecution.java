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
	EmployeeCreation employeeCreationobj;
	EmployeeDetails employeeDetailsobj;
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

	// branch creation with valid data
	@Test(priority = 8)
	public void invalidBranchData() {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		branchcreationobj.branchnam("DDDRRRIII");
		branchcreationobj.aDDress("Hno 4-36 sec");
		branchcreationobj.aDDress2("HNo 3-111 Beeramguda");
		branchcreationobj.aDDress3("Hydernagar");
		branchcreationobj.aRea("hyderabad");
		branchcreationobj.zIPcod("502032");
//		Thread.sleep(1000);

		branchcreationobj.selcontry("INDIA");

		branchcreationobj.selstate("GOA");
		branchcreationobj.seltcity("GOA");
		alert = branchcreationobj.subbutton();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("sucessfuly searched the information");

	}

	// branch creation with duplicate data
	@Test(priority = 9)
	public void duplicateData() throws Exception {
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
	@Test(priority = 11)
	public void blankData() throws Exception {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		alert = branchcreationobj.subbutton();
		System.out.println(alert.getText());
		alert.accept();
	}

	// branch creation reset
	@Test(priority = 12)
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

	@Test(priority = 13)
	public void creationCancel() {
		branchdetailobj = adminHomePageObj.clickBranches();
		branchcreationobj = branchdetailobj.clicknewbranch();
		branchdetailobj= branchcreationobj.clickcancel();

	}

	// employee creation with valid data
	@Test(priority = 14)
	public void employeeValidData()

	{
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
	@Test(priority = 15)
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
	@Test(priority = 16)
	public void employeeBlankData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickOnSumit();
		System.out.println(alert.getText());
		alert.accept();
	}

	// employee creation reset
	@Test(priority = 17)
	public void employeeResetData() {
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeCreationobj.clickEmployeeName("securemaster");
		employeeCreationobj.loginPassword("secure");
		employeeCreationobj.selectRole("manager");
		employeeCreationobj.selectBranch("@");
		employeeCreationobj.clickOnReset();

	}

	// employee creatiOn cancel
	@Test(priority = 18)
	public void employeecancelData()
{
		employeeDetailsobj = adminHomePageObj.clickEmployee();
		employeeCreationobj = employeeDetailsobj.clickNewEmployee();
		employeeDetailsobj = employeeCreationobj.clickOnCancel();
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
