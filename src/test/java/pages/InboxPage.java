package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends BasePage {
    @FindBy(css = "div.application-mail__layout_main div.layout__column_left div.sidebar__header a")
    private WebElement writeEmailButton;
    @FindBy(xpath = "//div[@data-type='to']//input")
    private WebElement toEmailInput;
    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement subjectInput;
    @FindBy(xpath = "//div[@data-signature-id]/../..")
    private WebElement emailBodyInput;
    @FindBy(xpath = "//button[@data-test-id='send']")
    private WebElement sendBtn;
    @FindBy(css = "a.layer__link")
    private WebElement sentLabel;

    public InboxPage() {
        PageFactory.initElements(webDriver, this);
    }
    public String getLabel() {
        return sentLabel.getText();
    }
    public InboxPage sendEmail(String toEmail, String subject, String bodyEmail) {
        writeEmailButton.click();

        toEmailInput.sendKeys(toEmail);
        subjectInput.sendKeys(subject);
        emailBodyInput.sendKeys(bodyEmail);
        sendBtn.click();

        return this;
    }
}
