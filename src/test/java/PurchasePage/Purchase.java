package PurchasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Purchase {

    // Declare WebDriver instance
    WebDriver driver;

    // Declare WebDriverWait instance
    WebDriverWait wait;

    // Constructor to initialize WebDriver and pageFactory
    public Purchase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Learn button element located by Xpath
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    WebElement learnButton;

    // Learning Materials button element located by Xpath
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]")
    WebElement LearningMaterialsButton;

    // Web Automation Advance button element located by Xpath
    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]/span[2]")
    WebElement WebAutomationAdvanceButton;

    // Device Type dropdown element located by ID
    @FindBy(id = "deviceType")
    WebElement deviceTypeDropdown;

    // Brand dropdown element located by ID
    @FindBy(id = "brand")
    WebElement brandDropdown;

    // Storage option checkbox element located by Xpath
    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]/span")
    WebElement StorageOption;

    // Color dropdown element located by ID
    @FindBy(id = "color")
    WebElement colorDropdown;

    // Quantity field element located by ID
    @FindBy(id = "quantity")
    WebElement quantityField;

    // Address field element located by ID
    @FindBy(id = "address")
    WebElement addressField;

    // Next button element located by ID
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    // Clicks the learn button to access learning materials
    public void clickLearnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(learnButton)).click();
    }

    // Clicks the learning materials button to view available learning materials
    public void clickLearningMaterialsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LearningMaterialsButton)).click();

    }

    // Clicks the web automation advance button to access the web automation advance course
    public void clickWebAutomationAdvanceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(WebAutomationAdvanceButton)).click();
    }

    // Selects a device type from the dropdown menu based on the provided device type
    public void selectDeviceType(String deviceType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeDropdown));
        Select select = new Select(deviceTypeDropdown);
        select.selectByVisibleText(deviceType);

    }
    // Selects a brand from the dropdown menu based on the provided brand
    public void selectBrand(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        Select select = new Select(brandDropdown);
        select.selectByVisibleText(brand);
    }

    // Clicks the storage option checkbox to select it
    public void selectStorageOption(String storageOption) {
        wait.until(ExpectedConditions.elementToBeClickable(StorageOption)).click();
    }
    // Selects a color from the dropdown menu based on the provided color
    public void selectColor(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(colorDropdown));
        Select select = new Select(colorDropdown);
        select.selectByVisibleText(color);
    }
    // Enters the specified quantity into the quantity field after clearing any existing value
    public void enterQuantity(int quantity) {
        wait.until(ExpectedConditions.elementToBeClickable(quantityField));
        quantityField.sendKeys(String.valueOf(quantity));
    }
    // Enters the provided address into the address field
    public void enterAddress(String address) {
        wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressField.sendKeys(address);
    }
    // Clicks the next button to proceed to the next step in the purchase process
    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

}














