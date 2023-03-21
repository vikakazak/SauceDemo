package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void buyProducts() {
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.isPageOpened();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();

    }
}
