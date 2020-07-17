package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateCourse {
	static WebDriver driver;
	String url = "http://elearningm1.upskills.in" ;
	@Given("^I launch the application$")
	public void i_launch_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Then("^I enter the username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_the_username_and_password(String username, String pwd) throws Throwable {
		driver.findElement(By.cssSelector("input#login")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
		driver.findElement(By.name("submitAuth")).click();
	}

	@When("^I click the Create a Course link$")
	public void i_click_the_Create_a_Course_link() throws Throwable {
	    driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
	}

	@When("^Enter valid credential in Title textbox$")
	public void enter_valid_credential_in_Title_textbox() throws Throwable {
		driver.findElement(By.cssSelector("#update_course_title")).sendKeys("ELSC10Course");
	    	}

	@When("^Enter valid credential in code textbox$")
	public void enter_valid_credential_in_code_textbox() throws Throwable {
	    driver.findElement(By.cssSelector("#visual_code")).sendKeys("elsc10code");
	}
	@Then("^I click on create course button$")
	public void i_click_on_create_course_button() throws Throwable {
	    driver.findElement(By.cssSelector("#update_course_submit")).click();
	}

}
