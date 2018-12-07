package employeeRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {
	
	WebDriver wd;

	// initiating Elements
	public RegistrationPageFactory(WebDriver webdriver) {
		this.wd = webdriver;
		PageFactory.initElements(wd, this);
	}

	public RegistrationPageFactory() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "txtName")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.NAME, using = "txtEmail")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"Phone\"]")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(xpath = "/html/body/form/table/tbody/tr[5]/td[2]/textarea")
	@CacheLookup
	WebElement address;
	
	@FindBy(how = How.ID, using = "male")
	@CacheLookup
	WebElement genderMale;
	
	@FindBy(how = How.ID, using = "female")
	@CacheLookup
	WebElement genderFemale;
	

	@FindBy(xpath = "/html/body/h2")
	@CacheLookup
	WebElement heading;
	
	@FindBy(how = How.ID, using = "btn")
	@CacheLookup
	WebElement button;


    public WebElement getHeading() {
		return heading;
	}

	public void setHeading(WebElement heading) {
		this.heading = heading;
	}

	

	public WebElement getName() {
		return name;
	}

	public void setName(String nameTemp) {
		name.sendKeys(nameTemp);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String emailTemp) {
		email.sendKeys(emailTemp);
	}

	public WebElement getMobile() {
		return mobile;
	}

	public void setMobile(String mobileTemp) {
		mobile.sendKeys(mobileTemp);
	}

	public WebElement getAddress() {
		return address;
	}

	public void setAddress(String addressTemp) {
		address.sendKeys(addressTemp);
	}

	public WebElement getButton() {
		return button;
	}

	public void setButton() {
		button.click();
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public void setGenderMale() {
		genderMale.click();
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public void setGenderFemale() {
		genderFemale.click();
	}
	

	
	
}
