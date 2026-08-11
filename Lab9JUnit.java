package pac1;

import java.time.Duration;

// JUnit 4 Imports
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Selenium Imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab9JUnit {

    WebDriver driver;

    public void workFlow() {
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Desktops']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mac (1)']"))).click();

        
        String macHeading = driver.findElement(By.cssSelector("h2")).getText();
        assertEquals("Mac", macHeading);

       
        WebElement sortDropdown = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();

        
        WebElement successMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))
        );
        String actualMessage = successMessage.getText();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains("Success: You have added iMac to your shopping cart!"));


        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys("Mobile");
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

      
        String resultPageHeading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']//h1"))
        ).getText();
        assertEquals("Search - Monitors", resultPageHeading);
    }

    @Test
    public void chromeTest() {
    
        driver = new ChromeDriver();
        workFlow();
    }

    @Test
    public void edgeTest() {
         driver = new EdgeDriver();
        workFlow();
    }

    
    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}