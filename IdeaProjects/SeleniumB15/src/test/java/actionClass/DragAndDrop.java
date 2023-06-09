package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(3000);

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));

        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualColorOfBox = orangeBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(expectedColorOfBox, actualColorOfBox);

        WebElement draggerCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();
        actions.dragAndDrop(draggerCircle, orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));//REASIGNING THE VALUE TO FIND A ELEMENT AGAIN,not creating new element

        String ActualMessageAfterDragAndDrop = BrowserUtils.getText(orangeBox);
        String expectedMessageAfterDragAndDrop = "You did great!";
        Assert.assertEquals(expectedMessageAfterDragAndDrop, ActualMessageAfterDragAndDrop);

    }

    @Test
    public void ClickAndRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(3000);

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));

        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMEssage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage, expectedMEssage);

        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);
        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragger).moveToElement(blueBox).release().perform();
        String actualMessageAfterClickAndHold = BrowserUtils.getText(blueBox);
        String expectedMessageAfterClickAndHold = "You did great";
        Assert.assertEquals(actualMessageAfterClickAndHold, expectedMessageAfterClickAndHold);


    }

}