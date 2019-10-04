package pageObjects;

import pageLocators.HomeContent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
    }
}
