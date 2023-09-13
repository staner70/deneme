package com.masterbranchacademy.pages;

import com.masterbranchacademy.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject{

    @FindBy(id = "userName")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "userName-value")
    private WebElement userValue;

    @FindBy(id = "name")
    private WebElement errorMessage;



    //******************* Metodlar ***********************


    public void login(){
        username.sendKeys(ConfigReader.getProperties("username"));
        password.sendKeys(ConfigReader.getProperties("password"));
        loginButton.click();
    }

    public String getUserNameText(){
        return userValue.getText();
    }

    public void negativeLogin(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

    public String errorMessage(){
        return errorMessage.getText();
    }
}
