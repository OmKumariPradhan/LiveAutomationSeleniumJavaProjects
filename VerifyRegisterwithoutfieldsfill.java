package TutorialQAFox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyRegisterwithoutfieldsfill {
@Test
public void verifyEmptyRegisterFormErrors() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedPolicy="Warning: You must agree to the Privacy Policy!";
		String ExpectedFirstName ="First Name must be between 1 and 32 characters!";
		String ExpectedLastName ="Last Name must be between 1 and 32 characters!";
		String ExpectedEmail ="E-Mail Address does not appear to be valid!";
		String ExpectedTelephone ="Telephone must be between 3 and 32 characters!";
		String ExpectedPassword ="Password must be between 4 and 20 characters!";
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), ExpectedPolicy);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(), ExpectedFirstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), ExpectedLastName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), ExpectedEmail);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), ExpectedTelephone);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), ExpectedPassword);
		
		driver.quit();
		
	}

}
