package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RolesDetailsPage {
	private WebDriver driver;
	
	
	//new role
	@FindBy(how = How.ID, using ="btnRoles")
	private WebElement newRoleButton;
	
	
	public RolesDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on new role button
	public RoleCreationPage clickNewRole() {
		this.newRoleButton.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}

}
