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

public class Practice {

    @Test
    public void practiceAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        String actualAlertBoxMessage = BrowserUtils.getText(alertBox);
        String expectedAlertBoxMesasage = "I am an alert box!";
        Assert.assertEquals(actualAlertBoxMessage, expectedAlertBoxMesasage);
        Thread.sleep(3000);

        WebElement  confrimButton= driver.findElement(By.cssSelector("#confirmBox"));
        confrimButton.click();

        Alert alertd =driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedmessage = "Press a button!";
        Assert.assertEquals(actualMessage, expectedmessage);
        alert.dismiss();//It CLICKS CANCEL BUTTON
        Thread.sleep(3000);
        WebElement resultMessage= driver.findElement(By.cssSelector("#output"));
        String actualResultMessage=BrowserUtils.getText(resultMessage);
        String expectedResultMessage="You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualMessage,expectedResultMessage);
        //WebElement promptBox




    }

}
