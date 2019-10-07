package config;

import org.openqa.selenium.WebDriver;

public class Setup {
    public WebDriver driver;
    public static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
    public static String firefoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
    public static String iePath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
}
