package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {


  private final By removeButton = By.xpath("//button[text()='Remove']");
   String cartItemContainer = "//div[@class='inventory_item_name' and text () = '%s']/ancestor::div[@class='cart_item']";
  private final By cartProductDescription = By.cssSelector("div.inventory_item_desc");
    private final By checkoutButton = By.id("checkout");
  private final By continueShoppingButton = By.id("continue-shopping");


   public CartPage (WebDriver driver){
      super(driver);
   }

   public void clickRemoveButton() {
      driver.findElement(removeButton).click();
   }

   public String getCartIProductDescription(String productName){
      WebElement cartItemContainer = getCartItemContainer(productName);
      return cartItemContainer.findElement(cartProductDescription).getText();
   }
   public WebElement getCartItemContainer(String productName) {
      return  driver.findElement(By.xpath(String.format(cartItemContainer, productName)));
   }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

   public void clickContinueShoppingButton() {
      driver.findElement(continueShoppingButton).click();
   }

}
