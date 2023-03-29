//package com.uitestpractice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

//public class UiTestMainPageTest {
//    public WebDriver driver;
//    @BeforeMethod
//    public void setup() {
//        driver = DriverHelper.getDriver();
//        driver.get("http://uitestpractice.com/Students/Select#");
//
//    }
//    @Test
//    public void ValidateCountrySelection(){
//        Select countries = new Select(selectCountryBox);
//        // countries.getAllSelectedOptions();//do I need one ifI can Sout to validate ?
//        System.out.println(countries.getFirstSelectedOption().getText().trim());
//
//    }
//
////2-Validate the size of the Drop down box is 4
//    //@FindBy
//
//
//
//
//
////3-Validate the values for Drop down box are :India,United States of America,China,England
//// Select the China with index number//Select the England with value//Select the United States with visible text
//
// @Test
//public  void ValidateValuesInDropdownBox(){
//
//        List<WebElement> allTheCountries=countries.getOptions();
//        List<String>expectedCountries= Arrays.asList("India", "United states of America", "China", "England");
//        for(int i =0;i<allTheCountries.size();i++){
//            Assert.assertEquals(allTheCountries.get(i).getText().trim(),expectedCountries.get(i));
//        }
//        countries.selectByIndex(2);
//        countries.selectByValue("england");
//        countries.selectByVisibleText("United states of America");
//
//}

//
////    @AfterMethod
////    public void tearDown() throws InterruptedException {
////      if(!iTestResult.isSuccess()){
////            Thread.sleep(3000);
////            BrowserUtils.getScreenShot(driver,"blazepicture");
////        }
//
//   //     driver.quit();
//}}
