package com.amazon.cucumberpro;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonFunctionality {

	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions action = null;

	@SuppressWarnings("deprecation")
	@Given("Chrome Browser Should Open")
	public void chrome_browser_should_open() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]")).click();

	}

	@Given("Login Credentions would be entered")
	public void login_credentions_would_be_entered() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("7436873429");

		driver.findElement(By.id("continue")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit")));

	}

	@When("Login credentials are correct")
	public void login_credentials_are_correct() {
		driver.findElement(By.id("ap_password")).sendKeys("xxxxxxxxx");

		driver.findElement(By.id("signInSubmit")).click();

	}

	@When("User Lands on the Home Page")
	public void user_lands_on_the_home_page() {

	}

	@When("User Selects three Item")
	public void user_selects_three_item() {
		WebElement e = driver.findElement(By.id("twotabsearchtextbox"));

		action.sendKeys(e, "HP L").pause(1000).sendKeys("a").pause(100).sendKeys("p").pause(100).sendKeys("t").pause(100)
				.sendKeys("op").sendKeys(Keys.ENTER).build().perform();

	}

	@When("Adds then into the cart")
	public void adds_then_into_the_cart() {

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
		e.click();
		e.clear();
		action.sendKeys(e, "b").pause(1000).sendKeys("a").pause(100).sendKeys("g").sendKeys(Keys.ENTER).build()
				.perform();

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();

//		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		e = driver.findElement(By.id("twotabsearchtextbox"));

		e.click();
		e.click();
		e.clear();

		action.sendKeys(e, "ip").pause(1000).sendKeys("ho").pause(100).sendKeys("ne 14").sendKeys(Keys.ENTER).build()
				.perform();

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();

		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
		}

		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.id("attach-close_sideSheet-link")).click();

	}

	@When("User Clicks on Show Cart")
	public void user_clicks_on_show_cart() {

		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();

	}

	@Then("User Should land to Add to cart Page")
	public void user_should_land_to_add_to_cart_page() {
		assertEquals("Amazon.in Shopping Cart", driver.getTitle());
//	driver.quit();
	}

}
