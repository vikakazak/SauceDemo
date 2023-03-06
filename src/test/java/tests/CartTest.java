package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void deleteProduct() {
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.deleteProduct("Sauce Labs Bike Light");
    }
}
