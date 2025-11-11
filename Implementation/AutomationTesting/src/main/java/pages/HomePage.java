package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Signup / Login")
    WebElement signUpBtn;

    @FindBy(linkText = "Home")
    public WebElement homeBtn;

    @FindBy(linkText = "Contact us")
    WebElement contactUsBtn;

    public void openRegisterPage() {
        signUpBtn.click();
    }

    public void openLoginPage() {
        signUpBtn.click();
    }

    public void openHomePage() {
        homeBtn.click();
    }

    public void openContactUsPage() {
        contactUsBtn.click();
    }

}
