package tests;
import pages.HomePage;
import pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @Test(priority = 1)
    public void testValidRegisterUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openRegisterPage();
        Assert.assertEquals(registerPage.newUserMessage.getText(), "New User Signup!");
        Thread.sleep(3000);

        registerPage.userCanSignUpNewUser("Mahfouz Sherif","mahfouzsherif11@gmail.com");
        Assert.assertEquals(registerPage.enterAccountMessage.getText(), "ENTER ACCOUNT INFORMATION");

        Thread.sleep(3000);

        registerPage.userCanEnterAccountInformation("123456789","15","June","1995","Mahfouz","Sherif","Example","Elsayeda","Elgize","United States","California","abcd","16798","01007751226");
        Assert.assertEquals(registerPage.successMessage.getText(), "ACCOUNT CREATED!");
        Thread.sleep(3000);

        registerPage.userCanContinue();
        Assert.assertTrue(registerPage.deleteAccountBtn.isDisplayed());

        Thread.sleep(3000);


        registerPage.deleteAccount();
        Assert.assertEquals(registerPage.deleteSuccessMessage.getText(), "ACCOUNT DELETED!");

        Thread.sleep(3000);

        registerPage.userCanContinue();
    }

    @Test(priority = 2)
    public void testInvalidRegisterUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openRegisterPage();
        Assert.assertEquals(registerPage.newUserMessage.getText(), "New User Signup!");
        Thread.sleep(3000);

        registerPage.userCanSignUpNewUser("Mahfouz Sherif","mahfouzsherif11@gmail.com");
        Assert.assertTrue(registerPage.failedMessage.isDisplayed()
                && registerPage.failedMessage.getCssValue("color").equals("rgba(255, 0, 0, 1)"));

        Thread.sleep(3000);
    }

}
