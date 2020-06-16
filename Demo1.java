import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 
{
	WebDriver d;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\selenium\\selenium-firefox-driver\\geckodriver.exe");
		d= new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		d.get("http://kys.testanddev.powergyan.com/");
		function();
		
	}
	
	public void function() 
	{
		JavascriptExecutor jse = (JavascriptExecutor)d;
		jse.executeScript("window.scrollBy(0,500)");
		
		d.findElement(By.id("username")).sendKeys("admin");
		d.findElement(By.id("password")).sendKeys("Admin@demo18");
		d.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.findElement(By.xpath("//a[@href='http://kys.testanddev.powergyan.com/admin/search.php']")).click();
		System.out.println("Test Passed");
		closeBrowser();
	}
	
	public void closeBrowser() {
		d.close();
	}

	public static void main(String[] args) 
	{
		Demo1 obj = new Demo1();
		obj.invokeBrowser();
							
	}

}


