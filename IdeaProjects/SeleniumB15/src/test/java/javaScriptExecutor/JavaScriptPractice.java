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
import java.util.Arrays;
import java.util.List;

@Test

public class JavaScriptPractice {

    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");

        WebElement applyNowButton= driver.findElement(By.xpath("//a[@id='menuItem_1594985863854_2']"));
        BrowserUtils.clickWithJS(driver,applyNowButton);
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollintoView(true),");

        WebElement copyRightText = driver.findElement(By.xpath("//div[@id='el_1666192783854_462']"));



        List<WebElement> allInformation=driver.findElements(By.xpath(""));
        List <String> expectedInformation= Arrays.asList("","","");

        //NOTE :Whenever we comparing two lists use FOR LOOP

        for (int i =0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }









    }
}
