package com.uitestpractice.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UiTestMainPage {
    public UiTestMainPage(WebDriver driver) {
        PageFactory.initElements((SearchContext) driver, this);
    }

    //1-Validate India is selected by default on drop down box
    @FindBy(xpath = "//select[@id='countriesSingle']")
    WebElement selectCountryBox;
    Select countries = new Select(selectCountryBox);

    @Test
    public void ValidateCountrySelection() {
        Select countries = new Select(selectCountryBox);
        countries.getAllSelectedOptions();
        String actualCountryIndia = countries.getFirstSelectedOption().getText().trim();
        String expectedCountryIndia = "India";
        Assert.assertEquals(actualCountryIndia, expectedCountryIndia);
        // System.out.println(countries.getFirstSelectedOption().getText().trim()); Do I need this?
    }
    //2-Validate the size of the Drop down box is 4//???????????????????????

    public void ValidateSizeOfDropdownBox() {
    }

    //3-Validate the values for Drop down box are :India,United States of America,China,England
    // Select the China with index number//Select the England with value//Select the United States with visible text
    @Test
    public void ValidateValuesInDropdownBox() throws InterruptedException {
        List<WebElement> allTheCountries = countries.getOptions();
        List<String> expectedCountries = Arrays.asList("India", "United states of America", "China", "England");
        for (int i = 0; i < allTheCountries.size(); i++) {
            Assert.assertEquals(allTheCountries.get(i).getText().trim(), expectedCountries.get(i));
        }
        countries.selectByIndex(2);
        Thread.sleep(2000);
        countries.selectByValue("england");
        Thread.sleep(2000);
        countries.selectByVisibleText("United states of America");

        // int counter=0;
        //for(WebElement countryName:allTheCountries){
        //    System.out.println(countryName.getText().trim());//To get all the names of the countries on the list
        //counter ++;
        //sout(counter);
    }
    //TESTCASE 2
    //1-Validate the values for Multiple Select are ://India,United States of America,China,/England

    @FindBy(xpath = "//select[@id='countriesMultiple']")
    WebElement multipleSelectBox;
    Select multipleSelect = new Select(multipleSelectBox);

    @Test
    public void ValidateMultipleSelect() throws InterruptedException {
        List<WebElement> allCountiresSelection = multipleSelect.getOptions();
        List<String> expectedCountriesSelection = Arrays.asList("India", "United States of America", "China", "England");
        for (int i = 0; i < allCountiresSelection.size(); i++) {
            Assert.assertEquals(allCountiresSelection.get(i).getText().trim(), expectedCountriesSelection.get(i));
        }
//***************************************************************
        //2-Validate "China England" is displayed
        // multipleSelect.selectByValue("china");
        // multipleSelect.selectByVisibleText("England");
        //@FindBy(xpath = "//option[@value='china']")

        // WebElement china;

        //Webelement is Displayed??????
//***************************************************************
        //3-Deselect all the countries
        //Select All the countries
        multipleSelect.deselectAll();
        Thread.sleep(2000);
        multipleSelect.getAllSelectedOptions();//??????

        //4-Validate "India United states of America China,England" is displayed???? all selected??
        //5-Deselect the China with index number
        //Deselect the England with value
        multipleSelect.deselectByIndex(2);
        Thread.sleep(2000);
        multipleSelect.deselectByValue("england");

    }
}