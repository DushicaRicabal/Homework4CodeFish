package com.codefishNinjaPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class MainLoginPageCodefishNinja {
    public MainLoginPageCodefishNinja(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//li[@id='Laboratory']")
    WebElement labaratory;
    @FindBy(xpath = "//input[@id='loginButton']")

    WebElement loginButton;

    public void Login(WebDriver driver ) {
        Actions actions = new Actions(driver);
        username.sendKeys("admin");
        password.sendKeys("Admin123");
        actions.click(labaratory).perform();
        actions.click(loginButton);

        String actualLocationLaboratory= BrowserUtils.getText(labaratory);
        String expectedLocationLaboratory="Laboratory";
        Assert.assertEquals(actualLocationLaboratory,expectedLocationLaboratory);
    }
}






