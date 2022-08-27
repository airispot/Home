package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private final By userFirstInput = By.id("first_name");
    private final By userLastInput = By.id("last-name");
    private final By userPostalCodeInput = By.id("postal-code");
    private final By errorMessageContainer = By.cssSelector("div.error-message-container");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");


     public void setFirstName(String firstNameInputValue) {
         driver.findElement(userFirstInput).sendKeys(firstNameInputValue);
     }

     public void setLastName(String lastNameInputValue){
         driver.findElement(userLastInput).sendKeys(lastNameInputValue);
     }

     public void setUserPostalCodeInput(String postalCodeInputValue){
         driver.findElement(userPostalCodeInput).sendKeys(postalCodeInputValue);
     }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }

    public boolean isErrorMessageContainerDisplayed() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }


    public void checkoutStepOneForm()
    { driver.findElement(continueButton).click();
    }
}
