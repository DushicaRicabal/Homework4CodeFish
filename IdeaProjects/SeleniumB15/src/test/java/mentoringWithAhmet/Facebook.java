package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook {

    /* REAL INTERVIEW QUESTION
1-Navigate to the website "https://www.facebook.com/"
2-Click Create Account Button
3-Fill all the boxes
4-Choose Custom Gender
5-Choose any pronoun you want from
6-Click Sign up button
7-In general facebook has a protection to automate create account  so once you
click sign up button if there is a message then validate it. If no, just close or quit

   PURPOSE:
       1-This task can come during the interview
       2-How to deal with dynamic elements

 */
    @Test
    public void creatingFacebook(){
        //SETTING UP AUTOMATION
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
 // coding procesing part
        WebElement createNewAccButton= driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
        createNewAccButton.click();

        WebElement firstname= driver.findElement(By.xpath("/input[@name='firstname']"));
        firstname.sendKeys("Jenny");

        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Mills");
        WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("jennymills@yahoo.com");

        WebElement password= driver.findElement(By.cssSelector("#password_step_input"));
        password.sendKeys("1234567");








    }
}
