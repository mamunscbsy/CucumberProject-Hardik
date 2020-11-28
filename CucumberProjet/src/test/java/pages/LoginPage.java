package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
			
	}
	By usernameTextbox = By.id("txtUsername");
	By passwordTextbox = By.id("txtPassword");
	By loginButton = By.id("btnLogin");
	
	public void enteruserName(String uname) {
		driver.findElement(usernameTextbox).sendKeys(uname);
	}
	public void enterpassword(String password) {
		driver.findElement(passwordTextbox).sendKeys(password);
	}
	public void clickonloginbutton() {
		driver.findElement(loginButton).click();
	}
}


