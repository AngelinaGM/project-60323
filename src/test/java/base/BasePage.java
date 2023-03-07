package base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver webDriver;

    public static void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }
}
