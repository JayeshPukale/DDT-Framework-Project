package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonFunction.AddUserPage;
import commonFunction.LoginPage;
import utilities.ExcelFileUtil;

public class DriverScriptPOM {
WebDriver driver;
String inputpath = "D:\\Testing Tools\\automation testing\\DDT_Framework\\TestInput\\UserData.xlsx";
String outputpath = "D:\\Testing Tools\\automation testing\\DDT_Framework\\TestOutput\\UserResults.xlsx";
@BeforeTest
public void adminLogin()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	LoginPage login =PageFactory.initElements(driver, LoginPage.class);
	login.verifylogin("Admin", "Qedge123!@#");
}
@Test
public void validateUser()throws Throwable
{
	AddUserPage user =PageFactory.initElements(driver, AddUserPage.class);
	ExcelFileUtil xl =new ExcelFileUtil(inputpath);
	int rc =xl.rowCount("Adduser");
	int cc =xl.cellCount("Adduser");
	Reporter.log(rc+"       "+cc,true);
	for(int i=1;i<=rc;i++)
	{
		String UserRole =xl.getcelldata("Adduser", i, 0);
		String EmployeeName =xl.getcelldata("Adduser", i, 1);
		String Username =xl.getcelldata("Adduser", i, 2);
		String Password =xl.getcelldata("Adduser", i, 3);
		String Cpassword =xl.getcelldata("Adduser", i, 4);
		boolean res =user.verifyAdduser(UserRole, EmployeeName, Username, Password, Cpassword);
		if(res)
		{
			xl.setCellData("Adduser", i, 5, "Pass", outputpath);
		}
		else
		{
			xl.setCellData("Adduser", i, 5, "Fail", outputpath);
		}
	}
}
@AfterTest
public void tearDown() {
	driver.close();
}
}
