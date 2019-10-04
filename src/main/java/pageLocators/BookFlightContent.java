package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookFlightContent {
    @FindBy(name = "creditCard")
    public WebElement creditCard;

    @FindBy(name = "creditnumber")
    public WebElement creditNumber;

    @FindBy(name = "cc_exp_dt_mn")
    public WebElement expMonth;

    @FindBy(name = "cc_exp_dt_yr")
    public WebElement expYear;

    @FindBy(name = "cc_frst_name")
    public WebElement creditFirstName;

    @FindBy(name = "cc_last_name")
    public WebElement creditLastName;

    @FindBy(xpath = "//font[contains(text(), 'Ticketless Travel')]//preceding-sibling::input")
    public WebElement ticketLessCheck;

    @FindBy(name = "billAddress1")
    public WebElement creditAddress;

    @FindBy(name = "billCity")
    public WebElement creditCity;

    @FindBy(name = "billState")
    public WebElement creditState;

    @FindBy(name = "billZip")
    public WebElement creditZip;

    @FindBy(name = "billCountry")
    public WebElement creditCountry;

    @FindBy(xpath = "//font[contains(text(), 'Same as Billing Address')]//preceding-sibling::input")
    public WebElement SameAsBillingAddrCheck;

    @FindBy(name = "delAddress1")
    public WebElement delAddress;

    @FindBy(name = "delCity")
    public WebElement delCity;

    @FindBy(name = "delState")
    public WebElement delState;

    @FindBy(name = "delZip")
    public WebElement delZip;

    @FindBy(name = "delCountry")
    public WebElement delCountry;

    @FindBy(name = "buyFlights")
    public WebElement buyBtn;
}
