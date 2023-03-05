package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static WebDriver driver;
    public  static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);

        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
