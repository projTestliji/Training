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

public class UpdateBussinessBySearch {
	
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
    public void testUpdate() throws Exception {
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
	
	//click on the downward arrow button to search the company needed to be updated
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[1]/div/div/span[1]/span[2]/button")).click();
	
	//type the company name to be updated
	driver.findElement(By.xpath("//input[contains(@id,'Search') and contains(@placeholder, 'Search Company')]")).sendKeys(properties.getProperty("updatecompany"));
	
	Thread.sleep(3000);
	
	//clicking on the edit button of the company name to be updated 
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[1]/div/div/span[1]/span[1]/button")).click();
	
	Thread.sleep(3000);

	
	//clearing the existing data
	driver.findElement(By.id("website")).clear();	
			
	//updating with new data
	driver.findElement(By.id("website")).sendKeys(properties.getProperty("updatewebsite"));
	
	
	//save the bussiness
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[8]/div/div/button")).click();

	
	
}
}
