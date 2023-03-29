package com.codefishNinjaPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;


public class HomePage {


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    //Case3Part2
    @FindBy(name = "Register a patient      ")
    WebElement registerPatientBox;
    @FindBy(xpath = "//li[@id='Laboratory']")
    WebElement labaratory;
    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement locationLaboratory;
    @FindBy(tagName = "h4")
    WebElement message;
    @FindBy(xpath = "//i[@class='link icon-caret-down']")
    WebElement arrowButtonLocationChanging;
    @FindBy(xpath = "//li[contains(text(),'Pharmacy')]")
    WebElement farmacy;

    @FindBy(css = ".logo")
    WebElement logoMRS;

    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement patientRecordButton;

    @FindBy(xpath = "//td[contains(text(),'John johns')]")
    WebElement patientName;

    public void RegisterNewPatient(WebDriver driver) {

        Actions actions = new Actions(driver);
        username.sendKeys("admin");
        password.sendKeys("Admin123");
        actions.click(labaratory).perform();
        actions.click(loginButton).perform();
        registerPatientBox.click();
    }


    public void ValidateLabaratoryLocation(WebDriver driver) {
        Actions actions = new Actions(driver);
//        String actualLocation = BrowserUtils.getText(locationLaboratory);
//        String expectedLocation = "Laboratory";
//        Assert.assertEquals(actualLocation, expectedLocation);

        String actualMessage = BrowserUtils.getText(message);//*********************************************
        String expectedMessage = "Logged in as Super User (admin) at Laboratory"; //?????????????
        Assert.assertEquals(actualMessage, expectedMessage);

        arrowButtonLocationChanging.click();
        actions.moveToElement(farmacy);
        farmacy.click();
        logoMRS.click();

        String actualMessageAdminPharmacy = BrowserUtils.getText(message);
        String expectedMessageAdminPharmacy = "Logged in as Super User (admin) location change to Pharmacy";

        Assert.assertEquals(actualMessageAdminPharmacy, expectedMessageAdminPharmacy);

        patientRecordButton.click();
        //*************************************************************************8
        //HOw to see if it is unique???

    }


}
