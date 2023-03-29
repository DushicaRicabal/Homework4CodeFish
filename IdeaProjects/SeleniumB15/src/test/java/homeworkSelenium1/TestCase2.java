package homeworkSelenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {
    /*
    Navigate to "https://demoqa.com/radio-button"
Click Yes radio button
Validate text  is : You have selected Yes
Click Impressive radio button
Validate text is : You have selected Impressive
TIPS: be careful about your xpath if you have any issue with
getting the text.
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        yesButton.click();//My click button is not working

        WebElement textYes =driver.findElement(By.id("//label[@for='yesRadio']"));
         if(textYes.isDisplayed()&& textYes.isSelected());
        System.out.println("You have selected Yes");


        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        WebElement textImpressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));


        if(textImpressive.isDisplayed()&&textImpressive.isSelected());
        System.out.println("You have selected Impressive");







    }
}
