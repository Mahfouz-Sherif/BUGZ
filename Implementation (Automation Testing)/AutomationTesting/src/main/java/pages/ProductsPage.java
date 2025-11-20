package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // All product containers
    @FindBy(css = ".single-products")
    private List<WebElement> products;

    // Add to cart buttons inside overlay
    @FindBy(css = ".single-products .product-overlay .add-to-cart, a.add-to-cart, .btn.add-to-cart")
    public List<WebElement> addToCartButtons;

    @FindBy(css = "#cartModal .modal-body > p.text-center")
    public WebElement popupMessage;

    @FindBy(css = "#cartModal .modal-body p:nth-child(2) a")
    public WebElement viewCartLink;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingBtn;


    public void addProductToCartByIndex(int index) {
        WebElement product = products.get(index);


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", product
        );


        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        closeAdIfVisible();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
                product.findElement(By.cssSelector(".product-overlay .add-to-cart"))
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);
    }




    private void closeAdIfVisible() {
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));

        for (WebElement frame : frames) {
            try {
                String title = frame.getAttribute("title");

                if (title != null && title.equalsIgnoreCase("Advertisement")) {
                    // Hide the iframe
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].style.display='none';", frame
                    );
                }

            } catch (Exception ignored) {
            }
        }
    }



    public String waitForPopupMessageText(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(popupMessage));
        return popupMessage.getText().trim();
    }

    public void clickViewCartFromPopup(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
    public void clickContinueShoppingFromPopup(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    public void waitForPopupToDisappear(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.invisibilityOf(popupMessage));
    }


}
