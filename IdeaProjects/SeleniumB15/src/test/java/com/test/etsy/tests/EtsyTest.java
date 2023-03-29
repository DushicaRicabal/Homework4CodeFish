package com.test.etsy.tests;

import com.test.etsy.pages.EtsyMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTest extends EtsyTestBase {

   @Parameters({"searchWord","brand","model","casePhone"})
    @Test
    public void validateSearchFunctionality(String searchWord,String brand,String model,String casePhone){

        EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
        etsyMainPage.searchdata("Iphone 13 case");
        etsyMainPage.validateheaders("iphone","13","Case");
    }


}
