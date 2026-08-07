package pac1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		WebElement emailinput=driver.findElement(By.id("input-email"));
		emailinput.sendKeys("example@ex.com");
		WebElement passwordinput=driver.findElement(By.id("input-password"));
		passwordinput.sendKeys("password@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement components=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Components']")));
		components.click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		WebElement showDropdownelement=driver.findElement(By.id("input-limit"));
		Select showDropdown= new Select(showDropdownelement);
		showDropdown.selectByVisibleText("25");
		List<WebElement> addToCarts=driver.findElements(By.xpath("//span[text()='Add to Cart']"));
	    addToCarts.get(0).click();
	    
	    

	 
	    WebElement specificationTab = wait.until(
	    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Specification')]")));
	    specificationTab.click();
		
		WebElement spectable=driver.findElement(By.id("tab-specification"));
		if(spectable.isDisplayed()) {
			System.out.println("PASS: specification table displayed");
		} else {
			System.out.println("FAIL: specification table NOT displayed");
		}
		
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
		
		WebElement wishlistsuccess= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
		String Actualmessage=wishlistsuccess.getText();
		
		if(Actualmessage.contains("Success: You have added Apple Cinema 30\" to your wish list!")) {
			System.out.println("PASS: Wishlist success message verified");
		}else {
			System.out.println("FAIL: Text mismatch");
			}
		
		WebElement SearchInput=driver.findElement(By.name("search"));
		SearchInput.sendKeys("Mobile");
		
		driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		
		WebElement descriptioncheckbox=wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
		
		if(!descriptioncheckbox.isSelected()) {
			descriptioncheckbox.click(); 
		}
		
		driver.findElement(By.id("button-search")).click();
		
		driver.findElement(By.linkText("HTC Touch HD")).click();
		
		WebElement qtyinput=driver.findElement(By.id("input-quantity"));
		qtyinput.clear();
		qtyinput.sendKeys("3");
		
		driver.findElement(By.id("button-cart")).click();
		
		WebElement cartsuccess= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
		String cartmessage= cartsuccess.getText();
		if(cartmessage.contains("Success: You have added HTC Touch HD to your shopping cart!")){
			System.out.println("PASS: CART success message verified");
		} else {
			System.out.println("FAIL: Text mismatch");
		}
		
		WebElement viewcart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='cart-total']")));
		viewcart.click();
		
		
		WebElement cartItem= driver.findElement(By.linkText("HTC Touch HD"));
		String namecheck=cartItem.getText();
		if(namecheck.contains("HTC Touch HD")) {
			System.out.println("PASS: Mobile Name verified");
		} else {
			System.out.println("FAIL: Text mismatch");
		}
		
		driver.findElement(By.linkText("Checkout")).click();
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();

		driver.findElement(By.linkText("Logout")).click();
		
		WebElement logouttext= driver.findElement(By.xpath("//h1[text()='Account Logout']"));
		String logoutmessage=logouttext.getText();
		if(logoutmessage.contains("Account Logout")) {
			System.out.println("PASS: Account Logout heading verified");
		} else {
			System.out.println("FAIL: Text mismatch");
		}
		
		driver.findElement(By.linkText("Continue")).click();
		
		driver.quit();
		}
		}

