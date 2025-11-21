package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductTestCases extends BaseTest{
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;

    @Test
    public void VerifyAllProducts() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openProductsPage();
        Assert.assertTrue(productsPage.allProductsTxt.isDisplayed());
        for (WebElement product : productsPage.products)
        {
            Assert.assertTrue(product.isDisplayed());
        }
        Thread.sleep(3000);
        productsPage.openProductByIndex(0);
        Thread.sleep(3000);

        Assert.assertTrue(
                productDetailsPage.verifyAllProductDetailsAreDisplayed(),
                "One or more product details are missing or empty!"
        );

    }

    @Test
    public void SearchProduct() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        Thread.sleep(5000);

        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openProductsPage();
        Assert.assertTrue(productsPage.allProductsTxt.isDisplayed());
        String keyword = "Dress";
        productsPage.SearchProduct(keyword);
        Thread.sleep(3000);
        Assert.assertTrue(productsPage.searchProductTitle.getText().toLowerCase().contains("searched"));
        Thread.sleep(3000);
        for (WebElement product : productsPage.products)
        {
            Assert.assertTrue(product.isDisplayed());
        }

    }

}
