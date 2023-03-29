package com.test.saucedemo.tests;

import com.test.saucedemo.pages.SauceInventoryPage;
import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductTest extends SauceTestBase {


    @Test(dataProvider = "TestingProductLinks",dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String inventroyName, String expectedDecs,String expectedPrice){
        SauceLoginPage sauceLoginPage =new SauceLoginPage(driver);

        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"));


        SauceInventoryPage inventoryPage=new SauceInventoryPage(driver);
        inventoryPage.chooseProduct(inventroyName,expectedDecs,expectedPrice);

    }
}
