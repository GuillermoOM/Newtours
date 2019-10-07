package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookFlightContent {
    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")
    public WebElement pageTitle;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/b/font")
    public WebElement departTrip;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/b/font")
    public WebElement departDate;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]/font/b")
    public WebElement departFlight;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/font")
    public WebElement departClass;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]/font")
    public WebElement departPrice;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/b/font")
    public WebElement returnTrip;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/b/font")
    public WebElement returnDate;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[1]/font/font/font[1]/b")
    public WebElement returnFlight;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/font")
    public WebElement returnClass;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]/font")
    public WebElement returnPrice;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/font")
    public WebElement passengerNum;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody")
    public WebElement passengersTable;

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
