package Extras;

import Screenshots.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExtrasPage {

    // Declare WebDriver instance
    WebDriver driver;

    // Constructor to initialize the WebDriver instance
    public ExtrasPage(WebDriver driver) {
        this.driver = driver;
    }
    // Method to select extras options
    public void Shipping(String Shipping) {
        driver.findElement(By.id("shipping-option-express")).click();
    }
    // Method to select warranty options
    public void warranty(String warranty) {
        driver.findElement(By.id("warranty-option-1yr")).click();
    }
    // Method to apply discount code
    public void Discount(String discountCode) {
        driver.findElement(By.id("discount-code")).sendKeys(discountCode);
        driver.findElement(By.id("apply-discount-btn")).click();
    }
    // Method to confirm the purchase
    public void confirmPurchase() {
        driver.findElement(By.id("purchase-device-btn")).click();
    }
}
