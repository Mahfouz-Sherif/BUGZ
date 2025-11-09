package tests;
import pages.HomePage;
import pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    @Test
    public void testRegisterUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        // Navigate to Signup/Login
        homePage.clickSignupLogin();

        // Verify New User Signup section is visible
        Assert.assertTrue(registerPage.isNewUserSignupVisible(), "'New User Signup!' is not visible");

        // Fill signup info
        String name = "Mahfouz";
        String email = "mahfouz" + System.currentTimeMillis() + "@example.com"; // unique email
        registerPage.signup(name, email);

        // Verify Enter Account Information section
        Assert.assertTrue(registerPage.isEnterAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' is not visible");

        // Fill account information
        registerPage.fillAccountDetails("Password123", "10", "May", "1995");
        registerPage.selectCheckboxes();

        // Fill address details
        registerPage.fillAddressDetails(
                "Mahfouz", "Sherif", "MyCompany", "123 Street", "Suite 1", "United States",
                "Cairo", "Cairo", "12345", "0123456789"
        );

        // Create account
        registerPage.clickCreateAccount();

        // Verify account created
        Assert.assertTrue(registerPage.isAccountCreatedVisible(), "'ACCOUNT CREATED!' is not visible");

        // Continue to homepage
        registerPage.clickContinue();

        // Verify logged in
        Assert.assertTrue(registerPage.isLoggedInVisible(), "'Logged in as username' is not visible");

        // Delete account
        registerPage.clickDeleteAccount();

        // Verify account deleted
        Assert.assertTrue(registerPage.isAccountDeletedVisible(), "'ACCOUNT DELETED!' is not visible");

        registerPage.clickContinue();
    }
}
