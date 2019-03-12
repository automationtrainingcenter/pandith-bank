package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class Listener implements WebDriverEventListener {
	JavascriptExecutor js;

	public void beforeAlertAccept(WebDriver driver) {
		Reporter.log("alert came " + driver.switchTo().alert().getText());
		TestListener.test.log(LogStatus.INFO, "alert came " + driver.switchTo().alert().getText());
	}
	

	public void afterAlertAccept(WebDriver driver) {
		Reporter.log("alert accepted");
		TestListener.test.log(LogStatus.INFO, "alert accepted");
	}
	

	public void afterAlertDismiss(WebDriver driver) {
		Reporter.log("alert came " + driver.switchTo().alert().getText());
		TestListener.test.log(LogStatus.INFO, "alert came " + driver.switchTo().alert().getText());
	}

	public void beforeAlertDismiss(WebDriver driver) {
		Reporter.log("alert dimissed");
		TestListener.test.log(LogStatus.INFO, "alert dimissed");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("locating an element usin " + by);
		TestListener.test.log(LogStatus.INFO, "locating an element usin " + by);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Reporter.log("element located succesfully");
		TestListener.test.log(LogStatus.INFO,"element located succesfully");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		Reporter.log("clicking on that element");
		TestListener.test.log(LogStatus.INFO,"clicking on that element");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Reporter.log("element clicked");
		TestListener.test.log(LogStatus.INFO,"element clicked");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		Reporter.log("changing element value");
		TestListener.test.log(LogStatus.INFO, "changing element value");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		js = (JavascriptExecutor) driver;
		Reporter.log("element value changed to" + js.executeScript("return arguments[0].value", element).toString());
		TestListener.test.log(LogStatus.INFO,
				"element value changed to" + js.executeScript("return arguments[0].value", element).toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
