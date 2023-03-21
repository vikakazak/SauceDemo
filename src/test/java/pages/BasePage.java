package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final By TITLE = By.cssSelector(".title");
    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

//    public void waitForPageLoaded() {
//        new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//    }
}
