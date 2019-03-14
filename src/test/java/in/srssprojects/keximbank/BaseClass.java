package in.srssprojects.keximbank;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass {
	WebDriver driver;

	// launch browser
	public void launchBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFolderPath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFolderPath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("invalid browser name");
		}
		// create an object of EventFiringWebDriver class
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		// cretea an object of listener class with EventFiringWebDriver
		Listener listener = new Listener();
		// register the listener with EventFiringWebDriver
		edriver.register(listener);
		driver = edriver;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void launchBrowser(String browserName, String url, String node, String os) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		if (os.equals("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (os.equals("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		if (os.equals("linux")) {
			caps.setPlatform(Platform.LINUX);
		}

		try {
			driver = new RemoteWebDriver(new URL(node), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// create an object of EventFiringWebDriver class
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		// cretea an object of listener class with EventFiringWebDriver
		Listener listener = new Listener();
		// register the listener with EventFiringWebDriver
		edriver.register(listener);
		driver = edriver;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// sleep
	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// close browser
	public void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	// take screenshot
	public String captureScreenshot(String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImage = ts.getScreenshotAs(OutputType.FILE);
		File desImage = new File(getFolderPath(folderName, fileName));
		try {
			// saving screenshot using ImageIO and BufferedImage classes of Java
//			BufferedImage bi = ImageIO.read(srcImage);
//			ImageIO.write(bi, "png", desImage);
			FileUtils.copyFile(srcImage, desImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return desImage.getAbsolutePath();
	}

	// take alert screenshot
	public static String captureAlertScreen(String folderName, String fileName) {
		File destImg = new File(getFolderPath(folderName, fileName));
		try {
			Robot r = new Robot();
			BufferedImage bi = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(bi, "png", destImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destImg.getAbsolutePath();
	}

	// get date and time
	public String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}

	// get folder path
	public static String getFolderPath(String folderName, String fileName) {
//		String os_name = System.getProperty("os.name").toLowerCase();
//		if(os_name.contains("win")) {
//			return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName+".exe";
//		}else {
//			return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
//		}
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	// read property from config.properties file
	public String readProperty(String propName) {
		// create FileInputStream class object
		try {
			FileInputStream fis = new FileInputStream(getFolderPath(".\\", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean validateAlertText(String actualAlertText, String expectedAlertText) {
		return actualAlertText.toLowerCase().contains(expectedAlertText.toLowerCase());
	}

}
