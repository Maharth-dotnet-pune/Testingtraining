package pac1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://letcode.in/alert/");
        driver.findElement(By.id("accept")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        
        driver.findElement(By.id("confirm")).click();
        alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        
        driver.findElement(By.id("prompt")).click();
        alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        
        alert.sendKeys("Maharth");
        alert.accept();
        WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myName")));
        System.out.println(name.getText());
        
        WebElement modernalert= driver.findElement(By.id("modern"));
        
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", modernalert);
        
        js.executeScript("arguments[0].click();",modernalert);
        
        System.out.println(driver.findElement(By.xpath("//div[@class='card-content']//p")).getText());
        WebElement closeBtn = driver.findElement(By.xpath("//button[@aria-label='close']"));

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", closeBtn);
	}
}
