package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

import java.util.Objects;

public class TestCasesVerificationTest extends BaseTest{
    private HomePage homePage;
    private TestCasesPage testCasesPage;

    @Test(priority = 1)
    public void testValidLoginUser() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        testCasesPage = new TestCasesPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openTestCasesPage();
        Thread.sleep(3000);

        Assert.assertTrue(testCasesPage.testCasesHeader.isDisplayed() &&
                Objects.equals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases"));
    }
}
