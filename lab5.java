package pac1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


 
public class lab5 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello");
		
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		System.out.println("The tile of opencart page is:"+driver.getTitle());
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		
	System.out.println("Register Title is:"+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String expectedwarning="Warning: You must agree to the Privacy Policy!";
		
		String actualwarning;
		
		actualwarning=driver.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		
		if(expectedwarning.equals(actualwarning))
		{
			System.out.println("warning message is displayed as expected");
		}
		
		else
		{
			System.out.println("warning message is not displayed as expected");
		}
		
		WebElement firstnameinput= driver.findElement(By.id("input-firstname"));
		
		firstnameinput.sendKeys("123456789012345678901234567890123");
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		WebElement firstNameError=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div"));
		if (firstNameError.isDisplayed()) {
            System.out.println("PASS: First Name 33-character error verified -> " + firstNameError.getText());
        } else {
            System.out.println("FAIL: First Name error message not displayed.");
        }
		firstnameinput= driver.findElement(By.id("input-firstname"));
		firstnameinput.clear();
		firstnameinput.sendKeys("maharth");
		
		WebElement lastnameinput= driver.findElement(By.id("input-lastname"));
		lastnameinput.clear();
		lastnameinput.sendKeys("123456789012345678901234567890123");
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		WebElement lastNameError=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"));
		if (lastNameError.isDisplayed()) {
            System.out.println("PASS: last Name 33-character error verified -> " + lastNameError.getText());
        } else {
            System.out.println("FAIL: last Name error message not displayed.");
        }
		lastnameinput= driver.findElement(By.id("input-lastname"));
		lastnameinput.clear();
		lastnameinput.sendKeys("uprit");
		
		WebElement emailinput= driver.findElement(By.id("input-email"));
		emailinput.sendKeys("example@ex.com");
		
		WebElement phoneinput=driver.findElement(By.id("input-telephone"));
		phoneinput.sendKeys("1234567890");
		
		WebElement passwordinput=driver.findElement(By.id("input-password"));
		passwordinput.sendKeys("password@123");
		
		WebElement confirminput=driver.findElement(By.id("input-confirm"));
		confirminput.sendKeys("password@123");
		
		WebElement newsletterYesRadio = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']"));
        newsletterYesRadio.click();
        
        WebElement privacyPolicyCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicyCheckbox.click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        WebElement success=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        if (success.getText().equals("Your Account Has Been Created!")) {
            System.out.println("PASS: Account created successfully!");
        } else {
            System.out.println("FAIL: Account creation failed or heading mismatch.");
        }
		
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        
        driver.findElement(By.linkText("View your order history")).click();
        
        driver.quit();
	}
 
}