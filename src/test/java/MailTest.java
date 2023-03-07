import base.BaseTest;
import base.ConfigProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InboxPage;
import pages.MainPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailTest extends BaseTest {
    private final String SUCCESS_MESSAGE = "Письмо отправлено";

    @Test
    public void labQualityTaskTest() {
        MainPage mainPage = new MainPage();

        InboxPage inboxPage = mainPage.loginViaEmail(ConfigProperty.properties.get("testuser.username").toString(),
                ConfigProperty.properties.get("testuser.password").toString());

        inboxPage = inboxPage.sendEmail(ConfigProperty.properties.get("email.to").toString(),
                ConfigProperty.properties.get("email.subject").toString(),
                ConfigProperty.properties.get("email.body").toString() + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));


        Assertions.assertEquals(inboxPage.getLabel(), SUCCESS_MESSAGE);
    }
}
