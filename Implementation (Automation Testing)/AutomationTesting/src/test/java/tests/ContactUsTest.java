package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import pages.HomePage;
import pages.ContactUsPage;

import java.io.File;

public class ContactUsTest extends BaseTest{
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @Test(priority = 1)
    public void testValidContactUs() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openContactUsPage();
        Thread.sleep(3000);

        Assert.assertEquals(contactUsPage.contactHeaderTxt.getText(), "Get In Touch".toUpperCase());
        File uploadFile = new File("src/test/resources/test file.txt");

        String absolutePath = uploadFile.getAbsolutePath();
        contactUsPage.userCanSubmitContactFormInfo("Mahfouz Sherif", "mahfouzsherif11@gmail.com", "Sample Subject",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Suspendisse eu vulputate enim. Donec quis mi tincidunt erat consequat sodales. " +
                "Nunc eu maximus massa. Curabitur et venenatis nisl, eu tempus ex." +
                " Morbi hendrerit augue eget libero vulputate, id facilisis ante consectetur.", absolutePath);

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);

        Assert.assertTrue(contactUsPage.successMsg.isDisplayed());
        contactUsPage.goToHomePage();
        Thread.sleep(3000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
    }
}
