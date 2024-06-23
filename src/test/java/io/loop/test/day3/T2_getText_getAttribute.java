package io.loop.test.day3;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
go to url: https://loopcamp.vercel.app/registration_form.html
verify header text expected:  Registration form
verify placeholder attribute value expected - "first name"
 */
public class T2_getText_getAttribute {
    /*
    go to url: https://loopcamp.vercel.app/registration_form.html
    verify header text expected:  Registration form
    verify placeholder attribute value expected - username
     */
    public static void main(String[] args) {


        // got to url
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/registration_form.html");

            WebElement headerForForm= driver.findElement(By.tagName("h2"));
        System.out.println(headerForForm.getText());
        String actualHeaderForForm=headerForForm.getText();
        if (actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)) {
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" + actualHeaderForForm +" => TEST PASSED");
        } else {
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT MATCH actual header: \"" + actualHeaderForForm+" => TEST FAILED");
        }

//crear un nuevo element
        WebElement firstNamePlaceholder=driver.findElement(By.name("firstname"));//se crea el primer elemento
        //es different get text a get attribute
        String actualPlaceholderForFirstname=firstNamePlaceholder.getAttribute("placeholder");//ESTE SE ROBA EL VALOR DEL PLACEHOLDER Y LO ALMACENE EN ESTE STRING.

        System.out.println("actualPlaceholderForUsername = " + actualPlaceholderForFirstname);
        //esto lo hace para testear actual result vs expected result
        if (actualPlaceholderForFirstname.equals(LoopCampConstants.EXPECTER_PLACEHOLDER_FIRSTNAME)) {//creo una constante para poderla comparar
        System.out.println("Expected placeholder matches with actual");
            System.out.println("TEST PASSED");
        }else {
            System.out.println("Expected placeholder DOES NOT match with actual");
            System.err.println("TEST FAILED");
        }

    }

}
