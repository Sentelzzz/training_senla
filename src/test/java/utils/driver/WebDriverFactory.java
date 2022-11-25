package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ParseUtil;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver() throws NullPointerException{
        WebDriver driver;
        switch (ParseUtil.settingsParser("browser")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "opera": {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            }
            case "chrome": {
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("incognito");
                try {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(ParseUtil.settingsParser("browser"));
                    //WebDriverManager.chromedriver().setup();
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                } catch (MalformedURLException ignored) {
                    driver = null;
                    System.out.println("exception");
                }

                //driver = new ChromeDriver(options);
                break;
            }
            default:
                logger.fatal("FATAL: Driver did not start!");
                throw new NullPointerException("This browser is not supported!");
        }
        return driver;
    }

}