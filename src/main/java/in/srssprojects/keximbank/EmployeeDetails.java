package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetails 
{
	WebDriver driver;
	@FindBy(how= How.ID, using="BtnNew")
	private WebElement newbranch;

	public  EmployeeDetails(WebDriver driver) 
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
public EmployeeCreation clickNewEmployee()
{
	this.newbranch.click();
	return PageFactory.initElements(driver, EmployeeCreation.class);
			}
}
