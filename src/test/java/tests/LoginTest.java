package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        String correctLogin = productsPage.getTitle();
        assertEquals(correctLogin, "Products","User is not logged in ");
    }

    @Test
    public void usernameIsRequired() {
        loginPage.open();
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username is required",
                "Incorrect error-message is shown");
    }
}
