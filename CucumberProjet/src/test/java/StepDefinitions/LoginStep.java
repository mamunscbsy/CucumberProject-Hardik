package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginStep {
	public WebDriver driver= null;
	public LoginPage loginpage;
	
	
	@Given("I am on Orange HRM login screen")
	public void i_am_on_orange_hrm_login_screen() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamun\\Selenium\\Selenium\\Drivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	 
		}

	@When("I enter usename and password")
	public void i_enter_usename_and_password() {
	   //driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  // driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  
	   loginpage = new LoginPage(driver);
	   loginpage.enteruserName("Admin");
	   loginpage.enterpassword("admin123");
	   
	}

	@When("I click login button")
	public void i_click_login_button() {
		// driver.findElement(By.id("btnLogin")).click();
		loginpage.clickonloginbutton();
	}

	@Then("I should be able to login successfully")
	public void i_should_be_able_to_login_successfully() {
	   if(driver.findElement(By.id("welcome")).isDisplayed()) {
		System.out.println("User logged in");
	}else{
		System.out.println("Use unable to logged in");
	}
	   driver.quit();

	}
	@Given("I am on login screen")
	public void i_am_on_login_screen() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamun\\Selenium\\Selenium\\Drivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("I enter invalid user credentials")
	public void i_enter_invalid_user_credentials() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
		   driver.findElement(By.id("txtPassword")).sendKeys("mamun123"); 
	}

	@Then("I should get invalid credentials message")
	public void i_should_get_invalid_credentials_message() {
		 if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials")) {
				System.out.println("Invalid credentials message is displayed successfully");
			}else{
				System.out.println("Invalid credentials message is not displayed");
			}
			   driver.quit(); 
	}
	@Then("I shoud able to see homepage")
	public void i_shoud_able_to_see_homepage() {
		 if(driver.findElement(By.xpath("//span[text()='Assign Leave']")).isDisplayed()) {
				System.out.println("Homepage is displyed successfully");
			}else{
				System.out.println("Homepage is not displyed successfully");
			}
			   driver.quit(); 
	   
	}
	@When("I click on logout")
	public void i_click_on_logout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	  	}

	@Then("I should be logout successfully")
	public void i_should_be_logout_successfully() {
	
	/*	if(driver.findElement(By.xpath("//div[text()='LOGIN Panel']")).isDisplayed()) {
			System.out.println("LOGIN Panel text displayed successfully");
		}else{
			System.out.println("LOGIN Panel text is not displayed");
			
		}*/
		Assert.assertTrue("LOGIN Panel text displayed successfully", driver.findElement(By.xpath("//div[text()='LOGIN Panel']")).isDisplayed());
		   driver.quit(); 
	}

@When("^I enter invalid (.*) and (.*)$")
public void i_enter_invalid_mamun_and(String username, String password) {
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	   driver.findElement(By.id("txtPassword")).sendKeys(password); 
   
}
@Then("^I should get the (.*)$")
public void i_should_get_the_password_cannot_be_empty(String errormessage) {
    Assert.assertTrue("Expected to display"+ errormessage, driver.findElement(By.id("spanMessage")).getText().equals(errormessage));
    driver.quit();
}

}
