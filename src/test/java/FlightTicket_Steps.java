import PageObjectModel.AbstractClass;
import PageObjectModel.flightTicket;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class FlightTicket_Steps extends AbstractClass {

    flightTicket flightTicket = new flightTicket();


    @And("Choose departure")
    public void chooseDeparture() {
        try {
            Thread.sleep(18000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flightTicket.selectFirstDepartureFlight();
    }

    @And("Choose return")
    public void chooseReturn() {
        flightTicket.selectFirstReturnFlight();

    }

    @And("Click flight tab")
    public void clickFlightTab() {
        flightTicket.clickFlightButton();

    }

    @And("Check the url")
    public void checkTheUrl() {
        checkCurrentUrl("https://www.obilet.com/ucak-bileti");

    }


    @And("Click find a flight ticket button")
    public void clickFindAFlightTicketButton() {
        flightTicket.clickSearchButton();
    }

    @Then("Checkout page is opened")
    public void checkoutPageIsOpened() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Satın Al - obilet.com")) {
            Assert.fail("Odeme sayfasina yonlendirilemedi");
        }

    }

    @And("Check information on the checkout page")
    public void checkInformationOnTheCheckoutPage() {
        flightTicket.checkInformation();


    }


    @And("Fill the from, departDate, to, returnDate fields on the flight searching form")
    public void fillTheFromDepartDateToReturnDateFieldsOnTheFlightSearchingForm() {
        flightTicket.selectFromDropDown();
        flightTicket.selectToDropDown();
        flightTicket.selectDepartDate();
        flightTicket.selectReturnDate();
    }
}
