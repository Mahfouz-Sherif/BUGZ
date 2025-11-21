package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class VerifyQuantityTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @Test(priority = 2)
    public void testVerifyProductQuantityFromDetails() {
   
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);

        homePage.openHomePage();
        productsPage = homePage.openProductsPage();

        productsPage.openProductByIndex(0);

        // Set quantity to 4
        productDetailsPage.setQuantity(4);
        productDetailsPage.clickAddToCart();
        productDetailsPage.clickViewCartFromPopup(10);
        boolean rowsExist = cartPage.waitForCartRows(10);
        Assert.assertTrue(rowsExist, "Cart page is empty after adding product.");

        int quantityInCart = cartPage.getQuantityForIndex(0);
        Assert.assertEquals(quantityInCart, 4, "Product quantity in cart does not match the quantity added from product details page.");
    }
}
