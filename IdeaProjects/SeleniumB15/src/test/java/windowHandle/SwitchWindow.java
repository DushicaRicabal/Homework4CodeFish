package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere= driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        String mainPageId =driver.getWindowHandle();//pageID of the class
        System.out.println(mainPageId);
        Set<String> allPagesIds=driver.getWindowHandles();
        System.out.println(allPagesIds);
       //this is used only for 2 tabs/ windows
        for(String id:allPagesIds){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void practice1(){
        /*
        TASK:
  1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
  2-Click Open New Tab under Button2
  3-Get the title of the newTab and validate"
  4-Get the header of the newTab and validate "AlertsDemo"
  5-Click click me button
  6-Quit the tabs
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement openNewTabbutton= driver.findElement(By.cssSelector("#newTabBtn"));
        openNewTabbutton.click();

        String maianPageId=driver.getWindowHandle();
        Set<String>allPagesId=driver.getWindowHandles();
        for(String id :allPagesId){
            if(!id.equals(maianPageId)){
                driver.switchTo().window(id);
            }
        }


        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);

        //WebElement title = driver.getTitle();
      //  String actualTitle=BrowserUtils.get(title);
        String expectedTitle="";
        //Assert.assertEquals(actualTitle,expectedTitle);

        WebElement clickMe=driver.findElement(By.cssSelector(""));
        clickMe.click();







    }

}
