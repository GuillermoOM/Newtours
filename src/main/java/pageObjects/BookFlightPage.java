package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageLocators.BookFlightContent;

public class BookFlightPage {

    private WebDriver driver;
    public BookFlightContent bookFlightContent;

    public BookFlightPage(WebDriver webDriver) {
        driver = webDriver;
        bookFlightContent = PageFactory.initElements(driver, BookFlightContent.class);
    }

    public boolean verifyBookFlight (){
        return bookFlightContent.pageTitle.getText().contains("Please review your travel");
    }

    public void inputContent (String[] content) {
        new Select(bookFlightContent.creditCard).selectByVisibleText(content[24]);
        bookFlightContent.creditNumber.sendKeys(content[25]);
        new Select(bookFlightContent.expMonth).selectByVisibleText(content[26]);
        new Select(bookFlightContent.expYear).selectByVisibleText(content[27]);
        bookFlightContent.creditFirstName.sendKeys(content[28]);
        bookFlightContent.creditLastName.sendKeys(content[29]);
        bookFlightContent.creditAddress.sendKeys(content[30]);
        bookFlightContent.creditCity.sendKeys(content[31]);
        bookFlightContent.creditState.sendKeys(content[32]);
        bookFlightContent.creditZip.sendKeys(content[33]);
        new Select(bookFlightContent.creditCountry).selectByVisibleText(content[34]);
        bookFlightContent.delAddress.sendKeys(content[35]);
        bookFlightContent.delCity.sendKeys(content[36]);
        bookFlightContent.delState.sendKeys(content[37]);
        bookFlightContent.delZip.sendKeys(content[38]);
        new Select(bookFlightContent.creditCountry).selectByVisibleText(content[39]);
    }

    public void clickContinue() {
        bookFlightContent.buyBtn.click();
    }
}
