package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageLocators.FlightConfContent;

public class FlightConfPage {
    private WebDriver driver;
    public FlightConfContent flightConfContent;

    public FlightConfPage(WebDriver webDriver) {
        driver = webDriver;
        flightConfContent = PageFactory.initElements(driver, FlightConfContent.class);
    }

    public boolean verifyFlightConf() {
        return flightConfContent.bookedTxt.getText().contains("Your itinerary has been booked!");
    }
}
