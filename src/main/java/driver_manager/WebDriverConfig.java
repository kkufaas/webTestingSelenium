package driver_manager;

import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

    public static ChromeOptions configChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return chromeOptions;
    }
}