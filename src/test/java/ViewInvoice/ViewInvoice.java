package ViewInvoice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewInvoice {
    // Declare WebDriver instance
    WebDriver driver;

    // Constructor to initialize the WebDriver instance
    public ViewInvoice(WebDriver driver) {
        this.driver = driver;
    }

    // Method to view the invoice
    public void viewInvoice() {
        driver.findElement(By.id("view-history-btn")).click();
    }
    // Method to view the invoice details
    public void View(){
        driver.findElement(By.xpath("/html/body/div/div[1]")).click();
    }

}
