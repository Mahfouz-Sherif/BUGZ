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

    @FindBy(css = ".product-information h2")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class='product-information']//p[contains(text(),'Category')]")
    private WebElement productCategory;

    @FindBy(xpath = "//div[@class='product-information']//span/span")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='product-information']//p[b[text()='Availability:']]")
    private WebElement availabilityStatus;

    @FindBy(xpath = "//div[@class='product-information']//p[b[text()='Condition:']]")
    private WebElement productCondition;

    @FindBy(xpath = "//div[@class='product-information']//p[b[text()='Brand:']]")
    private WebElement productBrand;


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


    public boolean verifyAllProductDetailsAreDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(productTitle));

        boolean titleOk = productTitle.isDisplayed();

        boolean categoryOk = productCategory.isDisplayed();

        boolean priceOk = productPrice.isDisplayed();

        boolean availabilityOk = availabilityStatus.isDisplayed();

        boolean conditionOk = productCondition.isDisplayed();

        boolean brandOk = productBrand.isDisplayed();

        return titleOk &&
                categoryOk &&
                priceOk &&
                availabilityOk &&
                conditionOk &&
                brandOk;
    }

}
