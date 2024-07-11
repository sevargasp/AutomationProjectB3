package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

/*
1. Open a chrome browser
2. Go to : http://the-internet.herokuapp.com/windows
3. Assert: Title is “The Internet”
4. Click to: “Click Here” link
5. Switch to new Window.
6. Assert: Title is “New Window”
 */
public class T1_window extends TestBase {
    @Test
    public void test_window_handle() {
        driver.get("http://the-internet.herokuapp.com/windows");//this comes from TESTBASE
        
        assertEquals(driver.getTitle(), "The Internet", "Results are not matching");//para verificar en cual pagina esta
        System.out.println(driver.getWindowHandle() + ": This is window's unique ID");//esto me da el unique ID-Alphanumeric String
        
        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();//
        System.out.println("driver.getTitle() = " + driver.getTitle());//asi intente coger cosas de la nueva pagina, no voy a poder a menos que haga switch.
        
        //here i get the original window handle and assign it to String
        String originalWindow = driver.getWindowHandle();//alphanumeric code--first pawebpage

        //se crea un set para tener el nombre. here i get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        //here I loop throw and stay at the last window.
        for (String each : windowHandles) {
            System.out.println("windowHandle = " + each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            driver.switchTo().window(each);//esto cambia y cambia y solo para al final.

        }
        System.out.println("driver.getTitle() = " + driver.getTitle());//title to the new window.
        //Here I Switch to the original one.
        driver.switchTo().window(originalWindow);

        System.out.println("driver.getTitle() = " + driver.getTitle());//title the internet
    }

    @Test
    public void selenium4_window() {

        driver.get("http://the-internet.herokuapp.com/windows");//this comes from TESTBASE
        driver.switchTo().newWindow(WindowType.WINDOW);//esto es para abrir nueva ventana
//        driver.switchTo().newWindow(WindowType.WINDOW).get("aqui escribo una pagina nueva para tenerla de manera inmediata)
        driver.switchTo().newWindow(WindowType.TAB);//para abrir nueva pafina.
    }
}
