package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceInventoryPage {
    public SauceInventoryPage(WebDriver driver) {
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;
    //---------------------------------------Homework part ----------------------------------------------
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement sauceBackpack;
    @FindBy(css = ".inventory_details_price")
    WebElement sauceBackPackPrice;

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;
    @FindBy(css = "#shopping_cart_container")
    WebElement cartButton;

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement postalCode;
    @FindBy(css = "#continue")
    WebElement continueButton;
    @FindBy(css = "#finish")
    WebElement finishButton;

    @FindBy(css = ".complete-header")
    WebElement orderMessage;


    public void chooseProduct(String productName, String expectedDescr, String expectedPrice) { ///this is for list
        for (WebElement product : allProducts) {
            if (BrowserUtils.getText(product).contains(productName)) {
                product.click();
                break;
            }
        }

        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescr));
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
    }

    public void validateorder(String productName, String productPrice) {
        for (WebElement product : allProducts) {
            if (BrowserUtils.getText(product).contains(productName)) {
                product.click();
                break;
            }
        }
        addToCartButton.click();
        cartButton.click();
        checkoutButton.click();
        finishButton.click();


    }

    public void validateOrderlInfo(String name, String lastName, String postalCode) {


    }
}
