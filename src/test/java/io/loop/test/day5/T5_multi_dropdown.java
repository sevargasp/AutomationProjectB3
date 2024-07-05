package io.loop.test.day5;

  /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. Select all the options from multiple select dropdown.
    4. Print out all selected values.
    5. Deselect all values.
     */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T5_multi_dropdown {
    WebDriver driver;//instance variables

    @BeforeClass
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
//driver.close

    }

    @Test
    public void multiSelect() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));//se escoge el de multiples sellecciones.
        // isMultiple - allows us to test if dropdown is a multi select one
        Assert.assertTrue(dropdown.isMultiple(), "Dropdown is not multi select");
//there are 3 ways to do it.
//        dropdown.selectByIndex(0);
//        Thread.sleep(3000);//esto me da el tiempo para ver lo que estamos haciendo.
//
//        dropdown.selectByValue("saab");
//        Thread.sleep(3000);
//
//        dropdown.selectByVisibleText("Opel");
//        Thread.sleep(3000);
//
//        dropdown.selectByIndex(3);
////tod@ lo anterior me deja hacerlo 1 por 1.
       //DEBO CREAR LA LISTA PARA ALMACENARLO.
        List<WebElement> options;
        options = dropdown.getOptions();//with regular for each loop

//        for (WebElement option : options) {
//            option.click();//esto es para seleccionar,
//            System.out.println(option.getText());//esto los selecciona todos rapidamente.
//
//        }
//THIS IS WITH LAMBDA EXPRESION.
        options.forEach(option -> {
            option.click();
            System.out.println(option.getText());

        });

    }


}

