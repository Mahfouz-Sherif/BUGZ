package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // ===============================
    // 🔹 Locators
    // ===============================

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
    public WebElement contactHeaderTxt;

    @FindBy(css="#contact-us-form > div:nth-child(2) > input")
    private WebElement nameTxt;

    @FindBy(css="#contact-us-form > div:nth-child(3) > input")
    private WebElement emailTxt;

    @FindBy(css="#contact-us-form > div:nth-child(4) > input")
    private WebElement subjectTxt;

    @FindBy(id="message")
    private WebElement messageTxt;

    @FindBy(css="#contact-us-form > div:nth-child(6) > input")
    private WebElement uploadBtn;

    @FindBy(css="#contact-us-form > div:nth-child(7) > input")
    private WebElement submitBtn;

    @FindBy(css = "#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")
    public WebElement successMsg;

    @FindBy(xpath = "//*[@id=\"form-section\"]/a/span")
    private WebElement goHomeBtn;
    // ===============================
    // 🔹 Page Actions
    // ===============================

    public void userCanSubmitContactFormInfo(String name,String email, String subject, String message, String filePath) {
        nameTxt.sendKeys(name);
        emailTxt.sendKeys(email);
        subjectTxt.sendKeys(subject);
        messageTxt.sendKeys(message);
        uploadBtn.sendKeys(filePath);
        submitBtn.submit();
    }

    public void goToHomePage()
    {
        goHomeBtn.click();
    }
}
