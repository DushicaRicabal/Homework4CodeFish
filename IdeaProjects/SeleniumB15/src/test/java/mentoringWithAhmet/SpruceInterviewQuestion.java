package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class SpruceInterviewQuestion {
    @Test
    public void validateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com");
        WebElement ingredients = driver.findElement(By.xpath("//span[.='Ingredients']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(3000);
       // WebElement fishAndSeaFood= driver.findElement();



    }
}
