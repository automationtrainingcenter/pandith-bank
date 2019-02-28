//package in.srssprojects.keximbank;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//public class Branchvalidation 
//{
//	WebDriver driver;
//	//click on country type
//	
//@FindBy(how= How.ID, using = "lst_countryS")
//private WebElement countrytype;
//
////click on State type
//
//@FindBy(how= How.ID, using="lst_stateS")
// private WebElement statetype;
//
////click on citytype type
//
//@FindBy(how= How.ID, using="lst_cityS")
//private WebElement citytype;
//
//// click on submit
//
//@FindBy(how= How.ID , using="btn_search")
//private WebElement searchbutton;
//
//public BranchDetailsPage(WebDriver driver) {
//	this.driver = driver;
//	PageFactory.initElements(driver, this);
//
//}//selecting the visible text
// public void selectcountry(String countrytype ) {
//	 new Select(this.countrytype).selectByVisibleText(countrytype);}
// 
// public void selectstate(String statetype) {
//	 new Select(this.statetype).selectByVisibleText(statetype);
// }
// // selecting the city
// 
// public void selectcity(String citytype )
// {
//	 new Select(this.citytype).selectByVisibleText(citytype);
//	 
// }
// //click on search
// public Branchcreationpage clicksearch() 
// {
//	 this.searchbutton.click();
//
//
//}
