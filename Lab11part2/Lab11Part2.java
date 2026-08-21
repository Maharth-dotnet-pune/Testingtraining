package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Lab11Part2 {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[text()='Desktops']")
    private WebElement desktopsTab;

    @FindBy(xpath = "//a[contains(text(),'Mac')]")
    private WebElement macOption;

    @FindBy(css = "h2")
    private WebElement pageHeading;

    @FindBy(id = "input-sort")
    private WebElement sortDropdown;

    @FindBy(xpath = "//button[contains(@onclick,'cart.add') or span[text()='Add to Cart']]")
    private WebElement addToCartBtn;

    @FindBy(css = ".alert.alert-success")
    private WebElement successAlert;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@id='search']//button")
    private WebElement searchButton;

    @FindBy(id = "input-search")
    private WebElement searchCriteriaInput;

    @FindBy(id = "description")
    private WebElement descriptionCheckbox;

    @FindBy(id = "button-search")
    private WebElement subSearchBtn;

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement searchResultHeading;

    
    
    public Lab11Part2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    
    public void navigateToMac() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(macOption)).click();
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOf(pageHeading)).getText();
    }

    public void selectSortBy(String optionText) {
        wait.until(ExpectedConditions.visibilityOf(sortDropdown));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(optionText);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public String getSuccessAlertText() {
        return wait.until(ExpectedConditions.visibilityOf(successAlert)).getText();
    }

    public void searchProduct(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }

    public void searchInDescription(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(searchCriteriaInput));
        //searchCriteriaInput.clear();
        //searchCriteriaInput.sendKeys(keyword);

        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
        }

        subSearchBtn.click();
    }

    public String getSearchResultHeading() {
        return wait.until(ExpectedConditions.visibilityOf(searchResultHeading)).getText();
    }
  
}