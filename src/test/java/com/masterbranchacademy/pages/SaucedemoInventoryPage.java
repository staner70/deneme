package com.masterbranchacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SaucedemoInventoryPage extends PageObject{

    @FindBy(className = "title")
    private WebElement product;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> allProductName;


    //******************* Metodlar ***********************

    public String getProductText(){
        return product.getText();
    }

    public List<WebElement> getAllProductNameText() {
        return allProductName;
    }

    public List<String> getAllProductText() {
        List<String> listText = new ArrayList<>();
        for (WebElement element : allProductName) {
            listText.add(element.getText());
        }
        return listText;
    }

/*    @FindBy(className = "title")
    private WebElement product;
    @FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item_name']")
    private List<WebElement> itemNames;
    //************** Methods ***************
    public String getProductText(){
        return getText(product);
    }
    public List<String> getItemNameText(){
        List<String> listText = new ArrayList<>();
        for (WebElement itemName : itemNames) {
            listText.add(itemName.getText());
        }
        return listText;
    }*/
}
