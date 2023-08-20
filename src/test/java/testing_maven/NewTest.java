package testing_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test 
public class NewTest {

	WebDriver driver;

	@BeforeTest (groups={"smoke"})
	public void Setup() {

		String browserName = "firefox";

		if (browserName.equals("chrome"))

		{

			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();
		}

	}

	@AfterTest (groups={"smoke"})
	public void CloseBrowser() {

		driver.quit();

	}
	
	
	@Test(priority = 1,groups={"smoke"})
	public void launchbrowserWithWrongUserName() throws InterruptedException {
		
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(1000);

		String actualWarningMessage = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]"))
				.getText();
		String expectedWarningMessage = "Invalid credentials";

		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);

	}

	@Test(priority = 2, groups={"smoke"})
	public void launchbrowser() throws InterruptedException {

		// driver = new FirefoxDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);

		// Click Submit
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(1000);

		// Click Profile
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
		Thread.sleep(2000);

		// Click Logout
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 3, groups={"smoke"})
	public void recruitment() throws InterruptedException {

		// driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(1000);

		// Click Submit
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(1000);

		// Click Recruitment
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
		Thread.sleep(1000);

		// Click add button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		Thread.sleep(2000);

		// Enter Full Name
		driver.findElement(By.name("firstName")).sendKeys("Shuvo");

		// Enter Middle Name
		driver.findElement(By.name("middleName")).sendKeys("Shuvo");

		// Enter Last Name
		driver.findElement(By.name("lastName")).sendKeys("shuvo");
		Thread.sleep(2000);

		// Enter Email
		driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input"))
				.sendKeys("abs@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 4, groups = {"regression"})
	public void demostore() throws InterruptedException {

		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);

		//Click Submit
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"))
				.sendKeys("my info");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();
		Thread.sleep(2000);

		// Click Profile
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
		Thread.sleep(2000);

		// Click Logout
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		Thread.sleep(2000);

	}

}
