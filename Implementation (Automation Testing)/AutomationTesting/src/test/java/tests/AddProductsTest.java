package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductsTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test(priority = 1)
    public void TC12_addProductAndVerifyInCart() {
        
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        // Navigate to products page and add product
        homePage.openProductsPage();
        int productIndex = 0;
        productsPage.addProductToCartByIndex(productIndex);

        
        String popupText = productsPage.waitForPopupMessageText(10);
        Assert.assertTrue(popupText.contains("Your product has been added to cart"),
                "Popup text mismatch. Actual: " + popupText);

        productsPage.clickViewCartFromPopup(10);

        Assert.assertTrue(cartPage.waitForCartRows(10), "Cart page does not show any product rows.");
        Assert.assertEquals(cartPage.getQuantityForIndex(0), 1, "Expected quantity 1 for added product.");

        // ===== Reload page, wait, and check again =====
        driver.navigate().refresh();

        // ===== Reload page, wait, and check again =====
        cartPage.refreshCartPage();
        Assert.assertTrue(cartPage.waitForCartRows(10), "Cart page is empty after reload.");
        Assert.assertEquals(cartPage.getQuantityForIndex(0), 1, "Expected quantity 1 after page reload.");
    }
}
