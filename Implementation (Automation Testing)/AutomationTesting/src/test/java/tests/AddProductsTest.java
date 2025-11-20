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
        // init pages
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        //  we are on home page

        homePage.openProductsPage();

        // Choose which product index to add
        int productIndex = 0;


        productsPage.addProductToCartByIndex(productIndex);


        String popupText = productsPage.waitForPopupMessageText(10);
        Assert.assertTrue(popupText.contains("Your product has been added to cart"),
                "Popup text mismatch. Actual: " + popupText);


        productsPage.clickViewCartFromPopup(10);


        boolean hasRows = cartPage.waitForCartRows(10);
        Assert.assertTrue(hasRows, "Cart page does not show any product rows after adding.");

        int quantity = cartPage.getQuantityForIndex(0);
        Assert.assertEquals(quantity, 1, "Expected quantity 1 for added product.");
    }
}
