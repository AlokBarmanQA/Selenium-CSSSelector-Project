package blazemeter_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector_class_Equal_value {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://auth.blazemeter.com/auth/realms/blazect/protocol/openid-connect/registrations?client_id=account&response_type=code");
	}
	@Test(priority=0)
	public void hubspot_Login_with_google_Test() {
		WebElement register_with_Google = driver.findElement(By.cssSelector("a[class='zocial google rounded'][id='zocial-google']"));
		register_with_Google.click();
		WebElement Sign_in_with_Google_Text = driver.findElement(By.cssSelector("div[class*='kHn9Lb']"));
		String expected = "Sign in with Google";
		String actual = Sign_in_with_Google_Text.getText();
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=1)
	public void hubspot_Login_with_form_Test() {
		WebElement input_first_name = driver.findElement(By.cssSelector("input[name^='first']"));
		WebElement input_last_name = driver.findElement(By.cssSelector("input[name*='astNam']"));
		WebElement input_email = driver.findElement(By.cssSelector("input[name$='il']"));
		WebElement input_company = driver.findElement(By.cssSelector("input#user.attributes.company, [name='user.attributes.company']"));
		input_first_name.sendKeys("Alok");
		input_last_name.sendKeys("Barman");
		input_email.sendKeys("abc@xyz.com");
		input_company.sendKeys("alok.kumar.barman");
		String actual = input_first_name.getAttribute("value");
		String expected = "Alok";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=2)
	public void hubspot_Login_Negative_Test() {
		WebElement button_register = driver.findElement(By.cssSelector("input#rounded btn btn-primary btn-block btn-lg, [type='submit']"));
		button_register.click();
		WebElement error_message = driver.findElement(By.cssSelector("span.kc-feedback-text"));
		String actual = error_message.getText();
		Assert.assertTrue(actual.contains("Please specify"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
