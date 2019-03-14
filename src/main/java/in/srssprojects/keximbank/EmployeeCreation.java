package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreation {
	WebDriver driver;
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement employeeName;
//login password
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement password;
//role
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement EmloyeeRole;
//branch
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement EmployeeBranch;
//submit
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement Empsubmit;
//cancel
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement EmpCancel;
//reset
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement EmpReset;

// 
	public EmployeeCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// enter employee name 
	public void clickEmployeeName(String EmployeeName) {
		this.employeeName.sendKeys(EmployeeName);
	}

//employee password
	public void loginPassword(String loginPassword) {
		this.password.sendKeys(loginPassword);
	}

//select role
	public void selectRole(String SelectRole) {
		new Select(this.EmloyeeRole).selectByVisibleText(SelectRole);
		;

	}

//select branch
	public void selectBranch(String Branch) {
		new Select(this.EmployeeBranch).selectByVisibleText(Branch);
		;
	}

//click on submit
	public void clickOnSumit() {
		this.Empsubmit.click();
	}

// click on cancel
	public EmployeeDetails clickOnCancel() {
		this.EmpCancel.click();
		return PageFactory.initElements(driver, EmployeeDetails.class);
	}

//click on reset
	public void clickOnReset() {
		this.EmpReset.click();

	}
}
