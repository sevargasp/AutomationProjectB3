package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

/*
 * go to docuport
 * enter username
 * do NOT enter password
 * click on login button
 * verify error message - please enter password
 */
public class T1_locators_getText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/login");
        WebElement userName = driver.findElement(By.id("input-14"));

        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);//aqui estoy importando desde otro paquete a otra clase

        WebElement loginButtom = driver.findElement(By.className("v-btn__content"));
        loginButtom.click();

        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        System.out.println(errorMessage.getText());

        String actualErrorMessage = errorMessage.getText();
        if (actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("Expected error messages: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " +
                    actualErrorMessage + " => TEST PASS");
        } else {
            System.err.println("Expected error messages: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ",  DOES NOT MATCH actual error message: " +
                    actualErrorMessage+ " => TEST FAIL");
        }
        driver.quit();

    }
}
