package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class ScrollingTest extends BaseTest{
    private HomePage homePage;

    @Test(priority = 1)
    public void ScrollUpUsingArrow() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        Assert.assertTrue(homePage.subscriptionTxt.isDisplayed());

        homePage.scrollUpBtn.click();
        Thread.sleep(3000);
        boolean found = false;
        System.out.println(homePage.practiceTxts.size());
        for(WebElement element : homePage.practiceTxts) {
            if (element.isDisplayed()) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }

    @Test(priority = 2)
    public void ScrollUpWithoutUsingArrow() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        Assert.assertTrue(homePage.subscriptionTxt.isDisplayed());

        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        Thread.sleep(3000);
        boolean found = false;
        System.out.println(homePage.practiceTxts.size());
        for(WebElement element : homePage.practiceTxts) {
            if (element.isDisplayed()) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }
}
