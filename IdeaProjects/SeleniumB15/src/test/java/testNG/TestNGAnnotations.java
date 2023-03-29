package testNG;

import org.testng.annotations.*;

public class TestNGAnnotations {


    @BeforeSuite//IT WILL RUN BEFORE EVERYTHING --CLEAR COOKIES AND CASHES
    public void beforeSuite () {
        System.out.println("I am Before Suit Annotation");

    }

    @BeforeTest//it is good to clear cookies and cashes
    public void BeforeTest() {
        System.out.println("I am Before Test Anotation");
    }

    @BeforeClass//IT WORKS ONLY ONE TIME / IT RUNS BEFORE EVERY CLASS AND PEOPLE USE TO LAUNCH THEIR BROWSER.
    // They using  driver=DriverHelper.getDriver()
    public void beforeClass() {
        System.out.println("I am Before Class Annotation");
    }

    @BeforeMethod//IT RUNS BEFORE EVERy TEST ANNOTATION AND IT IS GOD FOR SETTING UP YOUR AUTOMATION//TEST BASE CLASS
    public void beforeMethod() {
        System.out.println("I am before Method Anotation");
    }

    @Test//IT EXECUTES THE CODE
    public void test() {
        System.out.println("I am Test Annotation");
    }

    @Test
    public void test1() {

        System.out.println("I am second TestAnnotaion");
    }

    @AfterMethod//THIS RUNS AFTER EVERY TEST ANNOTATION AND IT IS GOOD TO USE FOR SCREENSHOT AND QUIT YOUR DRIVER
    public void afterMethod() {
        System.out.println("I am AfterMethod Anotation");
    }

    @AfterClass
    public void afterClass() {

        System.out.println("I am After Class Annotation");
    }

    @AfterTest

    public void AfterTest() {
        System.out.println(" I am AfterTest Annotaiton");
    }

    @AfterSuite
    public void AfterSuite() {

        System.out.println("I am After Suite Annotation ");
    }

}
