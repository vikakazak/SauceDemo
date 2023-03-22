package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public static final By CHECKOUT = By.id("checkout");
    String deleteProductXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item_label')]//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening cart page")
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    @Step ("Going to checkout page")
    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }

    @Step ("Deleting product from the cart")
    public void deleteProduct(String productName) {
        By removeButtonLocator = By.xpath(String.format(deleteProductXpath, productName));
        driver.findElement(removeButtonLocator).click();

    }
}
