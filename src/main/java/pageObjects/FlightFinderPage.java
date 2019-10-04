package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageLocators.FlightFinderContent;

public class FlightFinderPage {
    private WebDriver driver;
    public FlightFinderContent flightFinderContent;

    public FlightFinderPage(WebDriver webDriver) {
        driver = webDriver;
        flightFinderContent = PageFactory.initElements(driver, FlightFinderContent.class);
    }

    public void clickContinue () {
        flightFinderContent.findBtn.click();
    }
}
