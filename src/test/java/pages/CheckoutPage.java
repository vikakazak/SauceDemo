package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By FIRSTNAME_INPUT = By.id("first-name");
    public static final By LASTNAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    @Step("Adding user's information on Checkout page")
    public void checkout (String firstName, String lastName, String zipCode) {
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
