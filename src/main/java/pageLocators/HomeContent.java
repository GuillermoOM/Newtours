package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeContent {
    @FindBy(name = "userName")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement signInBtn;
}
