package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;
	
	//branches
	@FindBy(how = How.XPATH, using ="//a[@href='admin_banker_master.aspx']")
	private WebElement branches;
	
	//roles
	@FindBy(how = How.XPATH, using ="//a[@href='Admin_Roles_details.aspx']")
	private WebElement roles;
	
	//employees
	@FindBy(how = How.XPATH, using ="//a[@href='Admin_Emp_details.aspx']")
	private WebElement employees;
	
	//home
	@FindBy(how = How.XPATH, using ="//a[@href='home.aspx']")
	private WebElement home;
	
	//logout
	@FindBy(how = How.XPATH, using ="//a[@href='home.aspx']")
	private WebElement logout;
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on branches
	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}
	
	
	//click on roles
	public RolesDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RolesDetailsPage.class);
	}
	// click on employee
	public EmployeeDetails clickEmployee()
	{
		this.employees.click();
		return PageFactory.initElements(driver, EmployeeDetails.class);
		
	}
}
