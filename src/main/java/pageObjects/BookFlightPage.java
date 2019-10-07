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

    public boolean verifyDepartTrip(String[] excel){
        return bookFlightContent.departTrip.getText().contains(excel[4] + " to " + excel[7]);
    }

    public boolean verifyDepartDate(String[] excel){
        return bookFlightContent.departDate.getText().contains(excel[5] + "/" + excel[6]);
    }

    public boolean verifyDepartFlight(String[] content){
        return bookFlightContent.departFlight.getText().contains(content[0]);
    }

    public boolean verifyDepartClass(String[] excel){
        return bookFlightContent.departClass.getText().equalsIgnoreCase(excel[10]);
    }

    public boolean verifyDepartPrice(String[] content){
        return bookFlightContent.departPrice.getText().contains(content[2]);
    }

    public boolean verifyReturnTrip(String[] excel){
        return bookFlightContent.returnTrip.getText().contains(excel[7] + " to " + excel[4]);
    }

    public boolean verifyReturnDate(String[] excel){
        return bookFlightContent.returnDate.getText().contains(excel[8] + "/" + excel[9]);
    }

    public boolean verifyReturnFlight(String[] content){
        return bookFlightContent.returnFlight.getText().contains(content[0]);
    }

    public boolean verifyReturnClass(String[] excel){
        return bookFlightContent.returnClass.getText().equalsIgnoreCase(excel[10]);
    }

    public boolean verifyReturnPrice(String[] content){
        return bookFlightContent.returnPrice.getText().contains(content[2]);
    }

    public boolean verifyPassengerNum(String[] excel){
        return bookFlightContent.passengerNum.getText().contains(excel[3]);
    }

    public void clickContinue() {
        bookFlightContent.buyBtn.click();
    }
}
