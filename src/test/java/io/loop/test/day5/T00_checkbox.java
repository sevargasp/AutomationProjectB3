package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T00_checkbox {
    public static void main(String[] args) {
           /*
        1. Go to http://the-internet.herokuapp.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.

//confirmar que se selecciono una y otra no.
         */
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        //I open the link
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkBox1 = driver.findElement(By.xpath("//input/following-sibling::text()[contains(.,'checkbox 1')]/preceding-sibling::input"));///lo busco con los hermanos y el punto significa text.


        // 2. Confirm checkbox #1 is NOT selected by default
//reviso si esta seleccionada o no.
        if(!checkBox1.isSelected()){
            System.out.println("Checkbox is not selected");
        } else {
            System.out.println("Checkbox is selected");
        }

        checkBox1.click();//le doy click para seleccionarla

        if(checkBox1.isSelected()){
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }
        //vuevlo y reviso que si este seleccionada.
        //--- "//input/following-sibling::text()[contains(.,'checkbox 2')]/preceding-sibling::br/following-sibling::input"
    }
}

