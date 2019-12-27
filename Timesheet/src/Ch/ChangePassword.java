package Ch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;

public class ChangePassword {

	WebDriver driver;
	//ExtentTest test1;
	@BeforeMethod
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\neerajtesting\\Desktop\\workspace\\Timesheet\\ChromeDriver2.36\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("http://mydsr.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin@!786");
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'My Profile')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='sub']/li[2]/a[contains(text(),'Change Password')]")).click();
	}
	@Test(priority=0)
	public void CurrentPasswordValidation()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).click();
		String ErrorCurrentPassword=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[1]/label[2]")).getText();
		String actualErrorCurrentPassword = "Please enter your current password";
		Assert.assertEquals(ErrorCurrentPassword, actualErrorCurrentPassword);
		boolean Astrix=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[1]/label[1]/em")).isDisplayed();
		Assert.assertEquals(Astrix,true);
	}
	@Test(priority=1)
	public void NewPasswordValidation()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).click();
		String ErrorNewPassword=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[2]/label[2]")).getText();
		String actualErrorNewPassword = "Please enter your new password";
		Assert.assertEquals(ErrorNewPassword, actualErrorNewPassword);
		boolean Astrix=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[2]/label[1]/em")).isDisplayed();
		Assert.assertEquals(Astrix,true);
	}
	
	@Test(priority=2)
	public void ConfirmPasswordValidation()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).click();
		String ErrorConfirmPassword=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[3]/label[2]")).getText();
		String actualErrorConfirmPassword = "Please enter your confirm password";
		Assert.assertEquals(ErrorConfirmPassword, actualErrorConfirmPassword);
		boolean Astrix=driver.findElement(By.xpath("//*[@id='changePasswordForm']/div/div/div[3]/label[1]/em")).isDisplayed();
		Assert.assertEquals(Astrix,true);
	}
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		driver.quit();
		
	}
	
	
}
