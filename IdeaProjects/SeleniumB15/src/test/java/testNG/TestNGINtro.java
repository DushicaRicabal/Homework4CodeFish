package testNG;

import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class TestNGINtro {

    @Test(priority = 2, invocationCount = 20)//test anotation

    public void test1() {
        System.out.println("I a am test1");
    }

    @Test(priority = 1)

    public void test2() {
        System.out.println("I a am test2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("I a am test3");
    }

}
