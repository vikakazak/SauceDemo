package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkout() {
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.checkout();
        checkoutPage.checkout("Username", "Lastname", "11111");
    }
}
