package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Lab9TestNG {

    WebDriver driver;
    WebDriverWait wait;

   
    
    public void setUp(WebDriver driver) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
       
        WebElement desktopsTab = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Desktops']"))
        );
        desktopsTab.click();

        WebElement macOption = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mac (1)']"))
        );
        macOption.click();

      
        WebElement macHeading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2"))
        );
        Assert.assertEquals(macHeading.getText(), "Mac", "Mac heading mismatch!");

     
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

       
        WebElement addToCartBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add to Cart']"))
        );
        addToCartBtn.click();

        
        WebElement successBanner = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))
        );
        String actualMessage = successBanner.getText();
        Assert.assertTrue(
            actualMessage.contains("Success: You have added iMac to your shopping cart!"),
            "Cart success message mismatch!"
        );

     
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Mobile");
        searchBox.clear();
        searchBox.sendKeys("Monitors");

        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchBtn.click();

  
        WebElement resultHeading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h1"))
        );
        Assert.assertEquals(resultHeading.getText(), "Search - Monitors", "Search results page title mismatch!");
    }

    @Test
	public void chromeTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		setUp(driver);
	}
	
	@Test
	public void edgeTest() throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		setUp(driver);
	}
  
    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}