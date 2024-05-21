package ui_tests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.awt.SystemColor.window;
import static org.testng.AssertJUnit.assertEquals;

public class SiteTest extends BaseTest {
// constants
    private static final By COOKIES = By.xpath("//div[@class='cookiesjsr--app']/div[contains(@class, 'cookiesjsr-banner')]");
    private static final By ACCEPT = By.xpath("//button[@class='cookiesjsr-btn important']");
    private static final By INDUSTRIES = By.xpath("//li[contains(@class, 'we-mega-menu-li')]/a[@href='/industries' and @class='we-mega-menu-li']");
    private static final By RETAIL_AND_COMMERCE = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/main/section/div/article/div/div/section[1]/div/div/div/div[2]/section/div/div[3]/a");
    private static final By FOOTER = By.xpath("/html/body/div[2]/div/footer");
    private static final By SEARCH = By.xpath("/html/body/div[2]/div/header/nav/div/nav/div/div[2]/div[1]/div/span");
    private static final By SEARCH_FIELD = By.xpath("/html/body/div[2]/div/header/nav/div/nav/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[1]/form/div/fieldset/input");
    private static final By REQUEST_QUOTE = By.xpath("/html/body/div[2]/div/header/nav/div/nav/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/span/a");

    @Test(priority = 1)
    public void checkLoadStartPage() throws InterruptedException {
        assertEquals("Language & Technology Solutions for Business | TransPerfect", driver.getTitle());
    }

    @Test(priority = 2)
    public void checkClosePopup() {
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // Wait until the element is visible
        new WebDriverWait(driver, 5)
                .until(driver -> (driver.findElement(COOKIES).isDisplayed()));
        // If element is found, click on it
        if (driver.findElement(ACCEPT) != null) {
            driver.findElement(ACCEPT).click();
        }
        new WebDriverWait(driver, 5);
    }

    @Test(priority = 3)
    public void clickOnIndustries() throws InterruptedException {
        new WebDriverWait(driver, 5)
                .until(driver -> (driver.findElement(INDUSTRIES).isDisplayed()));
        if (driver.findElement(INDUSTRIES) != null) {
            driver.findElement(INDUSTRIES).click();
            Thread.sleep(5000);
        }
    }

    @Test(priority = 4)
    public void clickOnRetailAndCommerce() {
        driver.get("https://www.transperfect.com/industries");
        WebElement retail = driver.findElement(RETAIL_AND_COMMERCE);
            retail.click();
            new WebDriverWait(driver, 5)
                    .until(driver -> (driver.findElement(FOOTER).isDisplayed()));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test(priority = 5)
    public void clickSearchEngineTranslation() throws InterruptedException {
        new WebDriverWait(driver, 5)
                .until(driver -> (driver.findElement(SEARCH).isDisplayed()));
            driver.findElement(SEARCH).click();
        driver.findElement(SEARCH_FIELD).sendKeys("translation");
        //Thread.sleep(3000);
        driver.findElement(SEARCH_FIELD).clear();
        Thread.sleep(5000);
    }

    private void clickQuote() {
        new WebDriverWait(driver, 5)
                .until(driver -> (driver.findElement(SEARCH).isDisplayed()));
        driver.findElement(SEARCH).click();
        WebElement element = driver.findElement(SEARCH_FIELD);
        element.sendKeys("quote", Keys.ENTER);
    }

    @Test(priority = 6)
    public void clickSearchEngineQuote() throws InterruptedException {
        clickQuote();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void clickOnRequestQuote() throws InterruptedException {
        clickQuote();
        driver.findElement(REQUEST_QUOTE).click();
        Thread.sleep(3000);
    }
}