package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class SelectPractice {
    @Test
    public void validatefirstOptionAndprintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/dusic/Downloads/Techtorialhtml%20(1).html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);
        String actualFirstOption = country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "UNITED STATES ";
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
        List<WebElement> allTheCountryOptions = country.getOptions();

        int counter = 0;
        for (WebElement countryName : allTheCountryOptions) {
            System.out.println(countryName.getText().trim());
            counter++;
        }
        System.out.println(counter);

        country.deselectByVisibleText("ANTARCTICA ");
        Thread.sleep(3000);
        country.selectByValue("251");
        Thread.sleep(3000);
        country.deselectByIndex(200);


    }

    @Test
    public void validateOrderMessage() {
                /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passangersBox = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passangerOption = new Select(passangersBox);
        passangerOption.selectByVisibleText("4");

        WebElement departingBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingFrom = new Select(departingBox);
        departingFrom.selectByValue("London");
        String actualFirstOption = departingFrom.getFirstSelectedOption().getText().trim();
        String expecterdFirstOption = "Acapulco";
        Assert.assertEquals(actualFirstOption, expecterdFirstOption);
        departingFrom.selectByVisibleText("Paris");

        WebElement fromMonthBox = driver.findElement(By.xpath(""));


        WebElement onBox = driver.findElement(By.xpath(""));


        WebElement arrivingInBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingIn = new Select(arrivingInBox);
        arrivingIn.selectByVisibleText("New York");

        WebElement returningBox = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select returning = new Select(returningBox);
        // returning.selectByValue();

    }


    @Test
    public void multiSelect() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");


        WebElement countryBox = driver.findElement(By.cssSelector(".select"));

        Select country = new Select(countryBox);
        country.selectByVisibleText("One");
        country.selectByValue("3");
        country.deselectByIndex(4);

        country.deselectByValue("1");
        country.deselectAll();


    }

    @Test
    public void shortCutSelectClass() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement pessengerbox = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select pessenger = new Select(pessengerbox);
        pessenger.selectByIndex(3);

        WebElement DepartingBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select DepartingCity = new Select(DepartingBox);
        DepartingCity.getFirstSelectedOption();
        Assert.assertEquals(DepartingCity.getFirstSelectedOption().getText().trim(), "Acapulco");
        DepartingCity.selectByVisibleText("Paris");
        WebElement fromMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonth = new Select(fromMonthBox);
        fromMonth.selectByValue("8");
        WebElement fromDayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDay = new Select(fromDayBox);
        fromDay.selectByIndex(14);
        WebElement toPortBox = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPort = new Select(toPortBox);

        toPort.selectByVisibleText("San Francisco");
        WebElement toMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonth = new Select(toMonthBox);
        toMonth.selectByValue("12");
        //BrowserUtils.selectBy((toMonthBox,"12","value"));
        WebElement toDayBox = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay = new Select(toDayBox);
        toDay.selectByIndex(14);
        //WebElement serviceClass= driver.findElement(By.xpath("//input[@value='First']"));
        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        Thread.sleep(3000);
        WebElement airLine = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airLineBox = new Select(airLine);
        List<WebElement> airLineSelect = airLineBox.getOptions();
        List<String> expAirLine = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < airLineSelect.size(); i++) {
            Assert.assertEquals(airLineSelect.get(i).getText().trim(), expAirLine.get(i));
        }
        airLineBox.selectByVisibleText("Unified Airlines");
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
       // String actualMessage = message.getText().trim();

     //   String actualMessage=BrowserUtils.getText(message);
        String expectedMessage = "After flight finder - No Seats Avaialble";

       // Assert.assertEquals(actualMessage, expectedMessage);

    }

    public static String getText(WebElement element){
        return element.getText().trim();
    }
}
