package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @Test
    public void hello(){


    }









    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
