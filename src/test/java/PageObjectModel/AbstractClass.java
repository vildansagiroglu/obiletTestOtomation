package PageObjectModel;


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.Objects;

public abstract class AbstractClass {
    public WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);


    public void getUrl(String url) {
        driver.get(url);

    }

    public void clickFunction(WebElement clickElement) {
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();

    }

    public void sendKeysFunction(WebElement sendKeysElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }


    public void obSelectDropDown(WebElement dropdown, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        clickFunction(dropdown);
        sendKeysFunction(dropdown, value);


    }

    public void selectFirstFlight(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.findElements(By.tagName("li")).get(0).click();
    }


    public Boolean isChecked(WebElement checkbox) {
        boolean result = false;
        try {
            String value = checkbox.getAttribute("checked");
            if (value != null) {
                result = true;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return result;
    }

    public Boolean isDisplayed(WebElement errorMessage) {
        boolean result = false;
        try {
            String value = errorMessage.getText();
            if (value != null) {
                result = true;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public void checkCurrentUrl(String url) {
        if (!Objects.equals(driver.getCurrentUrl(), url)) {
            Assert.fail("Target url is wrong");
        }

    }

}
