package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMassageContainer = By.cssSelector("div.error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void  open (){
        driver.get("https://www.saucedemo.com/");
    }

    public boolean isErrorMassageContainerDisplayed() {
     return   driver.findElement(errorMassageContainer).isDisplayed();
    }
    public String getErrorMessageText(){
     return   driver.findElement(errorMassageContainer).getText();
    }


    public void login(String userName, String password) {
        setPasswordInputValue(userName);
        setPasswordInputValue(password);
        clickLoginButton();
    }
    public void setUserNameInputValue(String userName) {

        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPasswordInputValue(String userName) {

        driver.findElement(passwordInput).sendKeys(userName);
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }
}
