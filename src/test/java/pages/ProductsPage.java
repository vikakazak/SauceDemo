package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    String addToCartXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'inventory_item')]//button";
    public static final By CART = By.id("shopping_cart_container");
    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    @Step("Adding product to cart")
    public void addToCart (String product) {
        By addToCartLocator = By.xpath(String.format(addToCartXpath, product));
        driver.findElement(addToCartLocator).click();
    };

    @Step ("Opening cart page")
    public void openCart(){
        driver.findElement(CART).click();
    }



}
