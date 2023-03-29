package com.test.saucedemo.tests;

import com.test.saucedemo.pages.SauceInventoryPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceOrderTest extends SauceTestBase{

    @Test (dataProvider = "CustomerOrderInfo", dataProviderClass = AllData.class)
    public  void validateCustomerOrder(String name,String lastName,String postalCode,String orderMessage){

        SauceInventoryPage sauceInventoryPage= new SauceInventoryPage(driver);

        sauceInventoryPage.validateOrderlInfo(name,lastName,postalCode);
        Assert.assertEquals(orderMessage,"Thank you for your order!");




    }
}
