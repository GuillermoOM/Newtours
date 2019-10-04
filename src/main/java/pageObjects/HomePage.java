package pageObjects;

import pageLocators.HomeContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    public HomeContent homeContent;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
        homeContent = PageFactory.initElements(driver, HomeContent.class);
    }

    public void SignIn(String userName, String password) {
        homeContent.userName.sendKeys(userName);
        homeContent.password.sendKeys(password);
        homeContent.signInBtn.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
