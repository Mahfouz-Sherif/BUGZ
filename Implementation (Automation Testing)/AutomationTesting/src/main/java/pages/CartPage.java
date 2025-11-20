package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement subscriptionTxt;

    @FindBy(id="susbscribe_email")
    private WebElement subscriptionEmailTxt;

    @FindBy(id="subscribe")
    private WebElement subscriptionBtn;

    @FindBy(css = "#success-subscribe > div")
    public WebElement subscriptionSuccessMessage;

    @FindBy(css = "#footer > div.footer-bottom")
    public WebElement footer;

    // ===============================
    // 🔹 Page Actions
    // ===============================

    /**
     * Subscribes using email
     */
    public void subscribe(String email) {
        subscriptionEmailTxt.sendKeys(email);
        subscriptionBtn.submit();
    }
}
