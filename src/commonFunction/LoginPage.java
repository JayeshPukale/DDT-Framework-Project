package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//define Repository for login
	@FindBy(name = "txtUsername")
	WebElement username;
	@FindBy(id = "txtPassword")
	WebElement password;
	@FindBy(name = "Submit")
	WebElement loginbtn;
	//method for login
	public void verifylogin(String Enterusername, String Enterpassword)
	{
		username.sendKeys(Enterusername);
		password.sendKeys(Enterpassword);
		loginbtn.click();
	}
	
}
