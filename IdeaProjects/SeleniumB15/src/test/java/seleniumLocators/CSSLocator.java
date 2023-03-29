package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSLocator {
    public static void main(String[] args) {
        System.setProperty("webriver.chrome.driver","chrome.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.etsy.com/");
//        WebElement searchBox= driver.findElement(new By.ByCssSelector("#global-enhancements-search-query"));
//        searchBox.sendKeys("Watch", Keys.ENTER);
//        System.out.println(driver.getTitle().trim());

        WebElement searchBoxWithClass=driver.findElement(new By.ByCssSelector(".wt-input"));
        searchBoxWithClass.sendKeys("Watch",Keys.ENTER);
        System.out.println(driver.getTitle().trim());



    }
}
