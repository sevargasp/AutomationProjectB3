package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading1 {
    public LoopPracticeDynamicLoading1() {
        PageFactory.initElements(Driver.getDriver(), this);//we can call many times, this is the reason why this is public, to get access from anywhere.

    }
//these are the variables that I will use on my T1.//instance variables
    @FindBy(xpath = "//button[contains(.,'Start')]")
    public WebElement startButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id="username")
    public WebElement username;
    @FindBy(id="pwd")
    public WebElement password;

    @FindBy(xpath = "//button[contains(.,'Submit')]")
    public WebElement submitButton;

    @FindBy(id = "flash-messages")
    public WebElement errormessage;

    @FindBy(xpath = "//a[@href='dynamic_loading/1.html']" )
    public WebElement dynamicLoading1;

}

