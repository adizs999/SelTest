package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;



public class UserLogin {public ChromeDriver driver;
@BeforeClass
public void beforeClass() {System.setProperty("webdriver.chrome.driver", "C:\\Users\\adini\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();}


	

@Test
public  void t1ValidData() throws InterruptedException {
	System.out.println("----------------------------------------------");
		System.out.println("Logging in with Valid Credentials");
		driver.get("http://127.0.0.1:5501/index.html");
		//WebElement user = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/div[1]/input"));
		WebElement user=driver.findElement(By.id("email"));
		user.sendKeys("grofazz@gmail.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("Aniket@3103");
		Actions actions = new Actions(driver);
		WebElement login = driver.findElement(By.id("submitBtn"));
		
		actions.moveToElement(login).build().perform();Thread.sleep(1000);
		actions.click().build().perform();
		Thread.sleep(2000);String correctUrl="http://127.0.0.1:5501/pages/home.html";Thread.sleep(2000);String resUrl=driver.getCurrentUrl();
		try{Thread.sleep(1000);
			Assert.assertEquals(correctUrl, resUrl);
			}
		catch(ComparisonFailure cf) {
			
			System.out.println("\nTest case failed");
			System.out.println("----------------------------------------------");
			
			return;
			} System.out.println("\nLogin Successful!");
				System.out.println("Test case Passed");
				System.out.println("----------------------------------------------");
				
		}
@Test
public  void t2InvalidData() throws InterruptedException {
	System.out.println("----------------------------------------------");
	System.out.println("\nLogging in with Invalid credentials");
		driver.get("http://127.0.0.1:5501/index.html");
		//WebElement user = driver.findElement(By.xpath("/html/body/div/form/div/div[2]/div[1]/input"));
		WebElement user=driver.findElement(By.id("email"));
		user.sendKeys("grofazz@gmail.com");
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("Aniket@310");
		Actions actions = new Actions(driver);
		WebElement login = driver.findElement(By.id("submitBtn"));
		
		actions.moveToElement(login).build().perform();Thread.sleep(1000);
		actions.click().build().perform();
		Thread.sleep(2000);String correctUrl="http://127.0.0.1:5501/pages/home.html";Thread.sleep(2000);String resUrl=driver.getCurrentUrl();
		try{Thread.sleep(1000);
			Assert.assertEquals(correctUrl, resUrl);
			}
		catch(ComparisonFailure cf) {
			System.out.println("\nLogin Unsuccessful!");
			System.out.println("Test Case Passed");
			System.out.println("----------------------------------------------");
			
			return;
			}
				System.out.println("\nTest case Failed");
				System.out.println("----------------------------------------------");
				
		}
	@AfterClass
	public void AfterClass() {
		System.out.println("Test case execution completed");driver.close();
	}
	}
