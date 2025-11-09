package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //=============================
    // Header Locators
    //=============================
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartLink;

    //=============================
    // Main Page Locators
    //=============================
    @FindBy(xpath = "//div[@id='slider']")
    private WebElement homepageSlider;

    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
    private WebElement homepageHeading;

    //=============================
    // Constructor
    //=============================
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //=============================
    // Actions - Verifications
    //=============================
    public boolean isHomePageVisible() {
        return homepageSlider.isDisplayed() && homepageHeading.isDisplayed();
    }

    //=============================
    // Actions - Navigation
    //=============================
    public void clickSignupLogin() {
        signupLoginLink.click();
    }

    public void clickHome() {
        homeLink.click();
    }

    public void clickProducts() {
        productsLink.click();
    }

    public void clickCart() {
        cartLink.click();
    }

    public void clickContactUs() {
        contactUsLink.click();
    }
}
