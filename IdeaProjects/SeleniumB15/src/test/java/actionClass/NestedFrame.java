package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        WebElement topFrame = driver.findElement(By.name("frame-top"));
        WebElement left = driver.findElement(By.xpath("//body[contains(text),'LEFT')]"));
        String actualText = BrowserUtils.getText(left);
        String expectedText = "LEFT";
        Assert.assertEquals(actualText, expectedText);
        driver.switchTo().parentFrame();//1 above the
        driver.switchTo().frame("frame-middle");


        //MIDLE AND RIGHT

        WebElement middle = driver.findElement(By.cssSelector("#content"));
        String actualMiddleText = BrowserUtils.getText(middle);
        String expectedMiddleText = "content";
        Assert.assertEquals(actualText, expectedText);
        driver.switchTo().parentFrame();//1 above the
        driver.switchTo().frame("frame-right");


        WebElement right = driver.findElement(By.xpath("//frame[@name='frame-right']"));
        String actualRightText = BrowserUtils.getText(right);
        String expectedRightText = "RIGHT";
        Assert.assertEquals(actualRightText, expectedRightText);
        //BOTTOM FRAME
//        driver.switchTo().parentFrame();//TOP FRAME
//        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-right");//BOTTOM FRAME
        WebElement bottom = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        String actualbottomText = BrowserUtils.getText(right);
        String expectedbottomText = "BOTTOM";
        Assert.assertEquals(actualbottomText, expectedbottomText);


    }
}
