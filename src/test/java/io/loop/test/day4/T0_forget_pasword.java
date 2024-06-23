package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * verify forget password
 * identify reset password heading using css and go from parent child
 * */
public class T0_forget_pasword {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        //go to the url
        driver.get("https://beta.docuport.app");

        //forget password link
        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));

        //WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));//esta es una forma de hacerlo.
        forgetPasswordLink.click();

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));//va desde el padre hasta el hijo.
        System.out.println("forgetPasswordHeading.getText() = " + forgetPasswordHeading.getText());
    }
}
