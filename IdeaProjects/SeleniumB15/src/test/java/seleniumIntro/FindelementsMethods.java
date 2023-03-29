package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindelementsMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/dusic/Downloads/Techtorialhtml%20(1).html");


        List<WebElement>allBoxex=driver.findElements(By.xpath("//input[@type='checkbox']"));//4 elements
         for(WebElement box:allBoxex){
             if(box.isDisplayed()&&!box.isSelected()&& box.isEnabled()){
                 box.click();
             }
         }

    }
}
