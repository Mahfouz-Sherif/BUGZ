package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    //=============================
    // Sign Up Locators
    //=============================
    @FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
    private WebElement newUserSignupText;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    //=============================
    // Account Information Locators
    //=============================
    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    private WebElement enterAccountInfoText;

    @FindBy(id = "id_gender1")
    private WebElement mrTitleRadio;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement offersCheckbox;

    //=============================
    // Address Details Locators
    //=============================
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    //=============================
    // Account Creation Locators
    //=============================
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Deleted!')]")
    private WebElement accountDeletedText;

    //=============================
    // Constructor
    //=============================
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //=============================
    // Actions - Signup Section
    //=============================
    public boolean isNewUserSignupVisible() {
        return newUserSignupText.isDisplayed();
    }

    public void signup(String name, String email) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        signupButton.click();
    }

    //=============================
    // Actions - Account Info Section
    //=============================
    public boolean isEnterAccountInfoVisible() {
        return enterAccountInfoText.isDisplayed();
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        mrTitleRadio.click();
        passwordInput.sendKeys(password);
        daysDropdown.sendKeys(day);
        monthsDropdown.sendKeys(month);
        yearsDropdown.sendKeys(year);
    }

    public void selectCheckboxes() {
        newsletterCheckbox.click();
        offersCheckbox.click();
    }

    //=============================
    // Actions - Address Section
    //=============================
    public void fillAddressDetails(String firstName, String lastName, String company, String address1,
                                   String address2, String country, String state, String city,
                                   String zipcode, String mobile) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        countryDropdown.sendKeys(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobile);
    }

    //=============================
    // Actions - Account Creation Section
    //=============================
    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isLoggedInVisible() {
        return loggedInAsText.isDisplayed();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
    }

    public boolean isAccountDeletedVisible() {
        return accountDeletedText.isDisplayed();
    }
}

