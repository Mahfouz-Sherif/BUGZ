package tests;

import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginUserTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    // ===================== VALID LOGIN =====================
    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {"mahfouzsherif@gmail.com", "123456789"}
        };
    }

    @Test(dataProvider = "validLoginData", priority = 1)
    public void testValidLoginUser(String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin(email, password);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        loginPage.userCanDeleteAccount();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.deleteSuccessMessage.isDisplayed());
    }

    // ===================== INVALID LOGIN =====================
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"mahfouzsherif015@gmail.com", "88888888"}
        };
    }

    @Test(dataProvider = "invalidLoginData", priority = 2)
    public void testInvalidLoginUser(String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin(email, password);
        Assert.assertEquals(loginPage.invalidLoginMessage.getText(), "Your email or password is incorrect!");
        Assert.assertEquals(loginPage.invalidLoginMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }

    // ===================== LOGOUT =====================
    @DataProvider(name = "logoutLoginData")
    public Object[][] logoutLoginData() {
        return new Object[][]{
                {"mahfouzsherif10@gmail.com", "123456789"}
        };
    }

    @Test(dataProvider = "logoutLoginData", priority = 3)
    public void testLogoutUser(String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin(email, password);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        loginPage.userCanLogout();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.loginHeader.isDisplayed());
    }
}
