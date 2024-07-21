package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//storing my elements
// and create a constructor.
public class LoopPracticeDragDropPage {

    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(), this);//prioritizing instance variables.

    }

    @FindBy (xpath = "//div[@id='draggable']")
    public WebElement smallCircle;

    @FindBy (id = "droptarget")
    public WebElement bigCircle;


}
//se creo ese archivo primero.
