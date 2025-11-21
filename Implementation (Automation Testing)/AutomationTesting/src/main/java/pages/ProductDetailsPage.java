package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(css = "button.cart")
    private WebElement addToCartButton;

    @FindBy(css = "#cartModal .modal-body > p.text-center")
    private WebElement popupMessage;

    @FindBy(css = "#cartModal .modal-body p:nth-child(2) a")
    private WebElement viewCartLink;

    public void setQuantity(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickViewCartFromPopup(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }

}
