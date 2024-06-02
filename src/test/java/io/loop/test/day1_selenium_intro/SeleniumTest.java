package io.loop.test.day1_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    //This is for setting the web driver.
    public static void main(String[] args) throws InterruptedException {


        //create an instance of WebDriver
        WebDriver driver = new ChromeDriver();//driver is going to
        //maximize the window
//        driver.manage().window().maximize();
        driver.manage().window().fullscreen();//this is different, just work in some ones.
        //navigate to the web page
        driver.get("https://www.loopcamp.io");
        Thread.sleep(5000);//slowing down the pages.
        driver.navigate().to("https://www.etsy.com");

        //navigate back
        driver.navigate().back();

        //navigate forward
        driver.navigate().forward();

        //refresh
        driver.navigate().refresh();

        //quit close//will kill the driver it-self
//        driver.close();
        driver.quit();



    }
}