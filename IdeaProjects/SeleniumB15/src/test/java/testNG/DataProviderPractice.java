package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    @DataProvider(name="couples")

    public Object[][] getData(){
        return  new Object[][]{
                {"Ahmet","Ayse"},
                {"Mr.M","Mrs.M"},
                {"Dusica","Anatoly"},
                {"Ana","Mia"},
                {"Mr T","Ms R"}


        };
    }
    @Test(dataProvider = "couples")
    public void test1(String firstCouple,String secondCouple){
        System.out.println(firstCouple+secondCouple);
    }
//    @Test
//    public void test2(){
//        System.out.println("Mr.M"+"Mrs.M");
//    }
//
//    @Test
//    public void test3(){
//        System.out.println("Dusica"+"Anatoly");
//
//    }
//
//    @Test
//    public  void test4(){
//        System.out.println("Ana"+"Mia");
//    }
//    @Test
//    public void test5(){
//        System.out.println("Mr T"+ "Ms R");
//    }
}
