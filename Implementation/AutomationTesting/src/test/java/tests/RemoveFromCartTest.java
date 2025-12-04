package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class RemoveFromCartTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Test(priority = 3)
    public void testRemoveProductFromCart() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        homePage.openHomePage();
        Thread.sleep(2000);

        homePage.openProductsPage();
        Thread.sleep(2000);

        int productIndex = 0;
        productsPage.addProductToCartByIndex(productIndex);
        Thread.sleep(2000);

        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(2000);

        cartPage.removeProduct(0);
        Thread.sleep(3000);

        Assert.assertEquals(cartPage.cartRows.size(), 0);
    }
}
