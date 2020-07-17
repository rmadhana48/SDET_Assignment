package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import commons.Wrapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ELSC10_Excel {
	static WebDriver driver;
	
	String url = "http://elearningm1.upskills.in" ;
	@Given("^User should have launched the application excel$")
	public void user_should_have_launched_the_applicationexcel() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Given("^User should get logged in as admin \"([^\"]*)\" and password excel \"([^\"]*)\"$")
	public void user_should_get_logged_in_as_adminexcel(String username, String pwd) throws Throwable {
		driver.findElement(By.cssSelector("input#login")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
		driver.findElement(By.name("submitAuth")).click();
	}

	@When("^User Click on Administration tab excel$")
	public void user_Click_on_Administration_tabexcel() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
	}

	@When("^User Click on Add a user link excel$")
	public void user_Click_on_Add_a_user_linkexcel() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Add a user')]")).click();
	}

	@When("^Enter valid credential in First name textbox excel$")
	public void enter_valid_credential_in_First_name_textboxexcel() throws Throwable {
		driver.findElement(By.cssSelector("input#firstname")).sendKeys(Wrapper.getDataFromExcel(1, 0));
	}
 
	@When("^Enter valid credential in Last name textbox excel$")
	public void enter_valid_credential_in_Last_name_textboxexcel() throws Throwable {
		driver.findElement(By.cssSelector("input#lastname")).sendKeys(Wrapper.getDataFromExcel(1,1));
	}

	@When("^Enter valid credential in e-mail textbox excel$")
	public void enter_valid_credential_in_e_mail_textboxexcel() throws Throwable {
		driver.findElement(By.cssSelector("input#email")).sendKeys(Wrapper.getDataFromExcel(1,2));
	}

	@When("^Enter valid credential in phone textbox excel$")
	public void enter_valid_credential_in_phone_textboxexcel() throws Throwable {
		driver.findElement(By.cssSelector("input#phone")).sendKeys(Wrapper.getDataFromExcel(1,3));
	}

	@When("^Enter valid credential in Login textbox excel$")
	public void enter_valid_credential_in_Login_textboxexcel() throws Throwable {
	 driver.findElement(By.cssSelector("[name=username]")).sendKeys(Wrapper.getDataFromExcel(1,4));
	}

	@When("^Click on Enter password radio button excel$")
	public void click_on_Enter_password_radio_buttonexcel() throws Throwable {
		driver.findElement(By.xpath("//input[@name='password[password_auto]' and @value=\"0\"]")).click();
		
	}

	@When("^Enter valid credential in password textbox excel$")
	public void enter_valid_credential_in_password_textboxexcel() throws Throwable {
	    driver.findElement(By.cssSelector("input#password")).sendKeys(Wrapper.getDataFromExcel(1,5));
	}

	@When("^Select Valid credentials from profile list box excel$")
	public void select_Valid_credentials_from_profile_list_boxexcel() throws Throwable {
	  Select value = new Select(driver.findElement(By.id("status_select")));
	  value.selectByVisibleText(Wrapper.getDataFromExcel(1,6));
	}

	@When("^Click on Add button excel$")
	public void click_on_Add_buttonexcel() throws Throwable {
	   driver.findElement(By.name("submit")).click();
	   String alertmsg = driver.findElement(By.cssSelector(".alert")).getText();
	   System.out.println("Alert message displayed : " + alertmsg);
	   
 	}

	@When("^Click on Administration link excel$")
	public void click_on_Administration_linkexcel() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
	}

	@When("^Click on Add users to course link excel$")
	public void click_on_Add_users_to_course_linkexcel() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Add users to course')]")).click();
	}

	@When("^select user from the user list excel \"([^\"]*)\"$")
	public void select_user_from_the_user_listexcel(String usr) throws Throwable {
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

	@When("^select course from the course list excel \"([^\"]*)\"$")
	public void select_course_from_the_course_listexcel(String coursename) throws Throwable {
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

	@When("^click on Add to the course button excel$")
	public void click_on_Add_to_the_course_buttonexcel() throws Throwable {
	  driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}

	@Then("^Validate the message displayed excel$")
	public void validate_the_message_displayedexcel() throws Throwable {
	    String alertsucc = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
	    System.out.println("Alert Success Message: " + alertsucc);
	    		
	}


}
