package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    public void inputContent (String[] content) {
        if (content[2].equalsIgnoreCase("oneway")){
            flightFinderContent.radioOneWay.click();
        }
        else if (content[2].equalsIgnoreCase("roundtrip")){
            flightFinderContent.radioRoundTrip.click();
        }

        new Select(flightFinderContent.passengers).selectByValue(content[3]);
        new Select(flightFinderContent.origin).selectByVisibleText(content[4]);
        new Select(flightFinderContent.fromMonth).selectByValue(content[5]);
        new Select(flightFinderContent.fromDay).selectByValue(content[6]);
        new Select(flightFinderContent.toPort).selectByVisibleText(content[7]);
        new Select(flightFinderContent.toMonth).selectByValue(content[8]);
        new Select(flightFinderContent.toDay).selectByValue(content[9]);

        if (content[10].equalsIgnoreCase("coach")){
            flightFinderContent.coach.click();
        }
        else if (content[10].equalsIgnoreCase("first")){
            flightFinderContent.first.click();
        }
        else if (content[10].equalsIgnoreCase("business")){
            flightFinderContent.business.click();
        }

        new Select(flightFinderContent.airline).selectByVisibleText(content[11]);
    }
}
