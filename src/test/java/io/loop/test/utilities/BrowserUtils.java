package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Sergio
     * Implements assertions
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        //to lowercase the parameters in order to avoid miss types
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
//get all window handles, switch one by one and each time check if the url matches expected url to Stop.
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {//aqui hace un forloop para atravezar
                break;
            }
        }
        //after stopping on expectedUrl, validate the title.
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * @param driver
     * @param targetTitle
     * @author Sergio
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {//este hace el switch sin guardar el windowhandle
        String origin = driver.getWindowHandle();//la almaceno al principio para devolverla al final en caso de que no funcione.
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);

            if (driver.getTitle().contains(targetTitle)) {
                return;//usa el return en un metodo void para salir prematuramente, pero no esta retornando nada.
            }
        }
        driver.switchTo().window(origin);//si falla y no lo contiene entonces viene al final de esta.
    }

}
