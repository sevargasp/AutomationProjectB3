package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
navigate to amazon
maximize
navigate back
navigate forward
refresh
 */
public class NavigateToAmazon {
    public static void main(String[] args)throws InterruptedException {
        WebDriver driver= new ChromeDriver();//se crea el nuevo objeto.
        driver.get("https://www.amazon.com.au/");//esto es para abrir la nueva pagina.

        driver.navigate().back();
        driver.manage().window().fullscreen();//para maximizar la pantalla
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}
