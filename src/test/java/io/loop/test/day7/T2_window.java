package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

/*
   1. Create new test and make set ups
   2. Go to : https://www.amazon.com
   3. Copy paste the lines from below into your class
   4. Create a logic to switch to the tab where Etsy.com is open
   5. Assert: Title contains “Etsy”
   Lines to be pasted:
   ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
   ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
   ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
   These lines will simply open new tabs using something called JavascriptExecutor
   and get those pages. We will learn JavascriptExecutor later as well.
    */
public class T2_window extends TestBase {
    @Test
    public void windowHandleTest(){
        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

//        Set<String> windowHandles = driver.getWindowHandles();//porque retorna set.
//        for (String window : windowHandles) {
//            driver.switchTo().window(window);//se va a cada window(hace parte del foreach)
//            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
//            if (driver.getCurrentUrl().toLowerCase().contains("etsy")){//esto es para detenerse en el que yo quiero.
//
//                break;
//            }
//
//        }

//        BrowserUtils.switchWindowAndValidate(driver,"etsy.com","etsy");
        BrowserUtils.switchToWindow(driver, "Google");
    }


}
