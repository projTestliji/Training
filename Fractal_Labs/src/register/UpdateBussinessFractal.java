package register;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateBussinessFractal {
	private WebDriver driver;
    private Properties properties = new Properties();
    
    //launching the browser
	@BeforeMethod
    public void setUp() throws Exception {
		
        System.setProperty("webdriver.chrome.driver", "C:/Users/deeej/AppData/Downloads/chromedriver_win32/chromedriver.exe");
        
        driver = new ChromeDriver();
       
        properties.load(new FileReader(new File("C:\\Users\\deeej\\eclipse-workspace\\Fractal_Labs\\src\\test.properties")));
    }
	
	// Quiting he browser after test
	
	@AfterMethod
    public void tearDown() throws Exception {
		
        driver.quit();
    }
	
	
    @Test
    public void testSendEmail() throws Exception {
    	
    	//login page
    	driver.get("https://my.askfractal.com/login");
    	
		//enter the username
		driver.findElement(By.name("email")).sendKeys(properties.getProperty("username"));
		
		//enter the password
		driver.findElement(By.name("password")).sendKeys(properties.getProperty("password"));
		
		//Clicking on login button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[3]/div/div/button")).click();
		
		driver.manage().window().maximize(); 
		
		//waiting for the page to load
		Thread.sleep(2000);
		 
		//clicking on edit button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[1]/div/div/span[1]/span[1]/button")).click();
		
		//clearing the existing data
		driver.findElement(By.id("website")).clear();	
		
		//updating with new data
		driver.findElement(By.id("website")).sendKeys("wwww.samplesiteupdate.com");
		
		
		//save the bussiness
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[8]/div/div/button")).click();
		
		
		
    }
}
