package employeeRegistration;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionRegistration {
	RegistrationPageFactory registrationPageFactory;
	WebDriver driver=null;
	Alert alert;
	
	@Given("^User is on registration page$")
	public void user_is_on_registration_page() {
		
		//WebDriver driver =new FirefoxDriver(); //inbuilt
		System.setProperty("webdriver.chrome.driver", "D:\\BDD libs\\jar-files\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.navigate().to("file:///D:/BDD%20libs/App/form.html");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		registrationPageFactory=new RegistrationPageFactory(driver);
		
	    
	}

	@Then("^check the heading of the page$")
	public void check_the_heading_of_the_page() {
		 String actualHeading="Registration Form";
		
			if(registrationPageFactory.getHeading().getText().equals(actualHeading)) {
				System.out.println("Heading Matched ");
			}else {
				System.out.println("Heading not Matched");
			}
			
	   
	}

	
	@When("^User enters all mandatory fields$")
	public void user_enters_all_mandatory_fields() throws InterruptedException {
		registrationPageFactory.setName("Santhu");
	    Thread.sleep(1000);
	    registrationPageFactory.setMobile("9959595959");
	    Thread.sleep(1000);
	    registrationPageFactory.setEmail("santhu@gmail.com");
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
	     Thread.sleep(1000);
		 
	}


	@Then("^Display successful message$")
	public void display_successful_message() throws InterruptedException{
		 Thread.sleep(1000);
		registrationPageFactory.setButton(); 
		 Thread.sleep(1000);
		  driver.close();
	}

	@When("^User left the data in all mandatory fields as blank$")
	public void user_left_the_data_in_all_mandatory_fields_as_blank() throws InterruptedException {
		 registrationPageFactory.setName("");
		    Thread.sleep(1000);
		    registrationPageFactory.setMobile("");
		    Thread.sleep(1000);
		    registrationPageFactory.setEmail("");
		    Thread.sleep(1000);
		     registrationPageFactory.setAddress("");
		     Thread.sleep(1000);
		    registrationPageFactory.setButton(); 
		    Thread.sleep(1000);
		     driver.switchTo().alert();
			
			System.out.println(alert.getText());   
			
			alert.accept(); 

		     driver.close();
		    
	  
	}

	@Then("^Display error message$")
	public void display_error_message()  {
	    System.out.println("Error in registration");
	
	}

	
	@When("^User left name field as blank$")
	public void user_left_name_field_as_blank() throws InterruptedException{
		registrationPageFactory.setName("");
	    Thread.sleep(1000);
	    registrationPageFactory.setMobile("9959595959");
	    Thread.sleep(1000);
	    registrationPageFactory.setEmail("santhu@gmail.com");
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
	     Thread.sleep(1000);
		registrationPageFactory.setButton(); 
		 Thread.sleep(1000);

	     driver.switchTo().alert();
		
		System.out.println(alert.getText());   
		
		alert.accept(); 

	     driver.close();
	    
	    
	    
	}

	

	@When("^User left email field as blank$")
	public void user_left_email_field_as_blank() throws InterruptedException{
		registrationPageFactory.setName("Santhu");
	    Thread.sleep(1000);
	    registrationPageFactory.setMobile("9959595959");
	    Thread.sleep(1000);
	    registrationPageFactory.setEmail("");
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
	     Thread.sleep(1000);
		registrationPageFactory.setButton(); 

		     
	     driver.switchTo().alert();
			
	     System.out.println(alert.getText());   
			
		alert.accept(); 

		driver.close();
		    
	    
	}

	@When("^User enters the invalid email format$")
	public void user_enters_the_invalid_email_format(DataTable emails) throws InterruptedException {
	
		registrationPageFactory.setName("Santhu");
		Thread.sleep(1000);
	    registrationPageFactory.setMobile("9965845782");;
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
	     

		List<String> objList = emails.asList(String.class);
		String data=null;
		for (String dataTemp:objList) {
			data=dataTemp;
			registrationPageFactory.getEmail().clear();
			registrationPageFactory.setEmail(dataTemp);
			 Thread.sleep(1000);
			registrationPageFactory.setButton(); 
			 Thread.sleep(1000);
			
			if (Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$",data)) {
				System.out.println("Email format Matching ");
			} else {
				
				String alertMessage = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println("not matched "+alertMessage);
			
				
			}
		}
	 
	}

	
	

	@When("^User left mobile number field as blank$")
	public void user_left_mobile_number_field_as_blank() throws InterruptedException {
		registrationPageFactory.setName("Santhu");
	    Thread.sleep(1000);
	    registrationPageFactory.setMobile("");
	    Thread.sleep(1000);
	    registrationPageFactory.setEmail("santhu@gmail.com");
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
	     Thread.sleep(1000);
		registrationPageFactory.setButton(); 
		 Thread.sleep(1000);

			     
		driver.switchTo().alert();
				
		System.out.println(alert.getText());   
				
		alert.accept(); 

	    driver.close();
	    
	}

	@When("^user enters the invalid mobile number$")
	public void user_enters_the_invalid_mobile_number(DataTable numbers) throws InterruptedException {
	   
		
		registrationPageFactory.setName("Santhu");
		Thread.sleep(1000);
	    registrationPageFactory.setEmail("santhu@gmail.com");
	    Thread.sleep(1000);
	    registrationPageFactory.setGenderFemale();
	    Thread.sleep(1000);
	     registrationPageFactory.setAddress("Chennai");
		

		List<String> objList = numbers.asList(String.class);
		String data=null;
		for (String dataTemp:objList) {
			data=dataTemp;
			registrationPageFactory.getMobile().clear();
			registrationPageFactory.setMobile(dataTemp);
			Thread.sleep(1000);
		    registrationPageFactory.setButton(); 

			
			if (Pattern.matches("^[7-9]{1}[0-9]{9}$",data)) {
				System.out.println("Number format Matching ");
			} else {
				String alertMessage = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println("not matched "+alertMessage);
			
			}
		}
	 
	}


}
