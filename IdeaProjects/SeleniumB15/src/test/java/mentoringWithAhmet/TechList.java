package mentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechList {
    /*
   1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Close the webpage.
Try your own logic and automate it without any help.
    */
    public static void main(String[] args) {
        System.setProperty("weddriver.chrome.driver", "chromedriver.exe");//1-STEP-Setting up automation
        WebDriver driver = new ChromeDriver();//CREATE OBJECT/2-STEP You need driver to make a connection between page
        driver.manage().window().maximize();//MAXIMIZE screen
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");//3-STEP:NAVIGATE TO WEBSITE
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Dusica");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Ricabal");
        WebElement gender = driver.findElement(By.id("sex-1"));
        gender.click();
        WebElement experience = driver.findElement(By.id("exp-4"));
        experience.click();
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("08/13/2022");
        WebElement automation = driver.findElement(By.id("profession-1"));
        if (automation.isDisplayed() && !automation.isSelected()) {
            automation.click();
            WebElement button = driver.findElement(By.className("btn-info"));
            button.click();
        }

        WebElement tool = driver.findElement(By.id("tool-2"));
        tool.click();
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("North America");
        WebElement button = driver.findElement(By.className("btn-info"));
        button.click();

    }
}
