package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class VerifySubscriptionInHomePageTest extends BaseTest{
    private HomePage homePage;

    @Test(priority = 1)
    public void testValidSubscriptionInHomePage() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        Assert.assertTrue(homePage.subscriptionTxt.isDisplayed());

        homePage.subscribe("mahfouzsherif15@gmail.com");

        Assert.assertTrue(homePage.subscriptionSuccessMessage.isDisplayed() &&
                homePage.subscriptionSuccessMessage.getText().equals("You have been successfully subscribed!"));
        Thread.sleep(2000);
    }
}
