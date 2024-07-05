package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/*
1- Open a chrome browser
2- Go to: https://loopcamp.vercel.app/iframe.html
3- Clear text from comment body
4- Type "Loop Academy" in comment body
5- Verify "Loop Academy" text is written in comment body
6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
 */
public class T2_iframe extends TestBase {
    @Test
    public void iframeTest() {
        driver.get("https://loopcamp.vercel.app/iframe.html");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); // with xpath
        //si estoy seguro que mi elemento esta ahi pero no lo puedo obtener, debo buscarlo por no iframe(No suchElementException)
//        driver.switchTo().frame(iframe);//de esta manera lo localizo.

//      driver.switchTo().frame(0);//si comento la linea inmediatamente de arriba estoy habilitado a usar esta. ey codigo switch to el indice 0 del iframe.
        driver.switchTo().frame("mce_0_ifr");// with the id directly of the Iframe
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));//voy y ejecuto la tarea adentro. en este caso limpiar.
        textBox.clear();
        textBox.sendKeys("Loop Academy");//validar que si pude escribir algo.


        assertEquals(textBox.getText(), "Loop Academy", "Actual is NOT matching with the expected");
//si imprimo o trato de buscar algo porfuera de html. esto me arrojara una exception.
        driver.switchTo().defaultContent();//sacame hacia normal html,

        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));//localizar otro webelement por fuera del iframe
        System.out.println("textBox = " + header.getText());


//        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame')]"));
//        System.out.println(header.getText());
//        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
//        System.out.println("textBox = " + textBox);


    }

    @Test
    public void nestedFrame(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        List<WebElement> iframes;
        iframes = driver.findElements(By.xpath("//frame"));//puedo ahcerlo con frame and iframe
        System.out.println("iframes.size() = " + iframes.size());
    //hay 5 pero se imprimen 2, porque no puede ir al interior de los otros.

    }
}
