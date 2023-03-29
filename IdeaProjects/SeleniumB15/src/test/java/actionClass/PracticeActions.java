package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void validateMessageAndColor() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        Thread.sleep(3000);

        WebElement draggerBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));//parent child relationship
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggerBox, droppableBox).perform();
        String actualMessage= BrowserUtils.getText(droppableBox);
        String expectedMessage ="Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);
      //  String actualColor=droppableBox.getCssValue();
        String expectedColor ="rgba (70, 130, 180, 1)";
            //    Assert.assertEquals(actualColor,expectedColor);

    }
    @Test
    public void validateNotAcceptableFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement notAcceptableVBox= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualMessage= BrowserUtils.getText(notAcceptableVBox);
        String expectedMessage ="Not Acceptable";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement dropHereBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualBoxName=BrowserUtils.getText(dropHereBox);
        String expectedBoxName="Drop here";
        Assert.assertEquals(actualBoxName,expectedBoxName);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptableVBox).moveToElement(dropHereBox).release().perform();

        String actualBoxNameAfter=BrowserUtils.getText(dropHereBox);
        String expectedBoxNameAfter="Drop here";
        Assert.assertEquals(actualBoxNameAfter,expectedBoxNameAfter);




    }
}
