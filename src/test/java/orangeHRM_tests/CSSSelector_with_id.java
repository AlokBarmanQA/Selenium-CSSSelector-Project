package orangeHRM_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector_with_id {
	// https://opensource-demo.orangehrmlive.com/
	
	@Test
	public void orangeHRM_login_test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		WebElement txtbox_username = driver.findElement(By.cssSelector("input#txtUsername"));
		WebElement txtbox_password = driver.findElement(By.cssSelector("input#txtPassword"));
		WebElement btn_login = driver.findElement(By.cssSelector("input#btnLogin"));
		txtbox_username.sendKeys("Admin");
		txtbox_password.sendKeys("admin123");
		btn_login.click();
		String expected = "OrangeHRM";
		Assert.assertEquals(driver.getTitle(), expected);
		driver.close();
	}
}
