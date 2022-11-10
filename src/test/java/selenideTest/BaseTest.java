package selenideTest;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
}
