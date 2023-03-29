package seleniumLocators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    //ID LOCATOR
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/dusic/Downloads/Techtorialhtml%20(1).html");

        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim();//TEchtorail Academy
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");


        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText().trim());


        //*****NAME LOCATOR*******
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Dusica");

        WebElement lastName =driver.findElement(By.name("lastName"));
        lastName.sendKeys("Ricabal");

        WebElement phone =driver.findElement(By.name("phone"));
        phone.sendKeys("7863407834");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("dusica.su@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("708 Scarbrough Cir ");

        WebElement  city =driver.findElement(By.name("city"));
        city.sendKeys("Hoffman Estates");

        WebElement state =driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
                postalCode.sendKeys("60169");
         Thread.sleep(3000);

         // ******CLASS LOCATOR**********
        WebElement checkboxesLabel=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed()&&!javaBox.isSelected()){

            javaBox.click();

            WebElement seleniumBox=driver.findElement((By.id("cond2")));
            if(seleniumBox.isDisplayed()&&!seleniumBox.isSelected()){
                seleniumBox.click();
            }
            WebElement testNG =driver.findElement(By.id("cond3"));
            if(testNG.isDisplayed()&&! testNG.isSelected()) {
                seleniumBox.click();
            }
            WebElement cucumber =driver.findElement(By.id("cond4"));
             if(cucumber.isDisplayed()&&!cucumber.isSelected()){
                 cucumber.click();
             }

             //**********TAG NAME LOCATOR ******
            WebElement version=driver.findElement(By.tagName("u"));
             String actualVersion=version.getText().trim();
             String expectedVersion="Use Java Version";
            if (actualVersion.equals(expectedVersion)) {
                System.out.println("Validation is passed");
            }else{
                System.out.println("Validation is failed");

            }





        }












    }
}
