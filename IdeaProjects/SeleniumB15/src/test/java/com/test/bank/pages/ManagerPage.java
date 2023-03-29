package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerPage {

    public ManagerPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerButton;

    @FindBy(tagName = "input")
    WebElement searchBox;
    @FindBy(xpath = "/tbody//tr[1]//td[@class='ng-binding']")
    List<WebElement> allinfromation;////tbody/tr[@class='ng-scope']//td[.='Dusica']--->How to find the other two elements? When there are more same name ?????

    @FindBy(xpath = "//button[.='Delete']")//What if I have more then one delete button ?
    WebElement deleteButton;


    public void validateAddingCustomerFunctionality(WebDriver driver, String firstName, String lasName, String postCode, String message) {

        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lasName);
        this.postCode.sendKeys(postCode);
        submitAddCustomer.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(message));
        alert.accept();
    }

    public void validateOpenAccountFunctionality(WebDriver driver, String fullName, String curencyValue, String mesage) throws InterruptedException {
        openAccount.click();
        Thread.sleep(3000);
        BrowserUtils.selectBy(customerName, fullName, "text");
        Thread.sleep(3000);
        BrowserUtils.selectBy(currency, curencyValue, "value");
        Thread.sleep(3000);
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(mesage));
        alert.accept();
    }

    public void validateCustomerInformationAndDeleteFunctionality(String name, String lastName, String postCode) {
        customerButton.click();
        searchBox.sendKeys(name);
        List<String> expectedinformation = Arrays.asList(name, lastName, postCode);

        for (int i = 0; i < allinfromation.size(); i++) {

            Assert.assertEquals(BrowserUtils.getText(allinfromation.get(i)),expectedinformation.get(i));
        }

        deleteButton.click();


    }

}
