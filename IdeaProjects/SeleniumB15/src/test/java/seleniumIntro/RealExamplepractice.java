package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class RealExamplepractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)
    public static void main(String[] args) {
        //1.Set up your automation
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //2-Create your driver Object
        WebDriver driver = new ChromeDriver();
        //3-Go to the website and mazimize your screen
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        //4-Following the steps from TAsk

        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle().trim();// comes from system
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";//comes// from me

        System.out.println(actualTitle);//Comes from me
        System.out.println(actualTitle.equals(expectedTitle)?"Passed":"Failed");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl)?"URL PASSED":"URL FAILED");
driver.close();











        if(actualTitle.equals(expectedTitle)){
            System.out.println("your test is passed");
        }else{
            System.out.println("your test is failed");
        }

    }
}
