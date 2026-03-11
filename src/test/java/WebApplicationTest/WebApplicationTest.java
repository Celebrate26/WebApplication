package WebApplicationTest;

import Extras.ExtrasPage;
import LoginPage.Login;
import PurchasePage.Purchase;
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
    }

    @Test(priority = 1, description = "Verifies user can login with valid credentials")
    public void testLogin() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress("Okuhle@gmali.com");
        loginPage.enterPassword("@12345678");
        Thread.sleep(2000);
        loginPage.clickSubmitButton();
        Thread.sleep(3000);
        loginPage.verifyLoginSuccess("Welcome back, Okuhle! \uD83D\uDC4B");
    }

    @Test(priority = 2, dependsOnMethods = "testLogin", description = "Verifies product selection")
    public void testProductSelection() throws InterruptedException {
        //
        purchasePage.clickLearnButton();
        Thread.sleep(2000);
        purchasePage.clickLearningMaterialsButton();
        Thread.sleep(2000);
        purchasePage.clickWebAutomationAdvanceButton();
        Thread.sleep(2000);


        // Select product options using the purchasePage object
        purchasePage.selectDeviceType("Phone");
        Thread.sleep(2000);
        purchasePage.selectBrand("Apple");
        Thread.sleep(2000);
        purchasePage.selectStorageOption("128GB");
        Thread.sleep(2000);
        purchasePage.selectColor("Blue");
        Thread.sleep(2000);
        purchasePage.enterQuantity(2);
        Thread.sleep(2000);
        purchasePage.enterAddress("124 West Street");
        Thread.sleep(2000);
        purchasePage.clickNextButton();
    }

    @Test(priority = 3, dependsOnMethods = "testProductSelection")
    public void testExtrasAndCheckout() throws InterruptedException {
        Thread.sleep(2000);
        extrasPage.Shipping("Express (+R25)");
        Thread.sleep(2000);
        extrasPage.warranty("1 Year (+R49)");
        Thread.sleep(2000);
        extrasPage.Discount("save10");
        Thread.sleep(2000);
        extrasPage.confirmPurchase();

        Thread.sleep(2000);
        viewInvoice.viewInvoice();
        Thread.sleep(2000);
        viewInvoice.View();


    }
}