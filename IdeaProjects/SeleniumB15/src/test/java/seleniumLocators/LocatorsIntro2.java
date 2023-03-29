package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//optional
        driver.navigate().to("file:///C:/Users/dusic/Downloads/Techtorialhtml%20(1).html");

        //LINKTEXTLOCATOR
        WebElement javaLink= driver.findElement(By.linkText("Java"));//a tag with the text
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java")?"Passed":"Failed");
        Thread.sleep(2000);//it will pause 2 sec and then
        driver.navigate().back();
         //TASK//
        //1-Clicke Selenium and validate(ternary) header-->Selenium automates browser.That is it
        //2.Go back to the main page
        //3.Click Cucumber and validate (ternary )header -->Tools & techniqus that elevates teams to greatness
        //4-Go back to the main page
        //5-Clic TestNg and validate (ternary) header --> TestNG
        //6-Go back to the main page
        //7-Validate (ternary ) the url is "//file:///C:/Users/dusic/Downloads/Techtorialhtml%20(1).html"

        WebElement seleniumLink= driver.findElement(By.linkText("Selenium"));//a tag with the text
        seleniumLink.click();
        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText().trim().equals("Selenium")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

       WebElement cucumberLink= driver.findElement(By.linkText("Cucumber"));//a tag with the text
       cucumberLink.click();
        WebElement headerCucumber = driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText().trim().equals("h1")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement testNGLink= driver.findElement(By.linkText("TestNG"));//a tag with the text
        cucumberLink.click();
        WebElement headertestNG = driver.findElement(By.tagName("h2"));
        System.out.println(headertestNG.getText().trim().equals("h2")?"Passed":"Failed");
        Thread.sleep(2000);
        driver.navigate().back();


     //PARTIAL LINK TEXT LOCATOR://must have a tag and text
        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
       // WebElement restApi2 = driver.findElement(By.linkText("Rest-api"));//this is thw whole name of the link text beacuse it uses linkText
        // and not partialLinkText
        restApi.click();
        String actualUrlRestApi=driver.getCurrentUrl();
        String expectedUrlRestApi="https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expectedUrlRestApi)?"Passed":"Failed");
        driver.navigate();


    }
}
