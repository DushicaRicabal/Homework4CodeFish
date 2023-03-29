package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    //SELECT CLASS IS ALL ABOUT DROP DOWN
    // Drop box MUST HAVE "SELECT" TAG NAME!
    @Test
    public void practiceSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");


        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));// a tag and text
        dropDown.click();

        //location of  the box
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(optionBox);//provide location of the boxinside of Select Object
        // CREATING SELECT OBJECT SO WE CAN USE OTHER CLASSES VARIABLES
        System.out.println(options.getFirstSelectedOption().getText().trim()); //will give what is by default chosen

        options.selectByValue("1");//will give us methods byIndex byValue ByIndex//provide Value
        Thread.sleep(3000);
        options.deselectByVisibleText("Option 2");//Provide Visible text
        Thread.sleep(3000);
        options.deselectByIndex(1);
        Thread.sleep(3000);

        //METHOD TO VALIDATE ALL OPTIONS LIST OF WEBELEMENT

        List<WebElement> allTheOptions = options.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2");
        for (int i=0;i<allTheOptions.size();i++){
            Assert.assertEquals(allTheOptions.get(i).getText().trim(),expectedOptions.get(i));
        }


    }


}
