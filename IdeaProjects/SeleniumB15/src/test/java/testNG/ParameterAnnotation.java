package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("FirstName")
    @Test
    public void Test(String name){

        System.out.println(name);

    }
    @Parameters({"country", "city", "zipcode"})
@Test
    public void test2(String country,String city, String zipcode){

    System.out.println(city);
    System.out.println(country);
    System.out.println(zipcode);

}


}
