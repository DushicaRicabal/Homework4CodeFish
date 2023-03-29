package com.codefishNinjaPractice.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class CodeFIshNinjaTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("http://codefish.ninja/openmrs/login.htm");
    }

    @Test
    public void ValidateLoginFunctionality (){


    }




    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }




}

