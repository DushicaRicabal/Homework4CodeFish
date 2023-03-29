package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    //driver.get()
    //Driver.manage.windows.maximize()
    //driver.getTitle()
    //driver.getCurrentUrl()
    //driver.getPageSource()
    //driver.navigateTo()
    //driver.navigate.refresh()
    //driver.navigate.forward()
    //driver.navigate.back()
    //driver.close()
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");//ALWAYS ADD .EXE ON THE END OF CHROMEDRIVER.EXE
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().back();//google
        Thread.sleep(3000);
        driver.navigate().forward();//youtube
        Thread.sleep(3000);
        driver.navigate().refresh();//refresh the page
        Thread.sleep(3000);

        System.out.println(driver.getPageSource());//it will give you the html structure of page
        driver.close();
    }
}
