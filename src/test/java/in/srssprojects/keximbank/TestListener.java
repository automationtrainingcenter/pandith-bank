package in.srssprojects.keximbank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ISuiteListener, ITestListener {
	static ExtentReports report;
	static ExtentTest test;
	
	// get date and time
	public String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}

	public void onStart(ISuite suite) {
		report = new ExtentReports(BaseClass.getFolderPath("reports", "report.html"));
	}

	public void onFinish(ISuite suite) {
		report.flush();
		report.close();
	}

	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "test case passed");
		report.endTest(test);
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "test case failed");
		String imgPath = BaseClass.captureAlertScreen("screenshots", result.getName()+getDateTime()+".png");
		test.log(LogStatus.INFO, test.addScreenCapture(imgPath));
		report.endTest(test);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "test case skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
