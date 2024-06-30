package io.loop.test.day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_intro {
    //test Ng does not have main metho.
    //para usarlo necesito testNG libraries--->se obtienen desde las dependencias.
    @Test(priority = 1)
    public void test2() {
        System.out.println("Test 1 is running");

    }
    @Test
    public void test1(){
        System.out.println("Test 2 is running");
        String actual = "Feyruz";
        String expected = "Nadir";
        Assert.assertEquals(actual,expected,"Message from actual, it will show if only test fails");//me permite compararlos y me arroja el error.
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before Method is running");
    }
@AfterTest
    public void tearDownMethod(){
    System.out.println("After method is running");
}
@BeforeClass
    public void setUp(){
    System.out.println("Before class is running");
}

@AfterClass
    public void tearDown(){
    System.out.println("After class is running");
}

}
