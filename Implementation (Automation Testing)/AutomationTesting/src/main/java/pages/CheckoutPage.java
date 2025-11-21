package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]/h2")
    public WebElement addressDetailsTxt;

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[4]/h2")
    public WebElement ReviewOrderTxt;

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    public WebElement commentTextArea;

    @FindBy(linkText = "Place Order")
    public WebElement placeOrderBtn;

    @FindBy(
            name = "name_on_card"
    )
    WebElement cardName;
    @FindBy(
            name = "card_number"
    )
    WebElement cardNumber;
    @FindBy(
            name = "cvc"
    )
    WebElement cardCVC;
    @FindBy(
            name = "expiry_month"
    )
    WebElement cardMonth;
    @FindBy(
            name = "expiry_year"
    )
    WebElement cardYear;
    @FindBy(
            id = "submit"
    )
    WebElement payBtn;
    @FindBy(
            xpath = "//*[@id=\"form\"]/div/div/div/a"
    )

    public WebElement downloadInvoiceLink;
    @FindBy(
            css = "#address_delivery > li:nth-child(4)"
    )
    public WebElement deliveryAddress;
    @FindBy(
            css = "#address_invoice > li:nth-child(4)"
    )
    public WebElement billingAddress;
    @FindBy(
            xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"
    )
    public WebElement logoutBtn;

    @FindBy(
            xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[1]"
    )
    public WebElement successMsg;
    @FindBy(
            xpath = "//*[@id=\"form\"]/div/div/div/h2/b"
    )
    public WebElement orderSuccessMsg;



    // ===============================
    // 🔹 Page Actions
    // ===============================


    public void enterPaymentDetails(String cardHolder, String number, String cvc, String month, String year) {
        this.cardName.sendKeys(cardHolder);
        this.cardNumber.sendKeys(number);
        this.cardCVC.sendKeys(cvc);
        this.cardMonth.sendKeys(month);
        this.cardYear.sendKeys(year);
        this.payBtn.click();
    }

    public void downloadInvoice() {
        this.downloadInvoiceLink.click();
    }
}
