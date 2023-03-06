package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public static final By CHECKOUT = By.id("checkout");
    String deleteProductXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item_label')]//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }

    public void deleteProduct(String productName) {
        By removeButtonLocator = By.xpath(String.format(deleteProductXpath, productName));
        driver.findElement(removeButtonLocator).click();

    }
}
