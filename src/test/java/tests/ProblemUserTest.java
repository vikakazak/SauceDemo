package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProblemUserTest extends BaseTest {
    @Test(description = "Check if User can log in")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login(System.getProperty("user"),PASSWORD);
        String correctLogin = productsPage.getTitle();
        assertEquals(correctLogin, "Products","User is not logged in ");
    }
}
