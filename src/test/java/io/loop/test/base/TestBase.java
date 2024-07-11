package io.loop.test.base;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {//It was created as a parent class.(here we are inheriting its methods and variables.
    public WebDriver driver;//instanciada.
    @BeforeMethod//opening each method.
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver("chrome");//web driver> Chrome.
        driver.manage().window().maximize();
    }
    @AfterMethod//closing each method.
    public void tearDownMethod(){

        driver.quit();//this method kill the browser
//        driver.close();//just minimize it is similar, but you can see easily on mac.
    }

}
