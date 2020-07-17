package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ELSC010 {
	static WebDriver driver;
	String url = "http://elearningm1.upskills.in" ;
	@Given("^User should have launched the application$")
	public void user_should_have_launched_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Given("^User should get logged in as admin \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_should_get_logged_in_as_admin(String username, String pwd) throws Throwable {
		driver.findElement(By.cssSelector("input#login")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
		driver.findElement(By.name("submitAuth")).click();
	}

	@Given("^Admin has already created course$")
	public void admin_has_already_created_course() throws Throwable {
	    
	}

	@When("^User Click on Administration tab$")
	public void user_Click_on_Administration_tab() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
	}

	@When("^User Click on Add a user link$")
	public void user_Click_on_Add_a_user_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Add a user')]")).click();
	}

	@When("^Enter valid credential in First name textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_First_name_textbox(String fname) throws Throwable {
	   driver.findElement(By.cssSelector("input#firstname")).sendKeys(fname);
	}

	@When("^Enter valid credential in Last name textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_Last_name_textbox(String lname) throws Throwable {
		driver.findElement(By.cssSelector("input#lastname")).sendKeys(lname);
	}

	@When("^Enter valid credential in e-mail textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_e_mail_textbox(String email) throws Throwable {
		driver.findElement(By.cssSelector("input#email")).sendKeys(email);
	}

	@When("^Enter valid credential in phone textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_phone_textbox(String phone) throws Throwable {
		driver.findElement(By.cssSelector("input#phone")).sendKeys(phone);
	}

	@When("^Enter valid credential in Login textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_Login_textbox(String uname) throws Throwable {
	 driver.findElement(By.cssSelector("[name=username]")).sendKeys(uname);
	}

	@When("^Click on Enter password radio button$")
	public void click_on_Enter_password_radio_button() throws Throwable {
		driver.findElement(By.xpath("//input[@name='password[password_auto]' and @value=\"0\"]")).click();
		
	}

	@When("^Enter valid credential in password textbox \"([^\"]*)\"$")
	public void enter_valid_credential_in_password_textbox(String password) throws Throwable {
	    driver.findElement(By.cssSelector("input#password")).sendKeys(password);
	}

	@When("^Select Valid credentials from profile list box \"([^\"]*)\"$")
	public void select_Valid_credentials_from_profile_list_box(String svalue) throws Throwable {
	  Select value = new Select(driver.findElement(By.id("status_select")));
	  value.selectByVisibleText(svalue);
	}

	@When("^Click on Add button$")
	public void click_on_Add_button() throws Throwable {
	   driver.findElement(By.name("submit")).click();
	   String alertmsg = driver.findElement(By.cssSelector(".alert")).getText();
	   System.out.println("Alert message displayed : " + alertmsg);
	   
 	}

	@When("^Click on Administration link$")
	public void click_on_Administration_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
	}

	@When("^Click on Add users to course link$")
	public void click_on_Add_users_to_course_link() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Add users to course')]")).click();
	}

	@When("^select user from the user list \"([^\"]*)\"$")
	public void select_user_from_the_user_list(String usr) throws Throwable {
		Select alpha = new Select(driver.findElement(By.name("firstLetterUser")));
		  alpha.selectByValue("M");
		Select user = new Select(driver.findElement(By.name("UserList[]")));
		 List<WebElement> userlist = user.getOptions();
		 int l = userlist.size();
		 
		 for(int i =0; i < l ; i++){
			 String userValue = user.getOptions().get(i).getText();
		 if(userValue.contains(usr)){
		 user.selectByIndex(i);
		 break;
		 }
		 } 
	}

	@When("^select course from the course list \"([^\"]*)\"$")
	public void select_course_from_the_course_list(String coursename) throws Throwable {
		Select course = new Select(driver.findElement(By.name("CourseList[]")));
		 List<WebElement> clist = course.getOptions();
		 int l = clist.size();
		 
		 for(int i =0; i < l ; i++){
			 String cValue = course.getOptions().get(i).getText();
		 if(cValue.contains(coursename)){
		 course.selectByIndex(i);
		 break;
		 }
		 } 
	}

	@When("^click on Add to the course button$")
	public void click_on_Add_to_the_course_button() throws Throwable {
	  driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}

	@Then("^Validate the message displayed$")
	public void validate_the_message_displayed() throws Throwable {
	    String alertsucc = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
	    System.out.println("Alert Success Message: " + alertsucc);
	    		
	}


}
