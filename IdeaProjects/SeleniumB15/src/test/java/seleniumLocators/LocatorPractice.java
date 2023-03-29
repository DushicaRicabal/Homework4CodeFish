package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {
        //1-step automation
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        //2-automation process
        WebElement firstName = driver.findElement(By.xpath("//input[@id'input-firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName =driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        email.sendKeys("Ahmet67899@gmail.com");
        WebElement phone =driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("7896445212");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("ahmet123654");
        WebElement checkPass =driver.findElement(By.xpath("//input[@id='input-lastname']"));
        checkPass.sendKeys("ahmet123654");
        WebElement policy = driver.findElement(By.xpath("//input[@'type=agree']"));
        policy.click();
        WebElement continueButton=driver.findElement(By.xpath("//input[@'value=Continue']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your account has been created";
        System.out.println(actualHeader.equals(expectedHeader)?"PASSED":"FAILED");





    }

}
