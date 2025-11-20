package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class VerifyQuantityTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test(priority = 2)
    public void testVerifyProductQuantity() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        homePage.openHomePage();
        homePage.openProductsPage();

// Add first product
        productsPage.addProductToCartByIndex(0);

        productsPage.clickContinueShoppingFromPopup(10);

        productsPage.waitForPopupToDisappear(5);

// Add second product
        productsPage.addProductToCartByIndex(1);


        productsPage.clickViewCartFromPopup(10);

        int quantityFirst = cartPage.getQuantityForIndex(0);
        int quantitySecond = cartPage.getQuantityForIndex(1);

        Assert.assertEquals(quantityFirst, 1, "First product quantity mismatch.");
        Assert.assertEquals(quantitySecond, 1, "Second product quantity mismatch.");
    }

}
