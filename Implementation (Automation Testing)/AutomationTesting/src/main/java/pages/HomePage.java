package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
    public List<WebElement> practiceTxts;

    @FindBy(linkText = "Signup / Login")
    private WebElement signUpBtn;

    @FindBy(linkText = "Home")
    public WebElement homeBtn;

    @FindBy(linkText = "Contact us")
    private WebElement contactUsBtn;

    @FindBy(linkText = "Test Cases")
    private WebElement testCasesBtn;

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement subscriptionTxt;

    @FindBy(id ="scrollUp")
    public WebElement scrollUpBtn;

    // ===============================
    // 🔹 Page Actions
    // ===============================

    /**
     * Opens the Sign-Up / Login page.
     * Both registration and login share the same page.
     */
    public void openRegisterPage() {
        signUpBtn.click();
    }

    /**
     * Opens the Login page.
     * (Same navigation element as Sign Up.)
     */
    public void openLoginPage() {
        signUpBtn.click();
    }

    /**
     * Navigates back to the Home page.
     */
    public void openHomePage() {
        homeBtn.click();
    }

    /**
     * Opens the Contact Us page.
     */
    public void openContactUsPage() {
        contactUsBtn.click();
    }

    /**
     * Opens the Test Cases page.
     */
    public void openTestCasesPage() {
        testCasesBtn.click();
    }
}
