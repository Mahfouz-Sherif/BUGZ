package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;


public class VerifySubscriptionInCartPageTest extends BaseTest{
    private HomePage homePage;
    private CartPage cartPage;
    @Test(priority = 1)
    public void testValidSubscriptionInCartPage() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openCartPage();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", cartPage.footer);

        Thread.sleep(3000);
        Assert.assertTrue(cartPage.subscriptionTxt.isDisplayed());

        cartPage.subscribe("mahfouzsherif15@gmail.com");

        Assert.assertTrue(cartPage.subscriptionSuccessMessage.isDisplayed() &&
                cartPage.subscriptionSuccessMessage.getText().equals("You have been successfully subscribed!"));
        Thread.sleep(2000);
    }
}
