package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        System.setProperty("weddriver.chrome.driver","chromedriver.exe");
        WebDriver driver= new ChromeDriver();//CREATE OBJECT
        driver.manage().window().maximize();//MAXIMIZE
        driver.get("https://www.amazon.com/");//NAVIGATE TO WEBSITE
        System.out.println(driver.getTitle());//GET THE TITLE
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if(actualTitle.equals(expectedTitle)){//VALIDATION HERE
            System.out.println("your test is passed");
        }else{
            System.out.println("your test is failed");
        }
        //driver.getCurrentUrl()
        driver.get("https://www.techtorialacademy.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        String actualTitleTechtorial=driver.getTitle();
        String expectedTitleTechtorial="Home";

        if (actualTitle.equals(expectedUrl)) {
            System.out.println("Url is passed");
        }else{
            System.out.println("Url is failed");
        }
        if (actualTitleTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("Title is passed");

        }else{
            System.out.println("Title is failed ");
        }
        driver.close();
    }
}
