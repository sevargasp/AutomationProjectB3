package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {//para usar chrome from the ready starts.

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();//create the object.
        options.addArguments("--Start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");

    }
}
