package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FramePractice {

    @Test

    public void iFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");


        WebElement header = driver.findElement(By.tagName("h3"));
        String actualString = BrowserUtils.getText(header);
        String expectedString="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualString,expectedString);
        driver.switchTo().frame("//ifram");

        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.click();
        Thread.sleep(2000);
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();

    WebElement elementalSelenium= driver.findElement(By.linkText("Ekemental Selenium"));

    elementalSelenium.click();
    WebElement seleniumHeader= driver.findElement(By.xpath("//h1"));
    String actualSeleniumHeader=BrowserUtils.getText(seleniumHeader);

    String expectedSeleniumHeader="Elemental Selenium";

    Assert.assertEquals(actualSeleniumHeader,expectedSeleniumHeader);
    }
}

