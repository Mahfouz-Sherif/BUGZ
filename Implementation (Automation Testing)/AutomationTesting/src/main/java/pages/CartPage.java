package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // Mahfouz Locators
    // ===============================

    @FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
    public WebElement subscriptionTxt;

    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailTxt;

    @FindBy(id = "subscribe")
    private WebElement subscriptionBtn;

    @FindBy(css = "#success-subscribe > div")
    public WebElement subscriptionSuccessMessage;

    @FindBy(css = "#footer > div.footer-bottom")
    public WebElement footer;


    // ===============================
    // Rahma Locators
    // ===============================

    @FindBy(css = "table#cart_info_table tbody tr")
    public List<WebElement> cartRows;

    @FindBy(css = "table#cart_info_table tbody tr td.cart_quantity button")
    public List<WebElement> quantityButtons;

    @FindBy(css = "table#cart_info_table tbody tr a > i.fa.fa-times")
    public List<WebElement> removeIcons;

    @FindBy(css = "p")
    public List<WebElement> paragraphs;


    // ===============================
    //  Mahfouz Methods
    // ===============================
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


    // ===============================
    // Rahma Methods
    // ===============================

    public boolean waitForCartRows(int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOfAllElements(cartRows));
            return !cartRows.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public int getQuantityForIndex(int index) {
        try {
            String qText = quantityButtons.get(index).getText().trim();
            return Integer.parseInt(qText);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isCartEmpty() {
        return cartRows == null || cartRows.size() == 0;
    }

    public void removeProduct(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(removeIcons.get(index)));
        removeIcons.get(index).click();

        // Wait until the row disappears from DOM
        wait.until(ExpectedConditions.stalenessOf(cartRows.get(index)));
    }
    
    public void refreshCartPage() {
        driver.navigate().refresh();
        // Re-initialize the page elements
        PageFactory.initElements(driver, this);
        // Wait for cart rows to be visible (if any)
        waitForCartRows(10);
    }
}
