package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {
    protected static WebDriver webDriver;

    @BeforeAll
    public static void init() {
        ConfigProperty.initProperties();
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout (Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        BasePage.setWebDriver(webDriver);
    }

    @AfterEach
    public void tearDown() {
        webDriver.close();
        webDriver.quit();  // close browser
    }
}
