package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageLocators.BookFlightContent;

import java.util.List;

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

    public void inputContent (String[] excel) {
        List<WebElement> passengerTable = bookFlightContent.passengersTable.findElements(By.xpath("./tr"));
        System.out.println("\nPASAJEROS:");
        for (WebElement i : passengerTable){
            if (passengerTable.indexOf(i) > 2 && passengerTable.indexOf(i) - 2 <= Integer.parseInt(excel[3])) {
                System.out.println("Nombre Pasajero " + (passengerTable.indexOf(i) - 2) + ":");
                i.findElement(By.xpath("./td/table/tbody/tr[2]/td[1]/input")).sendKeys(excel[12 + (passengerTable.indexOf(i) - 3)*3]);
                System.out.print(excel[12 + (passengerTable.indexOf(i) - 3)*3]+" ");
                i.findElement(By.xpath("./td/table/tbody/tr[2]/td[2]/input")).sendKeys(excel[13 + (passengerTable.indexOf(i) - 3)*3]);
                System.out.print(excel[13 + (passengerTable.indexOf(i) - 3)*3]+" ");
                new Select(i.findElement(By.xpath("./td/table/tbody/tr[2]/td[3]/select"))).selectByVisibleText(excel[14 + (passengerTable.indexOf(i) - 3)*3]);
                System.out.println("Comida: " + excel[14 + (passengerTable.indexOf(i) - 3)*3]);
            }
        }
        System.out.println("\nTARJETA DE CREDITO:");
        new Select(bookFlightContent.creditCard).selectByVisibleText(excel[24]);
        System.out.println("Compañia: "+excel[24]);
        bookFlightContent.creditNumber.sendKeys(excel[25]);
        System.out.println("Numero: "+excel[25]);
        if (Integer.parseInt(excel[26]) < 10) {
            new Select(bookFlightContent.expMonth).selectByVisibleText("0"+excel[26]);
            System.out.println("Mes Expiracion: "+"0"+excel[26]);
        }
        else {
            new Select(bookFlightContent.expMonth).selectByVisibleText(excel[26]);
            System.out.println("Mes Expiracion: "+excel[26]);
        }
        new Select(bookFlightContent.expYear).selectByVisibleText(excel[27]);
        System.out.println("Año Expiracion: "+excel[27]);
        bookFlightContent.creditFirstName.sendKeys(excel[28]);
        System.out.println("Nombre del Titular: " + excel[28] + " " + excel[29]);
        bookFlightContent.creditLastName.sendKeys(excel[29]);
        //Billing
        System.out.println("\nBILLING:");
        bookFlightContent.creditAddress.clear();
        bookFlightContent.creditAddress.sendKeys(excel[30]);
        System.out.println("Direccion: " + excel[30]);
        bookFlightContent.creditCity.clear();
        bookFlightContent.creditCity.sendKeys(excel[31]);
        System.out.println("Ciudad: " + excel[31]);
        bookFlightContent.creditState.clear();
        bookFlightContent.creditState.sendKeys(excel[32]);
        System.out.println("Estado: " + excel[32]);
        bookFlightContent.creditZip.clear();
        bookFlightContent.creditZip.sendKeys(excel[33]);
        System.out.println("Codigo Postal: " + excel[33]);
        new Select(bookFlightContent.creditCountry).selectByVisibleText(excel[34]);
        System.out.println("Pais: " + excel[34]);
        //Delivery
        System.out.println("\nEnvio:");
        bookFlightContent.delAddress.clear();
        bookFlightContent.delAddress.sendKeys(excel[35]);
        System.out.println("Direccion: " + excel[35]);
        bookFlightContent.delCity.clear();
        bookFlightContent.delCity.sendKeys(excel[36]);
        System.out.println("Ciudad: " + excel[36]);
        bookFlightContent.delState.clear();
        bookFlightContent.delState.sendKeys(excel[37]);
        System.out.println("Estado: " + excel[37]);
        bookFlightContent.delZip.clear();
        bookFlightContent.delZip.sendKeys(excel[38]);
        System.out.println("Codigo Postal: " + excel[38]);
        new Select(bookFlightContent.creditCountry).selectByVisibleText(excel[39]);
        System.out.println("Pais: " + excel[39]);
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
