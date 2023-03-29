package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {
    @Test
    public void successfullLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle().trim();
        String expecedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expecedTitle);
    }

    @Test
    public void negativeLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("dusica");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("dusica");

        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(3000);

        WebElement message = driver.findElement(By.xpath("//div[@id='alert']"));

        String actualmessage = message.getText().trim();
        String expectedmessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualmessage, expectedmessage);
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(2000);


        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),' Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());

    }

    @Test
    public void validatesBoxesFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(2000);


        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),' Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        //box is displayed Assert
        //box is enabled
        //box is selected
        //Arrow down


        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(500);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Assert.assertFalse(allBoxes.get(i).isSelected());//box is not selected so it will return false
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());//true
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),' Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();

        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(2000);
        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualNames = new ArrayList<>();
        List<String> excpectedNames = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {//10elements
            actualNames.add(productNames.get(i).getText().toLowerCase().trim());//mostly for comparioson like acse0nding descending(to upper or lower case)
            excpectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(excpectedNames);//sorting for ascending
        Collections.reverse(excpectedNames);//making guarantee it is decsending order
        System.out.println(excpectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames, excpectedNames);
    }
    @Test
    public void productNameVAlidatonAscending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginBox = driver.findElement(By.tagName("button"));
        loginBox.click();
        Thread.sleep(2000);
        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),' Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();

     List<WebElement> allNames=driver.findElements(By.xpath("//td[@class='text-start']"));

     List<String> actualNames=new ArrayList<>();
     List<String> expectedNames=new ArrayList<>();

     for (int i=1;i<allNames.size();i++){
         actualNames.add(allNames.get(i).getText().toLowerCase().trim());//10elements same order
         expectedNames.add(allNames.get(i).getText().toLowerCase().trim());//1o elements same order

     }

     Collections.sort(expectedNames);
     Assert.assertEquals(actualNames,expectedNames);

    }
}
