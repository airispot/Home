package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private final String TEST_ITEM_NAME = "Sauce Labs Onesie";
    protected final String TEST_USER_NAME = "standard_user";
    protected final String TEST_PASSWORD = "secret_sauce";


    @Test
    public void removeItemFromTheCart() throws InterruptedException {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();
        String actualDescription = cartPage.getCartIProductDescription(TEST_ITEM_NAME);
        Assert.assertEquals(actualDescription, "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    cartPage.clickRemoveButton();
    cartPage.clickContinueShoppingButton();
    Assert.assertTrue(productPage.isHeaderContainerDisplayed());
    }


    @Test

    public void checkoutStepOneTest(){

        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();

        cartPage.clickCheckoutButton();
        checkoutStepOnePage.checkoutStepOneForm();
        checkoutStepTwoPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productPage.isHeaderContainerDisplayed());
    }

    @Test

    public void checkoutStepTwoTest(){

        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        productPage.clickAddToCartButton(TEST_ITEM_NAME);
        productPage.clickShoppingCartLink();
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.checkoutStepOneForm();
        checkoutStepTwoPage.clickFinishButton();

        Assert.assertTrue(checkoutCompletePage.thankYouTextIsDisplayed());
    }

}
