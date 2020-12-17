package com.tau.steps;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tau.base.BaseUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseUtil{
	
	private BaseUtil baseUtil;
	public Steps(BaseUtil util) {
		this.baseUtil = util;
	}
	
	
	private WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("I am in the login page of the Para Bank Application")
	public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
		
		driver.get("http://parabank.parasoft.com/parabank/index.htm");
	}

	@When("I enter valid {string} and {string}")
	public void i_enter_valid_credentials(String username, String password) {
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("username")).submit();

	}
	
	@When("I enter valid {string} and {string} with {string}")
	public void i_enter_valid_credentials_with(String username, String password, String userFullName1) {
		
		baseUtil.userFullName = userFullName1;
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("username")).submit();

	}
	
	@When("I enter valid credentials")
	public void i_enter_valid_credentials_data_table(DataTable table) {
		
		List<String> loginForm= table.asList();
		driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
		driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
		driver.findElement(By.name("username")).submit();

	}


	@Then("I shoud be taken to the Overview page")
	public void i_shoud_be_taken_to_the_Overview_page() throws Exception {
		Thread.sleep(5000);
		
		String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
		System.out.println(baseUtil.userFullName.contains(baseUtil.userFullName));
		driver.findElement(By.linkText("Log out")).click();
	
		
	}
	
	@After()
	public void quitBrowser() {
	driver.quit();
	
	}

}
