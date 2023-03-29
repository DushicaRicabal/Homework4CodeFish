package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.demoblaze.com/#");
//    }
@DataProvider(name = "customer info")
public Object [][] getData(){
    return new Object[][]{
            {"Ahmet","Turkey","Ankara","1234567","12","2025"},
            {"Mark","EAU","Dubai","345678","11","2026"},
            {"Dusica","USA","Chicago","63258","2","2027"}
    };
}

    @Test(dataProvider = "customer info")
    public void ValidateOrderFunctionality(String name,String country,String city, String creditCard,String month,String year) throws InterruptedException {
        MainPageBlaze mainPageBlaze=new MainPageBlaze(driver);
        mainPageBlaze.clickLapTopButton();
        LapTopPage laptopPage=new LapTopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        CartPage cartPage =new CartPage(driver);
        mainPageBlaze.clickCartButon();
        cartPage.validateProductInformation("MacBook Pro","1100");
        OrderPage orderPage=new OrderPage(driver);
        orderPage.clickOrderButton();
orderPage.validateOrderFunctionality(name,country,city,creditCard,month,year,"Thank you for your purchase!");

        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");
    }

}
