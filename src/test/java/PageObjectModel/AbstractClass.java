package PageObjectModel;


import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

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

    public void selectElementFromDropDown(WebElement dropdown, String element) {
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(element);
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

//    public void Assertion(WebElement actual, String expected) {
//        wait.until(ExpectedConditions.visibilityOf(actual));
//        Assert.assertEquals(actual.getText(), expected);
//        System.out.println("The message is " + actual.getText());
//    }


}
