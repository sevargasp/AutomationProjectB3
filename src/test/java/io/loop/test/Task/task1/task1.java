package io.loop.test.Task.task1;
/*
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) {
        //        WebDriver driver=WebDriverUtil.getDriver("chrome");//esto es crear un objeto llamando a un paquete utilities, y accediendo a mi clase webdriverUtil.

        WebDriver driver = new ChromeDriver();// esta es la otra manera de hacerlo. Aqui simplemente lo llame.


        //maximize the page
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");//para abrir una nueva pagina.


        //Identify the Gmail and click
        WebElement gmailLinkByLinkText = driver.findElement(By.linkText("Gmail"));//vaya al linktext y tome el Gmail.

        //click sobre el gmail.
        gmailLinkByLinkText.click();//click es un metodo.

        //4 verify tittle contains. debo almacenarlas en String.
        String expectedTitleGmail = "Gmail";
        String actualTitleGmail = driver.getTitle();//almaceno mi variable actual.
        if (actualTitleGmail.contains(expectedTitleGmail)) {//confirmo lo que esperaba.
            System.out.println("Actual title: " + actualTitleGmail + " ,matches expected title: " + expectedTitleGmail + " .=> TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitleGmail + " ,DOES NOT MATCH expected title: " + expectedTitleGmail + " .=> TEST FAIL");

        }
       driver.navigate().back();
        String actualTitleGoogle= driver.getTitle();
        String expectedTitleGoogle="Google";
        if (actualTitleGoogle.contains(expectedTitleGoogle)){
            System.out.println("Actual title: " + actualTitleGoogle + " ,matches expected title: " + expectedTitleGoogle + " .=> TEST PASS");
        } else {
            System.err.println("Actual title: " + actualTitleGoogle + " ,DOES NOT MATCH expected title: " + expectedTitleGoogle + " .=> TEST FAIL");
        }
        driver.quit();

    }
}

