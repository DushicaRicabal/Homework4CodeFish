package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertIntro() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));//ATRIBUTE
        //button[contains(text),'click for')]
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String actualJSAlertText = alert.getText();//get the text from ALERT POP-UP
        String expectedJSAlertText = "";
        Assert.assertEquals(actualJSAlertText, expectedJSAlertText);

        Thread.sleep(3000);
        alert.accept();//it clicks OK Button

        WebElement message = driver.findElement(By.cssSelector("result"));
        String actualMessage = BrowserUtils.getText(message);//this is webelement . so ia can not use browese utils
        String expectedmessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedmessage);
    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));//ATRIBUTE
        message.click();
        String actualMessage = BrowserUtils.getText(message);//this is webelement . so ia can not use browese utils
        String expectedmessage = "You clicked Cancel";
        Assert.assertEquals(actualMessage, expectedmessage);
        Thread.sleep(3000);
    }

    @Test
    public void JSPrompt() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement jsPromt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromt.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("I love UI automation");
        Thread.sleep(2000);
        alert.accept();

        WebElement message = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));//ATRIBUTE
        message.click();
        String actualMessage = BrowserUtils.getText(message);//this is webelement . so ia can not use browese utils
        String expectedmessage = "You entered: I love UI automation";
        Assert.assertEquals(actualMessage, expectedmessage);
        Thread.sleep(3000);


    }


}
