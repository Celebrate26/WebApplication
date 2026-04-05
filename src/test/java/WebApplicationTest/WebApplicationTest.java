package WebApplicationTest;

import Extras.ExtrasPage;
import LoginPage.Login;
import PurchasePage.Purchase;
import Screenshots.Screenshots;
import ViewInvoice.ViewInvoice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class WebApplicationTest {

    // Declare WebDriver and Page Object instances
    WebDriver driver;
    Login loginPage;
    Purchase purchasePage;
    ExtrasPage extrasPage;
    ViewInvoice viewInvoice;
    Screenshots screenshots;

    @BeforeClass
    public void setup() throws InterruptedException {

        // Initialize WebDriver and navigate to the application
        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        // Initialize Page Objects
        loginPage = new Login(driver);
        purchasePage = new Purchase(driver);
        extrasPage = new ExtrasPage(driver);
        viewInvoice = new ViewInvoice(driver);
        screenshots = new Screenshots(driver);
    }

    @Test(priority = 1, description = "Verifies user can login with valid credentials")
    public void testLogin() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.clickLoginButton();
        screenshots.takesSnapShot(driver, "01_Login_Page");
        loginPage.enterEmailAddress("Okuhle@gmali.com");
        loginPage.enterPassword("@12345678");
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(3000);
        loginPage.verifyLoginSuccess("Welcome back, Okuhle! \uD83D\uDC4B");
        screenshots.takesSnapShot(driver, "02_Login_Success");
    }

    @Test(priority = 2, dependsOnMethods = "testLogin", description = "Verifies product selection")
    public void testProductSelection(){
        // Navigate to the purchase page using the purchasePage object
        purchasePage.clickLearnButton();
        screenshots.takesSnapShot(driver, "03_Learn_Section");
        purchasePage.clickLearningMaterialsButton();
        purchasePage.clickWebAutomationAdvanceButton();
        screenshots.takesSnapShot(driver, "04_Product_Selected");

        // Select product options using the purchasePage object
        purchasePage.selectDeviceType("Phone");
        purchasePage.selectBrand("Apple");
        purchasePage.selectStorageOption("128GB");
        purchasePage.selectColor("Blue");
        purchasePage.enterQuantity(2);
        purchasePage.enterAddress("124 West Street");
        screenshots.takesSnapShot(driver, "05_Product_Options_Configured");
        purchasePage.clickNextButton();
    }

    @Test(priority = 3, dependsOnMethods = "testProductSelection")
    public void testExtrasAndCheckout() throws InterruptedException {
        Thread.sleep(2000);
        extrasPage.Shipping("Express (+R25)");
        screenshots.takesSnapShot(driver, "06_Shipping_Selected");
        Thread.sleep(2000);
        extrasPage.warranty("1 Year (+R49)");
        screenshots.takesSnapShot(driver, "07_Warranty_Selected");
        Thread.sleep(2000);
        extrasPage.Discount("save10");
        screenshots.takesSnapShot(driver, "08_Discount_Applied");
        Thread.sleep(2000);
        extrasPage.confirmPurchase();
        screenshots.takesSnapShot(driver, "09_Purchase_Confirmed");

        Thread.sleep(2000);
        viewInvoice.viewInvoice();
        Thread.sleep(2000);
        viewInvoice.View();
        screenshots.takesSnapShot(driver, "10_Invoice_Viewed");
    }
}