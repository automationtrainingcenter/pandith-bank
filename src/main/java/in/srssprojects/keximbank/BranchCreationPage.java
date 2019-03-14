package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
	WebDriver driver;
//branch name 
	@FindBy(how = How.XPATH, using = " //input[@id='txtbName']")
	private WebElement branchname;
//Address 
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address1;
//address 2
	@FindBy(how = How.ID, using = "Txtadd2")
	private WebElement address2;
//address 3
	@FindBy(how = How.ID, using = "txtadd3")
	private WebElement address3;
//Area
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement Area;
//zipcod
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zipcode;
// select a country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement selectcoun;
//select state

	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement selstate;
//select city 
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement selcity;
// click on submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement clicksub;
// click to resetb
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement clickrest;
//click to cancel 
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement clickcan;

	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//fill branch name 

	public void branchnam(String branchname) {
		this.branchname.sendKeys(branchname);
	}

	// fill address
	public void aDDress(String address1) {
		this.address1.sendKeys(address1);

	}

	// fill adress 2
	public void aDDress2(String address2) {
		this.address2.sendKeys(address2);

	}
	// address 3

	public void aDDress3(String address3) {
		this.address3.sendKeys(address3);

	}

// fill area
	public void aRea(String Area) {
		this.Area.sendKeys(Area);

	}

	// enter zipcode

	public void zIPcod(String zipcode) {
		this.zipcode.sendKeys(zipcode);

	}

//select the country from the list 

	public void selcontry(String countryname) {
		new Select(this.selectcoun).selectByVisibleText(countryname);
	}

//	public void selcontry(String contry) {
//		Select country = new Select(driver.findElement(By.id("lst_counrtyU")));
//		country.selectByVisibleText(contry);
//
//	}

//select the state 
	public void selstate(String statename) {
		new Select(this.selstate).selectByVisibleText(statename);

	}

//select city
	public void seltcity(String cityname) {
		new Select(this.selcity).selectByVisibleText(cityname);

	}// click on submit button

	public Alert subbutton() {
		this.clicksub.click();
		return driver.switchTo().alert();

	}

// click on reset 
	public void clickrest() {
		this.clickrest.click();
	}

// click on cancel
	public BranchDetailsPage clickcancel() {
		this.clickcan.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

}
