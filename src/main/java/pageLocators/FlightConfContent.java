package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightConfContent {
    @FindBy(xpath = "//font[contains(text(), 'Your itinerary has been booked!')]")
    public WebElement bookedTxt;

    @FindBy(xpath = "//img[@src='/images/forms/home.gif']/parent::a")
    public WebElement homeBtn;
}