package eBanking.testCases;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang.RandomStringUtils;

import com.beust.jcommander.Parameter;

import eBanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	
	ReadConfig readconfig = new ReadConfig();
	public Properties prop;
	public String baseURL = "https://demo.guru99.com/v4/index.php";
	public String username = "mngr396671";
	public String password = "tEtenen";
	
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		
				logger=LogManager.getLogger(BaseClass.class);
				
		
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		logger.info("driver invoked");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	//Method to take screenshot on failure of test case
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken for failed testcase");
	}
	
	public String randomString()
	{
			String randomString = RandomStringUtils.randomAlphabetic(5);
			return randomString;
	}
	
	public String randomNumber()
	{
			String randomNumber = RandomStringUtils.randomNumeric(9);
			return randomNumber;
	}
	
	public boolean isAleartPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	
}
