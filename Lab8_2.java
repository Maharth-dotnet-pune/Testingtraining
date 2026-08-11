package pac1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Lab8_2 {

		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeMethod
		public void setUp() {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			
			driver.get("https://tutorialsninja.com/demo/");
		}
		@Test
		public void workflow() {
			String expectedTitle = "Your Store";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");


	    
	        WebElement desktopsMenu = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Desktops']"))
	        );
	        desktopsMenu.click();

	        WebElement macOption = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Mac')]"))
	        );
	        macOption.click();


	       
	        WebElement macHeading = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mac']"))
	        );
	        Assert.assertTrue(macHeading.isDisplayed(), "'Mac' heading is not displayed on the page!");


	        
	        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
	        Select selectSort = new Select(sortDropdown);
	        selectSort.selectByVisibleText("Name (A - Z)");


	  
	        WebElement addToCartBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@onclick,'cart.add') or span[text()='Add to Cart']]"))
	        );
	        addToCartBtn.click();


	        WebElement searchBox = driver.findElement(By.name("search"));
	        searchBox.clear();
	        searchBox.sendKeys("Monitors");

	        WebElement searchBtn = driver.findElement(By.xpath("//div[@id='search']//button"));
	        searchBtn.click();


	        
	        WebElement searchCriteriaInput = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.id("input-search"))
	        );
	        searchCriteriaInput.clear();

	        WebElement descriptionCheckbox = driver.findElement(By.id("description"));
	        if (!descriptionCheckbox.isSelected()) {
	            descriptionCheckbox.click();
	        }

	        WebElement subSearchBtn = driver.findElement(By.id("button-search"));
	        subSearchBtn.click();
		}
		@AfterMethod
		public void close() {
			if(driver!=null) {
				driver.quit();
			}
		}

	}
