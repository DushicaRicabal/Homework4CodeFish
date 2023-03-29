package com.codefishNinjaPractice.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegisterPatientPage {
    public RegisterPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='givenName']")

    WebElement givenName;
    @FindBy(xpath = "//input[@name='familyName']")
    WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement gender;
    @FindBy(xpath = "//select[@id='gender-field']")

    WebElement genderBox;
    @FindBy(css = "#birthdateLabel")

    WebElement birthday;//**************************?????HOW

    @FindBy(xpath = "//input[@id='birthdateYears-field']")
    WebElement estimatedYeard;

    @FindBy(xpath = "//li[.='Address']")

    WebElement address;
    @FindBy(css = "#address1")
    WebElement addressLine1;
    @FindBy(css = "#cityVillage")

    WebElement cityVillage;
    @FindBy(css = "#stateProvince")

    WebElement stateProvince;
    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#postalCode")
    WebElement postalCode;

    @FindBy(xpath = "//li[@class='question-legend done focused']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement patientPhoneNumberBox;

    @FindBy(xpath = "//span[@id='confirmation_label']")
    WebElement confirmButtonLable;

    @FindBy(css = "#submit")
    WebElement confirmButton;

//-----------------------------??????????????????????case 4
    @FindBy(name = "identifiers")
    WebElement patientID;

    @FindBy(css = ".patient-header ")
    WebElement patientHeader;


    @FindBy(name = "org.openmrs.module.coreapps.deletePatient")
    WebElement deleteButton;






    public void RegisterPatient(){

        givenName.sendKeys("Dusica");
        familyName.sendKeys("Ricabal");
        gender.click();
        Select chooseGender = new Select(genderBox);
        chooseGender.selectByValue("F");
        estimatedYeard.clear();//*********************************?????
        address.click();
        addressLine1.sendKeys("2200 E Devon ave");
        cityVillage.sendKeys("Des Plains");
        stateProvince.sendKeys("IL");
        country.sendKeys("county cook");
        postalCode.sendKeys("60018");
    }
    public void phoneNumberFunctionality(WebDriver driver) {
        phoneNumber.click();

        patientPhoneNumberBox.sendKeys("996 52 18 0592");
        confirmButtonLable.click();
        confirmButton.click();

        //patientID.

        deleteButton.click();
        driver.navigate().back();



    }
}
