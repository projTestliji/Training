package register;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCompanyNew {
	
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
		
	    Thread.sleep(2000);
	    //Clicking the add bussiness button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[1]/div/div/span/a")).click();
		
		//create company page is opened
		//enter the name of the company
		driver.findElement(By.id("name")).sendKeys(properties.getProperty("name"));
		
		//enter the website of the bussiness
		driver.findElement(By.id("website")).sendKeys(properties.getProperty("website"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//enter the city name and click the option
		driver.findElement(By.id("city")).clear();

		driver.findElement(By.id("city")).sendKeys(properties.getProperty("city"));
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[3]/div/div/div/div[2]/div")).click();
		
		Thread.sleep(2000);

		//select the financial year end month from the dropdown
		driver.findElement(By.xpath(".//div/div/div/div[1]/main/div/div[2]/form/div[5]/div/div/div/div/div")).click();
		
		List<WebElement> monthList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form")).findElement(By.xpath(".//div[5]/div/div/div/div[2]")).findElements(By.tagName("div"));
		
		for(WebElement li : monthList )
		{
			
		if (li.getText().contentEquals(properties.getProperty("month")))
			{
			li.click();
			break;
			}
		}
	
		
		//select the financial year end day from the dropdown 
	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[6]/div/div/div/div/div")).click();
		
		List<WebElement> dayList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[6]/div/div/div/div[2]")).findElements(By.tagName("div"));
		
		for(WebElement li : dayList )
		{
			if (li.getText().contentEquals(properties.getProperty("day")))
				{
			li.click();
			break;
				}
		}
	
		//enter the description of the bussiness
	
		driver.findElement(By.id("description")).sendKeys(properties.getProperty("description"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//select the bussiness segment
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[8]/div/div/div/div[1]")).click();

		List<WebElement> busSegList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[8]/div/div/div/div[2]")).findElements(By.tagName("div"));
		
		for(WebElement li : busSegList )
		{
			if (li.getText().contentEquals(properties.getProperty("bussiness")))
				{
					li.click();
					break;
				}
		}
		
	
	
		//Clicking on create bussiness button
		Thread.sleep(2000);
		
		WebElement element =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/main/div/div[2]/form/div[10]/div/div/button"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).click().build().perform();
		
		Thread.sleep(5000);
		
		//checking the alert message and closing the alert box
		
		String alertMessage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/h3")).getText();
		
		Assert.assertEquals(alertMessage, "Company created");

		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/span/button")).click();

	
	
    	
    }

}
