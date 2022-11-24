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

public class MutipleUser {
	

	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions action = null;

	
	@SuppressWarnings("deprecation")
	@Given("Chrome browser shuould open and User navigates to the Amaazon page")
	public void chrome_browser_shuould_open_and_user_navigates_to_the_amaazon_page() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]")).click();

	
	}

	@When("User Gives email {string} and password {string}")
	public void user_gives_email_and_password(String uname, String pass) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(uname);

		driver.findElement(By.id("continue")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit")));
		
		driver.findElement(By.id("ap_password")).sendKeys(pass);

		driver.findElement(By.id("signInSubmit")).click();


	}

	@When("User Adds Three Item into the Cart")
	public void user_adds_three_item_into_the_cart() {
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));

		action.sendKeys(ele, "hp pavilion l").pause(1000).sendKeys("a").pause(100).sendKeys("p").pause(100).sendKeys("t").pause(100)
				.sendKeys("op").sendKeys(Keys.ENTER).build().perform();
		
		
		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			
		}
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		e.click();
		e.clear();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		action.sendKeys(e, "b").pause(1000).sendKeys("a").pause(100).sendKeys("g").pause(100).sendKeys(" for men").sendKeys(Keys.ENTER).build()
				.perform();

		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
				.click();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
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
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
		}
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
	}

	@When("USer Clicks on Show Cart")
	public void u_ser_clicks_on_show_cart() {
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
		action.sendKeys(Keys.LEFT_CONTROL).sendKeys(Keys.HOME).build().perform();
	}

	@Then("User Should land on Cart Page")
	public void user_should_land_on_cart_page() {
		assertEquals("Amazon.in Shopping Cart", driver.getTitle());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}
		driver.quit();
	}
}
