package io.loop.test.day3;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
go to url: https://loopcamp.vercel.app/registration_form.html
verify header text expected:  Registration form
verify placeholder attribute value expected - username
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

        driver.quit();
    }

}
