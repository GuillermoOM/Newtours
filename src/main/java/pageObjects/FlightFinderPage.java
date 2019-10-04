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
        if (content[3] == "oneway"){
            flightFinderContent.radioOneWay.click();
        }
        else if (content[3] == "roundtrip"){
            flightFinderContent.radioRoundTrip.click();
        }

        new Select(flightFinderContent.passengers).selectByValue(content[4]);
        new Select(flightFinderContent.origin).selectByVisibleText(content[5]);
        new Select(flightFinderContent.fromMonth).selectByValue(content[6]);
        new Select(flightFinderContent.fromDay).selectByValue(content[7]);
        new Select(flightFinderContent.toPort).selectByVisibleText(content[8]);
        new Select(flightFinderContent.toMonth).selectByValue(content[9]);
        new Select(flightFinderContent.toDay).selectByValue(content[10]);

        if (content[11] == "coach"){
            flightFinderContent.coach.click();
        }
        else if (content[11] == "first"){
            flightFinderContent.first.click();
        }
        else if (content[11] == "business"){
            flightFinderContent.business.click();
        }

        new Select(flightFinderContent.airline).selectByVisibleText(content[12]);
    }
}
