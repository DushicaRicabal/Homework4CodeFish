package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MojaVezbaLocatorXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();

        WebElement elementalSelenium = driver.findElement(By.xpath(""));

    }
}
