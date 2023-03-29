package com.test.blaze.tests;

import com.test.blaze.pages.LapTopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPageBlaze;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBaseBlaze {
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


    @Parameters({"laptopBrand","laptopPrice","message","description"})

    @Test
    public void ValidateMcBookProductInfo(String laptopBrand,String laptopPrice,String message,String description) throws InterruptedException {
        MainPageBlaze mainPageBlaze = new MainPageBlaze(driver);
        mainPageBlaze.clickLapTopButton();
        LapTopPage lapTopPage = new LapTopPage(driver);
        lapTopPage.chooseLaptop(laptopBrand);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.ValidateProductInformation(laptopBrand,laptopPrice,description);

        macBookProPage.clickAddToCartButton(driver,message);
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
    }

