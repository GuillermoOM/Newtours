package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageLocators.FlightConfContent;

public class FlightConfPage {
    private WebDriver driver;
    public FlightConfContent flightConfContent;

    public FlightConfPage(WebDriver webDriver) {
        driver = webDriver;
        flightConfContent = PageFactory.initElements(driver, FlightConfContent.class);
    }

    public boolean verifyFlightConf() {
        return flightConfContent.bookedTxt.getText().contains("Your itinerary has been booked!");
    }

    public boolean verifyDepartTrip(String[] excel){
        return flightConfContent.departDetails.getText().contains(excel[4] + " to " + excel[7]);
    }

    public boolean verifyDepartDate(String[] excel){
        return flightConfContent.departDetails.getText().contains(excel[5] + "/" + excel[6]);
    }

    public boolean verifyDepartFlight(String[] content){
        return flightConfContent.departDetails.getText().contains(content[0]);
    }

    public boolean verifyDepartClass(String[] excel){
        return flightConfContent.departDetails.getText().contains(excel[10]);
    }

    public boolean verifyDepartTime(String[] content){
        return flightConfContent.departDetails.getText().contains(content[1]);
    }

    public boolean verifyDepartPrice(String[] content){
        return flightConfContent.departDetails.getText().contains(content[2]);
    }

    public boolean verifyReturnTrip(String[] excel){
        return flightConfContent.returnDetails.getText().contains(excel[7] + " to " + excel[4]);
    }

    public boolean verifyReturnDate(String[] excel){
        return flightConfContent.returnDetails.getText().contains(excel[8] + "/" + excel[9]);
    }

    public boolean verifyReturnFlight(String[] content){
        return flightConfContent.returnDetails.getText().contains(content[0]);
    }

    public boolean verifyReturnClass(String[] excel){
        return flightConfContent.returnDetails.getText().contains(excel[10]);
    }

    public boolean verifyReturnTime(String[] content){
        return flightConfContent.departDetails.getText().contains(content[1]);
    }

    public boolean verifyReturnPrice(String[] content){
        return flightConfContent.returnDetails.getText().contains(content[2]);
    }

    public boolean verifyPassengerNum(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[3]);
    }

    public boolean verifyBillingAddress(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[30]);
    }

    public boolean verifyBillingCity(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[31]);
    }

    public boolean verifyBillingState(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[32]);
    }

    public boolean verifyBillingZip(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[33]);
    }

    public boolean verifyDeliveryAddress(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[35]);
    }

    public boolean verifyDeliveryCity(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[36]);
    }

    public boolean verifyDeliveryState(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[37]);
    }

    public boolean verifyDeliveryZip(String[] excel){
        return flightConfContent.passengerNum.getText().contains(excel[38]);
    }

    public boolean verifyTotalPrice(String[] departInfo, String[] returnInfo){
        if (Integer.parseInt(flightConfContent.totalPrice.getText().replaceAll("[\\D]", "")) == (Integer.parseInt(departInfo[2]) + Integer.parseInt(returnInfo[2]) + Integer.parseInt(flightConfContent.taxes.getText().replaceAll("[\\D]", "")))) {
            return true;
        }
        else {
            return false;
        }
    }
}
