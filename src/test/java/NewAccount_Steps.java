import PageObjectModel.AbstractClass;
import PageObjectModel.newAccount;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

public class NewAccount_Steps extends AbstractClass {

    newAccount newAccount = new newAccount();
    private WebDriver driver;

    @io.cucumber.java.en.Given("^I have obiletcom main page$")
    public void IHaveObiletComMainPage() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        getUrl("https://www.obilet.com/");
        //driver.navigate();
    }


    @Then("I accessed the main page successfully")
    public void IAccessedTheMainPageSuccessfully() {
        checkCurrentUrl("https://www.obilet.com/");

    }

    @And("Click member login button")
    public void clickMemberLoginButton() {
        newAccount.clickMemberLoginButton();

    }

    @And("Click register button")
    public void clickRegisterButton() {
        newAccount.clickRegisterButton();
    }

    @And("Fill {string} email address input")
    public void fillEmailAddressInput(String email) {
        newAccount.typeEmail(email);
    }

    @And("Fill {string} password input")
    public void fillPasswordInput(String password) {
        newAccount.typePassword(password);
    }

    @And("Check Clarification Text checkbox is selected")
    public void checkClarificationTextCheckboxIsSelected() {
        newAccount.checkClarificationTextCheckboxIsSelected();
    }


    @When("Click submit button")
    public void clickSubmitButton() {
        newAccount.clickSubmitButton();

    }

    @Then("I registered successfully")
    public void IRegisteredSuccessfully() {
        newAccount.IRegisteredSuccessfully();

    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(5000);

        //Driver.closeDriver();
    }


    @And("Leave email input empty")
    public void leaveEmailInputEmpty() {
        newAccount.leaveEmailInputEmpty();
    }

    @And("Leave password input empty")
    public void leavePasswordInputEmpty() {
        newAccount.leavePasswordInputEmpty();
    }


    @Then("Email error message displayed")
    public void emailErrorMessageDisplayed() {
        newAccount.setEmailErrorMessage();
    }

    @Then("Password error message displayed")
    public void passwordErrorMessageDisplayed() {
        newAccount.setPasswordErrorMessage();
        Driver.closeDriver();
    }

    @Then("Error message displayed")
    public void errorMessageDisplayed() {
        newAccount.setErrorMessage();
    }

}
