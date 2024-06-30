package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*/*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */
public class T1_findElements {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        driver.manage().window().maximize();
        //ir a esa pagina
        driver.get("https://www.nba.com");
//para obtener un elemento
//        WebElement element = driver.findElement(By.tagName("a"));//this returns 5 links.//THIS WILL GIVE ME JUST ONE ELEMENT.

        //list of elements, it will store everyLink with that tagname.

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());//this show me how many elements there are.

        List<WebElement> nbsLinksXpath = driver.findElements(By.xpath("//a"));//con la S
        System.out.println("nbsLinksXpath.size() = " + nbsLinksXpath.size());
//get some iterations.

        for (WebElement nbaLink : nbaLinks) {
            //im getting each element
            if (!nbaLink.getText().equals("")) {//if the element has text go...
                System.out.println("nbaLink.getText() = " + nbaLink.getText());
// this is for...get all the links because the tag is href---->"a" is the tag "href" is the attribute
                System.out.println("nbaLink.getAttribute(\"href\") = " + nbaLink.getAttribute("href"));


            }

        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if (!nbaLinks.get(i).getText().equals("")) {//si no esta vacia vaya y ahga esto.
                System.out.println("nbaLinks.get(i).getText() = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getAttribute(\"href\") = " + nbaLinks.get(i).getAttribute("href"));

            }

        }

    }

}