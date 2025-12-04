package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(linkText = "Cart")
    private WebElement cartBtn;

    @FindBy(linkText = "Contact us")
    private WebElement contactUsBtn;

    @FindBy(linkText = "Test Cases")
    private WebElement testCasesBtn;

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement subscriptionTxt;

    @FindBy(id="susbscribe_email")
    private WebElement subscriptionEmailTxt;

    @FindBy(id="subscribe")
    private WebElement subscriptionBtn;

    @FindBy(css = "#success-subscribe > div")
    public WebElement subscriptionSuccessMessage;

    @FindBy(id ="scrollUp")
    public WebElement scrollUpBtn;
    
    @FindBy(css = "a[href='/products']")
    private WebElement productsLink;

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
     * Opens the Cart page.
     */
    public void openCartPage() {
        cartBtn.click();
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

    /**
     * Subscribes using email
     */
    public void subscribe(String email) {
        subscriptionEmailTxt.sendKeys(email);
        subscriptionBtn.submit();
    }
    
    public ProductsPage openProductsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
        return new ProductsPage(driver);
    }
   

}
