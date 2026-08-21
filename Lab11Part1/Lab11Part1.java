package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Lab11Part1 {
	
	private WebDriver driver;
	private WebDriverWait wait;

    private By desktopsTab = By.xpath("//a[text()='Desktops']");
    private By macOption = By.xpath("//a[contains(text(),'Mac')]");
    private By pageHeading = By.cssSelector("h2");
    private By sortDropdown = By.id("input-sort");
    private By addToCartBtn = By.xpath("//button[contains(@onclick,'cart.add') or span[text()='Add to Cart']]");
    private By successAlert = By.cssSelector(".alert.alert-success");
    private By searchBox = By.name("search");
    private By searchButton = By.xpath("//div[@id='search']//button");
    private By searchCriteriaInput = By.id("input-search");
    private By descriptionCheckbox = By.id("description");
    private By subSearchBtn = By.id("button-search");
    private By searchResultHeading = By.xpath("//div[@id='content']//h1");

    
    
    public Lab11Part1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    public void navigateToMac() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(macOption)).click();
    }

   
    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText();
    }

 
    public void selectSortBy(String optionText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(sortDropdown));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

   
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

   
    public String getSuccessAlertText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert)).getText();
    }

    
    public void searchProduct(String keyword) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchInput.clear();
        searchInput.sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

  
    public void searchInDescription(String keyword) {
        WebElement criteriaInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchCriteriaInput));
        //criteriaInput.clear();
        
        WebElement descCheckbox = driver.findElement(descriptionCheckbox);
        if (!descCheckbox.isSelected()) {
            descCheckbox.click();
        }
        
        driver.findElement(subSearchBtn).click();
    }

    
    public String getSearchResultHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultHeading)).getText();

    }
}
