package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    // Navigation Links
    @FindBy(linkText = "Signup / Login")
    WebElement signUpBtn;

    @FindBy(linkText = "Home")
    public WebElement homeBtn;

    @FindBy(linkText = "Contact us")
    WebElement contactUsBtn;

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
}
