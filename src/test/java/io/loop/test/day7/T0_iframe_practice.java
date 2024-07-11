package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
  go to https://loopcamp.vercel.app/nested-frames.html
  validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

   */
public class T0_iframe_practice extends TestBase {//this give us the WebDriver.

    @BeforeMethod
    public void times() {//waiting time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test

    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");//entro al frame, y me voy mas hacia adentro. si yo intento ir directamente al left one, sin entrar al top, eso me da NOSUCHELEMENTEXCEPTION

        driver.switchTo().frame(0);

//        driver.switchTo().frame("frame-left");

        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();

        Assert.assertEquals(actualLeft.trim(), "LEFT");
//todo:ending the tasks

    }


}
