package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.AllureUtils;
import utils.PropertyReader;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    @Test(description = "Check if User can log in", retryAnalyzer = Retry.class)
    public void successfulLogin() {
        loginPage.open();
        loginPage.login(USER,PASSWORD);
        String correctLogin = productsPage.getTitle();
        assertEquals(correctLogin, "Products","User is not logged in ");
    }
    @Test
    public void successfulLoginUsingSecrets() {
        loginPage.open();
        String user = System.getProperty("user", PropertyReader.getProperty("user"));
        String password = System.getProperty("password", PropertyReader.getProperty("user"));
        loginPage.login(user,password);
        String correctLogin = productsPage.getTitle();
        assertEquals(correctLogin, "Products","User is not logged in ");
    }

    @DataProvider(name = "Входящие данные для негативные тесты на логин")
    public Object[][] getDataForLogin() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"test", "", "Epic sadface: Password is required"},
        };
    }

    @Test (description = "Negative login", dataProvider = "Входящие данные для негативные тесты на логин")
    public void negativeLogin(String username, String password, String expectedError) {
        loginPage.open();
        loginPage.login(username, password);
        String error = loginPage.getErrorMessage();
        assertEquals(error, expectedError,
                "Incorrect error-message is shown");
    }

}
