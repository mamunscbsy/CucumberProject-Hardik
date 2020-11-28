package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartTestStep {
	
	public WebDriver driver;
	
	@Given("I am on nopCommerce login page")
	public void i_am_on_nop_commerce_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamun\\Selenium\\Selenium\\Drivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	   	}

	@When("^I enter (.*) in search box$")
	public void i_enter_htc_one_mini_blue_in_search_box(String ProductName) {
	   driver.findElement(By.id("small-searchterms")).sendKeys(ProductName);
	   	}

	@When("Click Serch button")
	public void click_serch_button() {
	    driver.findElement(By.xpath("(//input[@value='Search'])[1]")).click();
	}

	@When("I add item to the Cart")
	public void i_add_item_to_the_cart() {
	    driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	}

	@Then("Item should added to Cart")
	public void item_should_added_to_cart() {
	  
	   Assert.assertTrue("Expected to disply Add to Cart success meassage", driver.findElement(By.xpath("//div[@class='bar-notification success']")).isDisplayed());
	   driver.findElement(By.className("close")).click();
	   //driver.quit();
	}
	@When("I click Shopping Cart")
	public void i_click_shopping_cart() {
	   driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	}

	@When("click Remove Check box")
	public void click_remove_check_box() {
	   driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
	}

	@When("click on Update Shopping Cart")
	public void click_on_update_shopping_cart() {
	   driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	}

	@Then("Shopping Cart should be empty")
	public void shopping_cart_should_be_empty() {
	driver.findElement(By.xpath("//div[@class='no-data']")).isDisplayed();
	Assert.assertTrue("Expected to disply Your Shopping Cart is empty!", driver.findElement(By.xpath("//div[@class='no-data']")).isDisplayed());
	
	driver.quit();
	}

}
