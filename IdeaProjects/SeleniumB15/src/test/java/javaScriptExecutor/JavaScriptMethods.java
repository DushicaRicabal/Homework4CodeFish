package javaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {
    //We useJava script method when Selenium Methods are not working as expected
    //Specificaly,click,getTitle
    //Note :WE Love using ScrollIntoView Method from JavaSript  in proffessional environment

    @Test
    public void getTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle() + "This is regular driver method for title");
        //If this one is not working then I need to use JAVA SCRIPT METHOD
        JavascriptExecutor js = (JavascriptExecutor) driver;//Your driver is acting like JS executor
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + "This is JS method title");
    }

    @Test
    public void clickJS() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yes Radio"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage = BrowserUtils.getText(message);//message.getText.trim();
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(3000);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressiveButton);
        String actualImpressiveMessage = BrowserUtils.getText(message);
        String expectedImpressiveMessage = "You have seleted Impressive";
        Assert.assertEquals(actualImpressiveMessage, expectedImpressiveMessage);

    }

    //This is all about scrolling the page based on the location of the elment>>
    @Test
    public void scrolIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text0,'Find out which course is for you']//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollintoView(true)", findCourse);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()");//**
        System.out.println(js.executeScript("return document.title"));//*

    }
    @Test
    public void shortCutJSMethods() throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.techtorialacademy.com/");
            WebElement findCourse = driver.findElement(By.xpath("//span[contains(text0,'Find out which course is for you']//.."));

            Thread.sleep(3000);
            BrowserUtils.scrollWithJS(driver, findCourse);
            BrowserUtils.clickWithJS(driver, findCourse);

            Thread.sleep(3000);
            System.out.println(BrowserUtils.getTitleWithJS(driver));
    }

    @Test
    public void homeworkCoursesTechtorial() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text0,'Find out which course is for you']//.."));

        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver, findCourse);
        BrowserUtils.clickWithJS(driver, findCourse);
      //  WebElement containsTextButton = driver.findElement(By.);
        //containsTextButton.click();

}}

