package PageObjectModel;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class newAccount extends AbstractClass {

    WebDriver driver;
    @FindBy(xpath = "/html/body/header/div[1]/div/ul/li[1]/a")
    private WebElement memberLoginButton;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[5]/a")
    private WebElement registerButton;
    @FindBy(name = "email")
    private WebElement emailAddressInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(id = "contract-checkbox")
    private WebElement checkbox;
    @FindBy(xpath = "//*[@id=\"register-form\"]/div[6]/button")
    private WebElement submitButton;
    @FindBy(name = "email")
    private WebElement emptyEmail;
    @FindBy(name = "password")
    private WebElement emptyPassword;
    @FindBy(id = "email-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "password-error")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "//*[@id=\"register-form\"]/div[6]/div[1]/label")
    private WebElement errorMessage;

    public newAccount() {
        driver = Driver.getDriver(); //utilitiesdeki ana drivera bagladik
        PageFactory.initElements(driver, this); //findBy fonksiyonlarinin calisabilmesi icin
    }

    public void clickMemberLoginButton() {
        clickFunction(memberLoginButton);
    }

    public void clickRegisterButton() {
        clickFunction(registerButton);
    }

    public void typeEmail(String email) {
        sendKeysFunction(emailAddressInput, email);

    }

    public void typePassword(String password) {
        sendKeysFunction(passwordInput, password);
    }

    public void checkClarificationTextCheckboxIsSelected() {
        Boolean result = isChecked(checkbox);
        if (!result) {
            clickFunction(checkbox);
        }

    }

    public void clickSubmitButton() {
        clickFunction(submitButton);
    }

    public void IRegisteredSuccessfully() {
        driver.get("https://www.obilet.com/?kayit");
    }

    public void leaveEmailInputEmpty() {
        sendKeysFunction(emptyEmail, "");
    }

    public void leavePasswordInputEmpty() {
        sendKeysFunction(emptyPassword, "");
        clickFunction(submitButton);

    }

    public void setEmailErrorMessage() {
        try {
            leaveEmailInputEmpty();
            isDisplayed(emailErrorMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void setPasswordErrorMessage() {
        try {
            leavePasswordInputEmpty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setErrorMessage() {
        if (!isDisplayed(errorMessage)) {
            Assert.fail("The expected error message for an existing email address could not be displayed.");
        }

    }

}
