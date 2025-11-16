package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2")
    public WebElement loginHeader;

    @FindBy(name="email")
    private List<WebElement> emailsTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(css="#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement loggedInMessage;

    @FindBy(linkText = "Delete Account")
    public WebElement deleteAccountBtn;

    @FindBy(xpath="//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement deleteSuccessMessage;

    @FindBy(css="#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p")
    public WebElement invalidLoginMessage;

    @FindBy(linkText = "Logout")
    public WebElement logoutBtn;



    // ===============================
    // 🔹 Page Actions
    // ===============================
    public void userCanLogin(String email,String password) {
        emailsTxt.get(0).sendKeys(email);
        passwordTxt.sendKeys(password);

        loginBtn.click();
    }

    public void userCanDeleteAccount() {
        deleteAccountBtn.click();
    }

    public void userCanLogout()
    {
        logoutBtn.click();
    }
}
