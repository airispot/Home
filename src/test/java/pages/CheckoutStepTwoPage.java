package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private final By finishButton = By.id("finish");

    public boolean finishButtonIsDisplayed() {
        return driver.findElement(finishButton).isDisplayed();

    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
