package ui_tests;

import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static final String BASE_URL = "https://transperfect.com";

    protected WebDriver driver = DriverManager.getDriver();
    @BeforeTest
    public void setUp() {
        driver.get(BASE_URL);
    }

    @AfterTest
    public void clearDriver() {
        driver.close();
        driver.quit();
    }
}