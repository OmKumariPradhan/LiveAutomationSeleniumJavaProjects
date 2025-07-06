package QAFOX;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifytheRegister {
 @Test
	public void  VerifyingTheRegister() {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Om Kumari");
		driver.findElement(By.id("input-lastname")).sendKeys("Pradhan");
		driver.findElement(By.id("input-email")).sendKeys(GenerateMail());
		driver.findElement(By.id("input-telephone")).sendKeys("123456791");
		driver.findElement(By.id("input-password")).sendKeys("sim12");
		driver.findElement(By.id("input-confirm")).sendKeys("sim12");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String expectedProperDetailOne= "Your Account Has Been Created!";
		String expectedProperDetailTwo= "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailThree= "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailFour= "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailFive="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailSix= "contact us";
		
		String ActualProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailOne));
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailTwo));
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailThree));
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailFour));
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailFive));
		Assert.assertTrue(ActualProperDetails.contains(expectedProperDetailSix));

		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	
	}
	public String GenerateMail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","") + "@gmail.com"; //chaining method
		
	
	
	}

}


