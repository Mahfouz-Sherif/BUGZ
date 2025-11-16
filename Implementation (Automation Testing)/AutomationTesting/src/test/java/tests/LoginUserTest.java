package tests;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @Test(priority = 1)
    public void testValidLoginUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);

        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin("mahfouzsherif@gmail.com", "123456789");
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());
        loginPage.userCanDeleteAccount();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.deleteSuccessMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void testInvalidLoginUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);

        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin("mahfouzsherif015@gmail.com", "88888888");
        Assert.assertEquals(loginPage.invalidLoginMessage.getText(), "Your email or password is incorrect!");
        Assert.assertEquals(loginPage.invalidLoginMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }

    @Test(priority = 3)
    public void testLogoutUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openLoginPage();
        Thread.sleep(3000);

        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin("mahfouzsherif10@gmail.com", "123456789");
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());
        loginPage.userCanLogout();
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loginHeader.isDisplayed());
    }

}
