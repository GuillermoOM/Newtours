package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageLocators.SelectFlightContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectFlightPage {
    private WebDriver driver;
    public SelectFlightContent selectFlightContent;
    public String[] departFlight = {"", "", ""};
    public String[] returnFlight = {"", "", ""};

    public SelectFlightPage(WebDriver webDriver) {
        driver = webDriver;
        selectFlightContent = PageFactory.initElements(driver, SelectFlightContent.class);
    }

    public boolean verifySelectFlight() {
        return selectFlightContent.pageTitle.getText().contains("Select your departure");
    }

    public boolean verifyDepartTrip(String[] content) {
        return selectFlightContent.departTrip.getText().contains(content[4] + " to " + content[7]);
    }

    public boolean verifyDepartDate(String[] content) {
        return selectFlightContent.departDate.getText().contains(content[5] + "/" + content[6]);
    }

    public boolean verifyReturnTrip(String[] content) {
        return selectFlightContent.returnTrip.getText().contains(content[7] + " to " + content[4]);
    }

    public boolean verifyReturnDate(String[] content) {
        return selectFlightContent.returnDate.getText().contains(content[8] + "/" + content[9]);
    }

    public void getDepartFlights(String[] content) {
        List<Integer> prices = new ArrayList<Integer>();
        List<WebElement> departs = selectFlightContent.departTable.findElements(By.xpath("./tr"));
        System.out.println("\nDEPART FLIGHTS");
        for (WebElement i : departs){
            if (departs.indexOf(i) > 1 && departs.indexOf(i) % 2 == 0) {
                System.out.println("\n" + i.findElement(By.xpath(".//td[2]//font//b")).getText());
                System.out.println("Departs: " + i.findElement(By.xpath(".//td[3]//font")).getText());
                System.out.println("Stops: " + i.findElement(By.xpath(".//td[4]//font")).getText());
                int price = Integer.parseInt(i.findElement(By.xpath(".//following-sibling::tr//td//font//font//b")).getText().replaceAll("[\\D]", ""));
                System.out.println("Price: $"+price);
                prices.add(price);
            }
        }
        Collections.sort(prices);
        selectFlightContent.departTable.findElement(By.xpath("./*[contains(., '"+prices.get(0).toString()+"')]/preceding-sibling::tr[1]/td[1]/input")).click();
        //Flight
        departFlight[0] = selectFlightContent.departTable.findElement(By.xpath("./*[contains(., '"+prices.get(0).toString()+"')]/preceding-sibling::tr[1]/td[2]/font/b")).getText();
        //Time
        departFlight[1] = selectFlightContent.departTable.findElement(By.xpath("./*[contains(., '"+prices.get(0).toString()+"')]/preceding-sibling::tr[1]/td[3]/font")).getText();
        //Price
        departFlight[2] = prices.get(0).toString();
    }

    public void getReturnFlights(String[] content) {
        List<Integer> prices = new ArrayList<Integer>();
        List<WebElement> departs = selectFlightContent.returnTable.findElements(By.xpath("./tr"));
        System.out.println("\nRETURN FLIGHTS");
        for (WebElement i : departs){
            if (departs.indexOf(i) > 1 && departs.indexOf(i) % 2 == 0) {
                System.out.println("\n" + i.findElement(By.xpath(".//td[2]//font//b")).getText());
                System.out.println("Departs: " + i.findElement(By.xpath(".//td[3]//font")).getText());
                System.out.println("Stops: " + i.findElement(By.xpath(".//td[4]//font")).getText());
                int price = Integer.parseInt(i.findElement(By.xpath(".//following-sibling::tr//td//font//font//b")).getText().replaceAll("[\\D]", ""));
                System.out.println("Price: $"+price);
                prices.add(price);
            }
        }
        Collections.sort(prices);
        selectFlightContent.returnTable.findElement(By.xpath("./*[contains(., '"+prices.get(prices.size()-2).toString()+"')]/preceding-sibling::tr[1]/td[1]/input")).click();
        //Flight
        returnFlight[0] = selectFlightContent.returnTable.findElement(By.xpath("./*[contains(., '"+prices.get(0).toString()+"')]/preceding-sibling::tr[1]/td[2]/font/b")).getText();
        //Time
        returnFlight[1] = selectFlightContent.returnTable.findElement(By.xpath("./*[contains(., '"+prices.get(0).toString()+"')]/preceding-sibling::tr[1]/td[3]/font")).getText();
        //Price
        returnFlight[2] = prices.get(0).toString();
    }

    public void clickContinue() {
        selectFlightContent.reserveBtn.click();
    }
}

