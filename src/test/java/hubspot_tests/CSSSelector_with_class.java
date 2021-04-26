package hubspot_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector_with_class {
	
	@Test
	public void hubspot_Login_Test() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login");
	}
}
