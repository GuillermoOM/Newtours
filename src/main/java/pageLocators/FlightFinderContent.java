package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinderContent {
    @FindBy(xpath = "//input[@value = 'roundtrip']")
    public WebElement radioRoundTrip;

    @FindBy(xpath = "//input[@value = 'oneway']")
    public WebElement radioOneWay;

    @FindBy(name = "passCount")
    public WebElement passengers;

    @FindBy(name = "fromPort")
    public WebElement origin;

    @FindBy(name = "fromMonth")
    public WebElement fromMonth;

    @FindBy(name = "fromDay")
    public WebElement fromDay;

    @FindBy(name = "toPort")
    public WebElement toPort;

    @FindBy(name = "toMonth")
    public WebElement toMonth;

    @FindBy(name = "toDay")
    public WebElement toDay;

    @FindBy(xpath = "//input[@value = 'Coach']")
    public WebElement coach;

    @FindBy(xpath = "//input[@value = 'Business']")
    public WebElement business;

    @FindBy(xpath = "//input[@value = 'First']")
    public WebElement first;

    @FindBy(name = "airline")
    public WebElement airline;

    @FindBy(name = "findFlights")
    public WebElement findBtn;
}
