package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {


    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);//initializing all elements driver.findElement
    }

    @FindBy (xpath = "//input[@id='username']")// this is Webelement elm=driver.findElement(By.xpath"//input[@id='username'])
    WebElement username;

    @FindBy (xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'The username or password')]")
    WebElement errorMessage;

    public void login(String username,String password){
        this.username.sendKeys("EM01");
        this.password.sendKeys("sentrifugo");
        loginButton.click();
    }
    public String validateErrorMessage(){
        return BrowserUtils.getText((errorMessage));

    }

    public String validateColorOrErrorMessage(){
        return errorMessage.getCssValue("color").trim();
    }



}
