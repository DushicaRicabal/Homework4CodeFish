package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    //get attribute is a special method in Selenium
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement demoUsername= driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUsername.getText().trim());//John Doe//this will not work
        System.out.println(demoUsername.getAttribute("value"));
        System.out.println(demoUsername.getAttribute("placeholder"));

    }
}
