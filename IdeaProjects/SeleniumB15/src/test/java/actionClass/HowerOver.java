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

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.*;

public class HowerOver {
    @Test
    public void validateNamesFromPicture() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);
        for (int i = 0; i < names.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform();//you are hover overing the pictures.MOVING MOUSE
            actualNames.add((BrowserUtils.getText(names.get(i))));//you are storing the names inside the list for validation
        }
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);
    }
    @Test
    public void practiceMoveToElement() throws InterruptedException {
        /*
        1-Navigate to website
        2-If you have cookies popup then click it
        3-Hover over each pictures and get the names and store it in List<STring> allNames
        4-Hver over each picture and get the proces and store in List<String> allPrices
        5-Put them all of the names as key of map, and all of the prices as value of map
        6-Orin out map

        Clues: You can  use regular(indexing) loop for adding the name and prices into the list
        CLUES:You can use same loop for putting into map
        CLUES: to bel able to get names and prices you need to hove over fist
        CLUES:DO not forget perform
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(3000);
        WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Accept Cookies')]"));
        cookiesButton.click();

        List<WebElement> allPictures = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String, String> products = new HashMap<>();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200);///It will move by amount it will scrooll page
        for (int i = 0; i < allNames.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(allPictures.get(i)).perform();
            products.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allPrices.get(i)));
        }

        System.out.println(products);


    }
}
