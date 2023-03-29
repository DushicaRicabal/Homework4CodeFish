package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//li"));

        int counter1=0;
        for(WebElement link : allLinks){

            System.out.println(link.getText().trim());
            counter1++;

        }
        System.out.println(counter1);
        System.out.println(allLinks.size());
        //print out the words letter more then equal 12
        int counter2=0;
        for(WebElement link : allLinks){
            if(link.getText().trim().length()>=12){
                System.out.println(link.getText().trim());
                counter2++;
            }
        }

    }}
