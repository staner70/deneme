package com.masterbranchacademy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;

import java.util.ArrayList;
import java.util.List;

public class ToDoListPage extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(xpath = "//*[text()='TO DO LIST']")
    private WebElement todoList;

    @FindBy(id = "to-do-list")
    private WebElement todoListid;

    @FindBy(tagName = "input")
    public WebElement addNewTodo;

    @FindBy(xpath = "//ul/li")
    private List<WebElement> listToDo;


    // Metodlar
    public String getTitleText(){
        return title.getText();
    }

    public WebElement getElementTodoList(){
        return todoList;
    }

    public void clickTodoList(){
        todoListid.click();
    }

/*    public void sendTextToinput(String text){
        Actions actions = new Actions(driver);
        inputTag.sendKeys(text);
    }*/
    public void sendNewTodo(String todoList){
        addNewTodo.sendKeys(todoList, Keys.ENTER);
    }

    public List<String> getListText(){
        List<String> todoList = new ArrayList<>();
        for (WebElement element : listToDo) {
            todoList.add(element.getText());
        }
        return todoList;
    }
}
