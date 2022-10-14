package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductPage productPage;

    protected CartPage cartPage;

    protected CheckoutCompletePage checkoutCompletePage;

    protected CheckoutStepOnePage checkoutStepOnePage;

    protected CheckoutStepTwoPage checkoutStepTwoPage;

   // @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        String browserName = System.getProperty("browser");
        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
    }

    @BeforeMethod (alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}