package Test;
import java.time.Duration;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Lab11Part2;
public class Lab11Part2Test {

	private WebDriver driver;
	private Lab11Part2 obj;
	
	@BeforeMethod
	public void setUp() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        
        obj = new Lab11Part2(driver);
        
	}
	
	@Test(priority = 1, description = "Execute Lab 3 and Lab 4 flow using Page Object Model")
    public void testWorkflowPOM() {
        
		
        Assert.assertEquals(driver.getTitle(), "Your Store", "Home page title mismatch!");

        
        obj.navigateToMac();

        
        Assert.assertEquals(obj.getHeadingText(), "Mac", "Mac heading mismatch!");

        
        obj.selectSortBy("Name (A - Z)");

        
        obj.clickAddToCart();


        obj.searchProduct("Monitors");

        
        obj.searchInDescription("Monitors");

        
        Assert.assertEquals(obj.getSearchResultHeading(), "Search - Monitors", "Search results heading mismatch!");
    }
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
