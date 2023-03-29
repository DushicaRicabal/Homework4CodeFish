package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;

public class DreamCar {

    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */

    @Test
    public void ValidateHeadersOfTheCar (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement make= driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");

        WebElement model =driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement priceBox= driver.findElement(By.cssSelector("#make-model-max-price"));










      //  WebElement header=driver.findElement();
        ////BrowserUtils.selectBy();
        //String actualHeader = BrowserUtils.getText(header);
        String expectedHeader ="";
       // Assert.assertEquals(actualHeader,expectedHeader);

       // WebElement sorted =driver.findElement(By.ByCssSelector(""));




    }


}
