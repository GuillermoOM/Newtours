package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageLocators.SelectFlightContent;

import java.util.List;

public class SelectFlightPage {
    private WebDriver driver;
    public SelectFlightContent selectFlightContent;

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

    public void getDepartFlights(String[] content) {
        List<WebElement> departs = selectFlightContent.departTable.findElements(By.tagName("tr"));
        for (WebElement i : departs){
            if (departs.indexOf(i) > 1 && departs.indexOf(i) % 2 == 0) {
                System.out.println("\n" + i.findElement(By.xpath("/td[2]/font/b")).getText());
                System.out.println("Departs: " + i.findElement(By.xpath("/td[3]/font")).getText());
                System.out.println("Stops: " + i.findElement(By.xpath("/td[4]/font")).getText());
                System.out.println(i.findElement(By.xpath("/following-sibling::tr/td/font/font/b")).getText());
            }
        }
    }

}
