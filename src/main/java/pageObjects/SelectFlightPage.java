package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageLocators.SelectFlightContent;

public class SelectFlightPage {
    private WebDriver driver;
    public SelectFlightContent selectFlightContent;

    public SelectFlightPage(WebDriver webDriver) {
        driver = webDriver;
        selectFlightContent = PageFactory.initElements(driver, SelectFlightContent.class);
    }

    public boolean verifySelectFlight() {
        return selectFlightContent.pageTitle.equals("Select a Flight: Mercury Tours");
    }

    public boolean verifyDepartTrip(String[] content) {
        return selectFlightContent.departTrip.getText().contains(content[4] + " to " + content[7]);
    }

    public boolean verifyDepartDate(String[] content) {
        return selectFlightContent.departDate.getText().contains(content[5] + "/" + content[6]);
    }

}
