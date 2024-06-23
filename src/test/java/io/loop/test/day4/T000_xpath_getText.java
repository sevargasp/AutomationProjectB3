package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1 open Chrome
2 go to docuport
3 click on forgot password
4 validate url contains:reset password
5 validate-enter the email address associated with your account
6 enter forgotpassworddg1@gmail.com to email box
7 validate send button is displayed
8 validate cancel button is displayed
9 click send button
10 validate - We have sent you an email with a linkto reset your password. please check your email

 */
public class T000_xpath_getText {
    public static void main(String[] args) throws InterruptedException {
        //  1. open chrome
        //  2. go to docuport

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        // 3. click on forgot password

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        // 4. validate url contains: reset password
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL+" this is the url");
        if(actualURL.contains(DocuportConstants.RESET_PASSWORD)){
            System.out.println("Actual url matches expected one");
        } else {
            System.err.println("Actual url DOES NOT match expected one");
        }

        //5. validate - Enter the email address associated with yor account
        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        // 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);


        // 7. validate send button is displayed

        // 8. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));//normalize es un metodo especial cuando estan cerca los botones.
//        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));//this is another way //*[contains(text(),'Send')]
        WebElement sendButton = driver.findElement(By.xpath("//*[contains(text(),'Send')]"));
        if(cancelButton.isDisplayed()){
            System.out.println("Test pass - cancel is displayed");
        } else {
            System.out.println("Test fail - cancel is not displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("Test pass - send is displayed");
        } else {
            System.out.println("Test fail - send is not displayed");
        }

//9 click send button
        // 9. click send button

        sendButton.click();

        Thread.sleep(3000);
//sin el tiempo de espera la rta es no suchElement
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(5000);//tiempos de espera.
//el error despues del tiempo de espera fue SaleElementReferenceException
        // String actualMessage = successMessage.getText();

        // System.out.println("actualMessage = " + actualMessage);

        try{
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");//porque es un pop up
        }

//el test paso, pero la validacion no se detuvo.
    }

}


