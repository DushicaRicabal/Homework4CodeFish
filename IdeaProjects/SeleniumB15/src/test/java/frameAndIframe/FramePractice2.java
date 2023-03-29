package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {
    @Test

    /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
    /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
    /*
    TASK 3:
    1-goback  to main page
    2-Click category
    3-VAlidate the header "category archives:SoftwareTesting"
     */
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton = driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]"));
        pavilionButton.click();
        BrowserUtils.switchByTitle(driver, "qvalidation");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance ";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='ht_toc_list']//li"));
        for (WebElement option : allOptions) {
            System.out.println(BrowserUtils.getText(option));
        }
//task 2 starts here
        BrowserUtils.switchByTitle(driver, "iframes");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframe1']"));
        driver.switchTo().frame(iframe);//Webelement
        WebElement category1 = driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives");

        WebElement headerArchive = driver.findElement(By.tagName("h1"));
        String actualHeaderArchive = BrowserUtils.getText(headerArchive);
        String expectedHeaderArchive = "";
        Assert.assertEquals(actualHeaderArchive, expectedHeaderArchive);
        Thread.sleep(2000);
        List<WebElement> allHeaders = driver.findElements(By.xpath("//h3"));
        for (WebElement hdr : allHeaders) {
            System.out.println(BrowserUtils.getText(hdr));
        }


        //TAsk 3starts here

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3Button =driver.findElement(By.xpath("//a[.='Category3']"));
        category3Button.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives");
        WebElement softwareTestingheader= driver.findElement(By.tagName("h1"));
        String actualSoftwareTestingHeader=BrowserUtils.getText(softwareTestingheader);
        String expectedSoftwareTestingHeader="";
        Assert.assertEquals(expectedSoftwareTestingHeader,actualSoftwareTestingHeader);

        WebElement headerT= driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));

    }


}
