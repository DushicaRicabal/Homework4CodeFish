package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MainPageBlaze {
    public MainPageBlaze(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//a[.='Laptops']")
        WebElement laptopButton;
        public void clickLapTopButton() throws InterruptedException {
            Thread.sleep(2000);
           laptopButton.click();
    }

    @FindBy(id="cartur")
    WebElement cartButtonp;

        public void clickCartButon(){
            cartButtonp.click();
        }








}
