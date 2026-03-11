package LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {

    // Declare WebDriver instance
    WebDriver driver;

    // Create constructor
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login button element located by Xpath
    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[1]")
    WebElement loginButton;

    // Email field for login, located by ID
    @FindBy(id = "login-email")
    WebElement loginEmailField;

    // Password field for login, located by ID
    @FindBy(id = "login-password")
    WebElement loginPasswordField;

    // Submit button for login, located by ID
    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    // Welcome message header
    @FindBy(xpath = "//h2[contains(text(), 'Welcome back')]")
    WebElement welcomeBackMessage;


    // Clicks the login button to proceed with login
    public void clickLoginButton() {
        loginButton.click();
    }
    // Enters the provided email address into the login email field
    public void enterEmailAddress(String email) {
        loginEmailField.sendKeys(email);
    }
    // Enters the provided password into the login password field
    public void enterPassword(String password) {
        loginPasswordField.sendKeys(password);
    }
    // Clicks the submit button to complete the login process
    public void clickSubmitButton() {
        loginSubmitButton.click();
    }
    // Verifies that the login was successful by checking if the welcome message is displayed and matches the expected message
    public void verifyLoginSuccess(String expectedMessage) {
        Assert.assertEquals(welcomeBackMessage.getText(), expectedMessage);
    }

}

