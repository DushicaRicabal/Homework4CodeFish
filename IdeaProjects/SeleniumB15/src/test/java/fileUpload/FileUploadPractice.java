package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\dusic\\OneDrive\\Desktop\\USA.png");

        WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-submit"));
        fileUploadButton.click();
        WebElement attachemnt = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualMessage = BrowserUtils.getText(attachemnt);
        String expectedMessage = "USA.png";

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void practice2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFileButton.sendKeys("C:\\Users\\dusic\\OneDrive\\Desktop\\USA.png");

        WebElement text = driver.findElement(By.xpath("//div[@id='uploadmode3']//following-sibling::span//b"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "Select file to send(max 196.45 MB)";

        WebElement box = driver.findElement(By.xpath("//a[.='terms of service']//preceding-sibling::input"));
        box.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

        WebElement mesage = driver.findElement(By.tagName("//h3"));
        String actualMessage = BrowserUtils.getText(mesage);
        String expectedMessage = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
