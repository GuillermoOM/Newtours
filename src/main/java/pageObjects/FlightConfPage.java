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
        System.out.println("\n"+flightConfContent.departDetails.getText());
        return flightConfContent.departDetails.getText().contains(excel[4] + " to " + excel[7]);
    }

    public boolean verifyDepartDate(String[] excel){
        return flightConfContent.departDetails.getText().contains(excel[5] + "/" + excel[6]);
    }

    public boolean verifyDepartFlight(String[] content){
        return flightConfContent.departDetails.getText().contains(content[0]);
    }

    public boolean verifyDepartClass(String[] excel){
        return flightConfContent.departDetails.getText().contains(excel[10].substring(0, 1).toUpperCase() + excel[10].substring(1));
    }

    public boolean verifyDepartTime(String[] content){
        return flightConfContent.departDetails.getText().contains(content[1]);
    }

    public boolean verifyDepartPrice(String[] content){
        return flightConfContent.departDetails.getText().contains(content[2]);
    }

    public boolean verifyReturnTrip(String[] excel){
        System.out.println("\n"+flightConfContent.returnDetails.getText());
        return flightConfContent.returnDetails.getText().contains(excel[7] + " to " + excel[4]);
    }

    public boolean verifyReturnDate(String[] excel){
        return flightConfContent.returnDetails.getText().contains(excel[8] + "/" + excel[9]);
    }

    public boolean verifyReturnFlight(String[] content){
        return flightConfContent.returnDetails.getText().contains(content[0]);
    }

    public boolean verifyReturnClass(String[] excel){
        return flightConfContent.returnDetails.getText().contains(excel[10].substring(0, 1).toUpperCase() + excel[10].substring(1));
    }

    public boolean verifyReturnTime(String[] content){
        return flightConfContent.returnDetails.getText().contains(content[1]);
    }

    public boolean verifyReturnPrice(String[] content){
        return flightConfContent.returnDetails.getText().contains(content[2]);
    }

    public boolean verifyPassengerNum(String[] excel){
        System.out.println("\n"+flightConfContent.passengerNum.getText());
        return flightConfContent.passengerNum.getText().contains(excel[3]);
    }

    public boolean verifyBillingAddress(String[] excel){
        System.out.println("\n"+flightConfContent.billingInfo.getText());
        return flightConfContent.billingInfo.getText().contains(excel[30]);
    }

    public boolean verifyBillingCity(String[] excel){
        return flightConfContent.billingInfo.getText().contains(excel[31]);
    }

    public boolean verifyBillingState(String[] excel){
        return flightConfContent.billingInfo.getText().contains(excel[32]);
    }

    public boolean verifyBillingZip(String[] excel){
        return flightConfContent.billingInfo.getText().contains(excel[33]);
    }

    public boolean verifyDeliveryAddress(String[] excel){
        System.out.println("\n"+flightConfContent.deliveryInfo.getText());
        return flightConfContent.deliveryInfo.getText().contains(excel[35]);
    }

    public boolean verifyDeliveryCity(String[] excel){
        return flightConfContent.deliveryInfo.getText().contains(excel[36]);
    }

    public boolean verifyDeliveryState(String[] excel){
        return flightConfContent.deliveryInfo.getText().contains(excel[37]);
    }

    public boolean verifyDeliveryZip(String[] excel){
        return flightConfContent.deliveryInfo.getText().contains(excel[38]);
    }

    public boolean verifyTotalCost(String[] departInfo, String[] returnInfo, String[] excel){
        int calculatedCost = (Integer.parseInt(departInfo[2]) + Integer.parseInt(returnInfo[2])) * Integer.parseInt(excel[3]) + Integer.parseInt(flightConfContent.taxes.getText().replaceAll("[\\D]", ""));
        int actualCost = Integer.parseInt(flightConfContent.totalPrice.getText().replaceAll("[\\D]", ""));
        System.out.println("\nCalculado: " + calculatedCost);
        System.out.println("\nActual: " + actualCost);
        if (actualCost == calculatedCost) {
            return true;
        }
        else {
            return false;
        }
    }
}
