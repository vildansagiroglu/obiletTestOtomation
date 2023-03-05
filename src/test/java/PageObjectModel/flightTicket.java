package PageObjectModel;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class flightTicket extends AbstractClass {

    WebDriver driver;
    String departureFlightCompany;
    String departureFlightTime;
    String returnFlightCompany;
    String returnFlightTime;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/ul/li[2]/a")
    private WebElement flightButton;
    @FindBy(id = "origin-input")
    private WebElement fromDropDown;
    @FindBy(id = "destination-input")
    private WebElement toDropDown;
    @FindBy(xpath = "//*[@id=\"departure\"]/div/div/div[2]/div/table/tbody/tr[2]/td[1]/button")
    private WebElement selectedDepartDate;
    @FindBy(id = "departure-input")
    private WebElement departDate;
    @FindBy(xpath = "//*[@id=\"return\"]/div/div[1]/div[1]/div/table/tbody/tr[3]/td[3]/button")
    private WebElement selectedReturnDate;
    @FindBy(id = "return-input")
    private WebElement returnDate;
    @FindBy(id = "return-input-placeholder")
    private WebElement returnButton;
    @FindBy(xpath = "//*[@id=\"origin\"]/div/ul/li[1]")
    private WebElement firstItemFromDropDown;
    @FindBy(xpath = "//*[@id=\"destination\"]/div/ul/li[1]")
    private WebElement firstItemToDropDown;
    @FindBy(id = "search-button")
    private WebElement searchButton;
    @FindBy(id = "outbound-journeys")
    private WebElement departureFlightList;
    @FindBy(id = "selection")
    private WebElement selectionFlight;
    @FindBy(className = "flys")
    private WebElement flys;
    @FindBy(id = "return-journeys")
    private WebElement returnFlightList;
    @FindBy(className = "journey")
    private WebElement journeyTable;


    public flightTicket() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void checkInformation() {
        WebElement departureInformation = journeyTable.findElements(By.tagName("tbody")).get(0);
        WebElement returnInformation = journeyTable.findElements(By.tagName("tbody")).get(1);
        if (!departureInformation.findElement(By.className("partner-info")).getText().contains(departureFlightCompany)) {
            Assert.fail("Wrong company information for the departure flight");
        } else if (!departureInformation.findElement(By.className("departure")).getText().contains(departureFlightTime)) {
            Assert.fail("Wrong time for the departure flight");
        } else if (!returnInformation.findElement(By.className("partner-info")).getText().contains(returnFlightCompany)) {
            Assert.fail("Wrong company information for the return flight");
        } else if (!returnInformation.findElement(By.className("departure")).getText().contains(returnFlightTime)) {
            Assert.fail("Wrong time for the return flight");
        }
    }

    public void clickFlightButton() {
        clickFunction(flightButton);
    }

    public void selectFromDropDown() {
        obSelectDropDown(fromDropDown, "Antalya");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickFunction(firstItemFromDropDown);
    }

    public void selectToDropDown() {
        obSelectDropDown(toDropDown, "İzmir");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickFunction(firstItemToDropDown);

    }

    public void selectDepartDate() {
        clickFunction(departDate);
        clickFunction(selectedDepartDate);


    }

    public void selectReturnDate() {
        clickFunction(returnButton);
        clickFunction(selectedReturnDate);

    }

    public void selectFirstDepartureFlight() {
        selectFirstFlight(departureFlightList);
        if (!selectionFlight.getAttribute("class").contains("visible")) {
            //         flys.findElements(By.tagName("li")).get(0).click();
            selectFirstFlight(flys);
        }
        departureFlightCompany = selectionFlight.findElement(By.className("name")).getText();
        departureFlightTime = selectionFlight.findElement(By.className("departure")).getText();


    }

    public void selectFirstReturnFlight() {
        WebElement selectionReturnFlight = returnFlightList.findElements(By.tagName("li")).get(0);
        returnFlightCompany = selectionReturnFlight.findElement(By.className("name")).getText();
        returnFlightTime = selectionFlight.findElement(By.className("departure")).getText();
        selectFirstFlight(returnFlightList);
        if (!driver.getCurrentUrl().contains("www.obilet.com/ucak-bileti/odeme")) {
            selectFirstFlight(flys);
        }

    }

    public void clickSearchButton() {
        clickFunction(searchButton);
    }


}
