package mentoringWithKuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambadaTest {


    WebDriver driver;
    @BeforeMethod()
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VAlidateEmailAndName_TC_01(){
     WebElement clickOnTablPgnAndName= driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
     clickOnTablPgnAndName.click();
     WebElement selectMyRows = driver.findElement(By.cssSelector("select[id='maxRows']"));

        BrowserUtils.selectBy(selectMyRows,"Show ALL Rows","text");
        //we are storing our names in a list

        List<WebElement> allNames= driver.findElements(By.xpath("//tr//td[]2"));

        List<WebElement> allEmails=driver.findElements(By.xpath("//tr//td[3]"));

        for(int i = 0;i<allNames.size();i++){
            Map<String,String> map=new HashMap<>();
            map.put(allNames.get(i).getText(),allEmails.get(i).getText());
            System.out.println(map);

        }

        List <WebElement>allNumber=driver.findElements(By.xpath(""));



            };
        }



