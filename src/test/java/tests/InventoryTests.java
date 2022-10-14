package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTest {
    private final String TEST_ITEM_NAME = "Sauce Labs Onesie";
    private final String TEST_ITEM_NAME2 = "Sauce Labs Bike Light";
    protected final String TEST_USER_NAME = "standard_user";
    protected final String TEST_PASSWORD = "secret_sauce";
    @Test (groups = {"Smoke"}, enabled = true, description = "temporary disabled until...")
    public void productAvailabilityTest () throws InterruptedException {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        String actualPrice = productPage.getProductPrice(TEST_ITEM_NAME);
        String actualDescription = productPage.getProductDescription(TEST_ITEM_NAME);
        Assert.assertEquals(actualPrice, "$7.99");
        Assert.assertEquals(actualDescription, "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    productPage.clickAddToCartButton(TEST_ITEM_NAME);
    productPage.openProductDetails(TEST_ITEM_NAME);
        Thread.sleep(5000);
    }
    @Test (groups = {"Smoke"}, enabled = true)
    public void secondProductAvailabilityTest () throws InterruptedException {
        loginPage.login(TEST_USER_NAME, TEST_PASSWORD);
        String actualPrice = productPage.getProductPrice(TEST_ITEM_NAME2);
        String actualDescription = productPage.getProductDescription(TEST_ITEM_NAME2);
        Assert.assertEquals(actualPrice, "$9.99");
        Assert.assertEquals(actualDescription, "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        productPage.clickAddToCartButton(TEST_ITEM_NAME2);
        productPage.openProductDetails(TEST_ITEM_NAME2);
        Thread.sleep(5000);
    }


}
