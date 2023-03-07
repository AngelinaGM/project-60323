package pages;

import base.BasePage;
import base.ConfigProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement loginButton;
    private final By loginFormIframe = By.cssSelector("iframe.ag-popup__frame__layout__iframe");
    private final By loginForm = By.xpath("//div[@data-test-id='login-app-ready']");
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement nextButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@data-test-id='login-app-ready']//button[@data-test-id='submit-button']")
    private WebElement loginButtonOnForm;
    @FindBy(xpath = "//a[@data-test-id='auth-problems']")
    private WebElement cantLoginButton;
    @FindBy(xpath = "//*[@data-test-id='auth-by-password']//a")
    private WebElement loginWithPassword;
    public MainPage() {
        webDriver.get(ConfigProperty.properties.get("url").toString());
        PageFactory.initElements(webDriver, this);
    }
    public InboxPage loginViaEmail(String username, String password) {
        this.loginButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        WebElement iframe = webDriver.findElement(loginFormIframe);
        webDriver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(loginForm)));

        this.usernameInput.sendKeys(username);
        this.nextButton.click();
        this.passwordInput.sendKeys(password);
        this.loginButtonOnForm.click();
        webDriver.switchTo().defaultContent();

        return new InboxPage();
    }
}
