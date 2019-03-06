package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BranchDetailsPage {
	WebDriver driver;
	// click on new branch
	@FindBy(how = How.ID, using = "BtnNewBR")
	private WebElement newbranch;

	public BranchDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BranchCreationPage clicknewbranch() {
		this.newbranch.click();

		return PageFactory.initElements(driver, BranchCreationPage.class);

	}
}
