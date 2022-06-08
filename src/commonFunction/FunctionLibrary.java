package commonFunction;

import org.openqa.selenium.By;
import org.testng.Reporter;

import constant.AppUtil;

public class FunctionLibrary extends AppUtil{
public static boolean verifyLogin(String username,String password)
{
	driver.findElement(By.xpath(config.getProperty("ObjUser"))).sendKeys(username);
	driver.findElement(By.xpath(config.getProperty("ObjPass"))).sendKeys(password);
	driver.findElement(By.xpath(config.getProperty("Objloginbtn"))).click();
	String expected = "dashboard";
	String actual = driver.getCurrentUrl();
	if(actual.contains(expected))
	{
		Reporter.log("Login success::"+expected+"      "+actual,true);
		return true;
	}
	else
	{
		//capture error message
		String errormessage = driver.findElement(By.xpath(config.getProperty("Objmessage"))).getText();
		Reporter.log(errormessage+"      "+expected+"        "+actual,true);
		return false;
	}
}
}
