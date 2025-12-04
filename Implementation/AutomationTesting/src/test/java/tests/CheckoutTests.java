package tests;

import io.cucumber.java.bs.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Objects;

public class CheckoutTests extends BaseTest{

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;


    @Test(
            priority = 2
    )
    public void placeOrderRegisterBeforeCheckout() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
        homePage.openRegisterPage();
        Thread.sleep(3000L);

        registerPage.userCanSignUpNewUser("Hagar", "hagar32@364123.com");
        registerPage.userCanEnterAccountInformation("ezay", "15","June","1995", "hello_world", "Tomas", "lawyer", "italy", " manie", "United States", "ahher", "dede", "39839", "15687894432");
        Thread.sleep(3000L);
        registerPage.userCanContinue();
        Thread.sleep(3000L);
        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        homePage.openProductsPage();
        Thread.sleep(3000L);
        productsPage.addProductToCartByIndex(0);
        Thread.sleep(3000L);
        Assert.assertEquals(productsPage.popupMessage.getText().trim(), "Your product has been added to cart.");
        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(3000L);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(3000L);
        Assert.assertTrue(checkoutPage.addressDetailsTxt.isDisplayed() && checkoutPage.ReviewOrderTxt.isDisplayed());
        checkoutPage.commentTextArea.sendKeys("Great Quality");

        checkoutPage.placeOrderBtn.click();

        Thread.sleep(3000L);
        checkoutPage.enterPaymentDetails("Naomi shadan", "41144134341671711", "123", "12", "2029");
        Thread.sleep(1000L);
        Assert.assertTrue(checkoutPage.orderSuccessMsg.isDisplayed());
    }

    @Test(
            priority = 1
    )
    public void placeOrderRegisterWhileCheckout() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

        homePage.openProductsPage();
        Thread.sleep(3000L);
        productsPage.addProductToCartByIndex(0);
        Thread.sleep(3000L);
        Assert.assertEquals(productsPage.popupMessage.getText().trim(), "Your product has been added to cart.");
        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(3000L);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(1000);
        cartPage.CheckoutLoginBtn.click();
        Thread.sleep(3000);
        registerPage.userCanSignUpNewUser("HagarTest case", "hagar1417814455856564643@mail.com");
        Thread.sleep(1000);
        registerPage.userCanEnterAccountInformation("ezay", "15","June","1995", "hello_world", "Tomas", "lawyer", "italy", " manie", "United States", "ahher", "dede", "39839", "15687894432");
        Thread.sleep(3000L);
        registerPage.userCanContinue();
        Thread.sleep(3000L);
        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());
        homePage.openCartPage();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(3000L);
        Assert.assertTrue(checkoutPage.addressDetailsTxt.isDisplayed() && checkoutPage.ReviewOrderTxt.isDisplayed());
        checkoutPage.commentTextArea.sendKeys("Great Quality");

        checkoutPage.placeOrderBtn.click();

        Thread.sleep(3000L);
        checkoutPage.enterPaymentDetails("Naomi shadan", "41144134341671711", "123", "12", "2029");
        Thread.sleep(1000L);
        Assert.assertTrue(checkoutPage.orderSuccessMsg.isDisplayed());

    }

    @Test(
            priority = 3
    )
    public void placeOrderLoginBeforeCheckout() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
        homePage.openLoginPage();
        Thread.sleep(3000);

        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin("hagar141781445585653@mail.com", "ezay");
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        homePage.openProductsPage();
        Thread.sleep(3000L);
        productsPage.addProductToCartByIndex(0);
        Thread.sleep(3000L);
        Assert.assertEquals(productsPage.popupMessage.getText().trim(), "Your product has been added to cart.");
        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(3000L);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(3000L);
        Assert.assertTrue(checkoutPage.addressDetailsTxt.isDisplayed() && checkoutPage.ReviewOrderTxt.isDisplayed());
        checkoutPage.commentTextArea.sendKeys("Great Quality");

        checkoutPage.placeOrderBtn.click();

        Thread.sleep(3000L);
        checkoutPage.enterPaymentDetails("Naomi shadan", "41144134341671711", "123", "12", "2029");
        Thread.sleep(1000L);
        Assert.assertTrue(checkoutPage.orderSuccessMsg.isDisplayed());
    }

    @Test(
            priority = 4
    )
    public void verifyAddressDetailsInCheckout() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
        homePage.openRegisterPage();
        Thread.sleep(3000L);

        registerPage.userCanSignUpNewUser("Hagar", "hagar32@364187544.com");
        registerPage.userCanEnterAccountInformation("ezay", "15","June","1995", "hello_world", "Tomas", "lawyer", "italy", " manie", "United States", "ahher", "dede", "39839", "15687894432");
        Thread.sleep(3000L);
        registerPage.userCanContinue();
        Thread.sleep(3000L);
        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        homePage.openProductsPage();
        Thread.sleep(3000L);
        productsPage.addProductToCartByIndex(0);
        Thread.sleep(3000L);
        Assert.assertEquals(productsPage.popupMessage.getText().trim(), "Your product has been added to cart.");
        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(3000L);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(3000L);
        Assert.assertTrue(checkoutPage.addressDetailsTxt.isDisplayed() && checkoutPage.ReviewOrderTxt.isDisplayed());
        Assert.assertEquals(checkoutPage.deliveryAddress.getText(), "italy");
        Assert.assertEquals(checkoutPage.billingAddress.getText(), "italy");
        checkoutPage.commentTextArea.sendKeys("Great Quality");

        checkoutPage.placeOrderBtn.click();

        Thread.sleep(3000L);
        checkoutPage.enterPaymentDetails("Naomi shadan", "41144134341671711", "123", "12", "2029");
        Thread.sleep(1000L);
        Assert.assertTrue(checkoutPage.orderSuccessMsg.isDisplayed());
        Thread.sleep(3000L);

    }

    @Test(
            priority = 5
    )
    public void downloadInvoiceAfterPurchase() throws InterruptedException {
        // Initialize Page Objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);

        Thread.sleep(5000);
        // Verify home page is visible
        Assert.assertEquals(homePage.homeBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
        homePage.openLoginPage();
        Thread.sleep(3000);

        Assert.assertEquals(loginPage.loginHeader.getText(), "Login to your account");

        loginPage.userCanLogin("hagar141781445585653@mail.com", "ezay");
        Thread.sleep(3000);

        Assert.assertTrue(loginPage.loggedInMessage.isDisplayed());

        homePage.openProductsPage();
        Thread.sleep(3000L);
        productsPage.addProductToCartByIndex(0);
        Thread.sleep(3000L);
        Assert.assertEquals(productsPage.popupMessage.getText().trim(), "Your product has been added to cart.");
        productsPage.clickViewCartFromPopup(10);
        Thread.sleep(3000L);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
        cartPage.OpenCheckoutPage();
        Thread.sleep(3000L);
        Assert.assertTrue(checkoutPage.addressDetailsTxt.isDisplayed() && checkoutPage.ReviewOrderTxt.isDisplayed());
        checkoutPage.commentTextArea.sendKeys("Great Quality");
        checkoutPage.placeOrderBtn.click();

        Thread.sleep(3000L);
        checkoutPage.enterPaymentDetails("Naomi shadan", "41144134341671711", "123", "12", "2029");
        Thread.sleep(1000L);
        Assert.assertTrue(checkoutPage.orderSuccessMsg.isDisplayed());
        Assert.assertTrue(checkoutPage.downloadInvoiceLink.isDisplayed(), "Download Invoice link not visible!");
        checkoutPage.downloadInvoice();
        checkoutPage.userCanContinue();
        Thread.sleep(3000);

        Assert.assertTrue(registerPage.deleteAccountBtn.isDisplayed());

        Thread.sleep(3000);
        registerPage.deleteAccount();
        Assert.assertEquals(registerPage.deleteSuccessMessage.getText(), "ACCOUNT DELETED!");

        Thread.sleep(3000);

        registerPage.userCanContinue();

    }

}
