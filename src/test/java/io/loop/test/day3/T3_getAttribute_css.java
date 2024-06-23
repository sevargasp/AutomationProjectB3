package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *Go to docuport app
 * identifty docuport with css
 * get value of the attribute
 * validate if it is "Docuport"
 *TODO: locate:
 * username, password,
 * login: with CSS
 * TODO login to docuport
 *   login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in
 *
 *1HOMEWORK
 */
public class T3_getAttribute_css {
    public static void main(String[] args) {


        //    WebDriver driver=new ChromeDriver();
//go to URL
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");
//identify the logo with css

        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));
        //i need to get the docuportAttribute, pero no lo puedo tener por get text, porque es un atributo
        String docuport = logo.getAttribute("alt");//use el atributo para poderlo comparar con el valor del logo.
        System.out.println("docuport = " + docuport);

        if (DocuportConstants.LOGO_DOCUPORT.equals(docuport)) {
            System.out.println("Expected matches with actual");
            System.out.println("TEST PASS");
        } else {
            System.out.println("Expecter does NOT match with actual");
            System.out.println("TEST FAIL");}
//        driver.quit();
    }
}
