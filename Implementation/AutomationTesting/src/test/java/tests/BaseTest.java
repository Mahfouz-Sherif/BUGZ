package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://automationexercise.com"; // Base URL

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically setup ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl); // Open base URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
