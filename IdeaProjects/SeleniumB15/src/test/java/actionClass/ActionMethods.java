package actionClass;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

    @Test//contexclick means right click
    public void ContexClick(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("");



    }

   @Test
    public void ContextClickPractice(){

       WebDriverManager.chromedriver().setup();
       WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

       WebElement rightCLickMeButton=driver.findElement(By.xpath(""));
       Actions actions=new Actions(driver);
       actions.contextClick(rightCLickMeButton).perform();


   }

   @Test
    public void doubleClick(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

       WebElement doubleCLickMeButton=driver.findElement(By.xpath(""));
       Actions actions=new Actions(driver);
       actions.doubleClick(doubleCLickMeButton).perform();
   }
}
