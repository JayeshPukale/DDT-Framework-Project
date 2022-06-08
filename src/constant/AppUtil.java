package constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeTest
public void setUp() throws Throwable
{
	config = new Properties();
	config.load(new FileInputStream("D:\\Testing Tools\\automation testing\\DDT_Framework\\PropertyFiles\\OrangeHRM.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new ChromeDriver();
	}
	else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		Reporter.log("Browser value is Not Matching");
	}
}
@AfterTest
public void tearDown() {
	driver.close();
}
}
