package io.loop.test.Task.task2;
/*1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2_mercadoLibre {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();//este es un web driver de tipo chrome driver.

        driver.get("https://mercadolibre.com//");//logro ingresar a la pagina.
        driver.manage().window().maximize();

        //locate the element
        WebElement searchBoxToWrite= driver.findElement(By.id("CO"));
        searchBoxToWrite.click();
        String expectedTitle="Mercado Libre Colombia - Envíos Gratis en el día";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + " \n,matches expected title: " + expectedTitle + " .\n=> TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitle + " \n,DOES NOT MATCH expected title: " + expectedTitle + "\n .=> TEST FAIL");
        }
        driver.quit();


    }
}
