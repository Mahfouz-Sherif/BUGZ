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

    @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
    public WebElement allProductsTxt;

    @FindBy(id = "search_product")
    private WebElement searchTxt;

    @FindBy(id = "submit_search")
    private WebElement searchBtn;

    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
    public WebElement searchProductTitle;

    // All product containers
    @FindBy(css = ".single-products")
    public List<WebElement> products;


    @FindBy(css = "#cartModal .modal-body > p.text-center")
    public WebElement popupMessage;

    @FindBy(css = "#cartModal .modal-body p:nth-child(2) a")
    public WebElement viewCartLink;





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


    public void openProductByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate all product links matching the "View Product" href pattern
        List<WebElement> productLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("a[href*='/product_details/']")
        ));

        // Make sure the index exists
        if (index >= productLinks.size()) {
            throw new RuntimeException("Product index " + index + " is out of range. Only " + productLinks.size() + " products found.");
        }

        WebElement viewProductBtn = productLinks.get(index);

        // Scroll into view and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductBtn);
        wait.until(ExpectedConditions.elementToBeClickable(viewProductBtn)).click();
    }


    public void SearchProduct(String name)
    {
        searchTxt.sendKeys(name);
        searchBtn.click();
    }

    public boolean verifyAllProductTitlesContain(String word) {

        for (WebElement product : products) {

            // Find the title inside this product container
            WebElement titleElement = product.findElement(By.cssSelector(".productinfo p"));

            String title = titleElement.getText().trim().toLowerCase();

            if (!title.contains(word.toLowerCase())) {
                System.out.println("Product title does NOT contain '" + word + "': " + title);
                return false;
            }
        }

        return true; // All titles matched
    }


}
