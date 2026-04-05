package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public final class Screenshots {


   WebDriver driver;

   public Screenshots(WebDriver driver){
       this.driver = driver;
   }

    static final String screenshotDir = System.getProperty("user.dir") + "/target/screenshots";

    public void takesSnapShot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotDir, screenshotName + ".jpeg");

        try {
            FileUtils.copyFile(file, destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
