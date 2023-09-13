package com.masterbranchacademy.pages;

import com.masterbranchacademy.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoLoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;


    //******************* Metodlar ***********************

    public boolean isLoginBtnDisplayed(){
        return loginButton.isDisplayed();
    }

    public void login(){
        username.sendKeys(ConfigReader.getProperties("username"));
        password.sendKeys(ConfigReader.getProperties("password"));
        loginButton.click();
    }

    public void loginManipulate(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }


}
