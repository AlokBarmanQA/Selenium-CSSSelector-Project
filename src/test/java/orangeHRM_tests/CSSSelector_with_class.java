package orangeHRM_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelector_with_class {
	
	@Test
	public void orangeHRM_login_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		WebElement txtbox_username = driver.findElement(By.cssSelector("div.textInputContainer>input#txtUsername"));
		WebElement txtbox_password = driver.findElement(By.cssSelector("div.textInputContainer>input#txtPassword"));
		WebElement btn_login = driver.findElement(By.cssSelector("input.button"));
		txtbox_username.sendKeys("Admin");
		Thread.sleep(2000);
		txtbox_password.sendKeys("admin123");
		Thread.sleep(2000);
		btn_login.click();
		String expected = "OrangeHRM";
		Assert.assertEquals(driver.getTitle(), expected);
		driver.close();
	}
}
