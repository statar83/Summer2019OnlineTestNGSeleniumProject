package pages;

//according to page object model design
//we hae to create corresponded page class
//for each page of application
//login page= login page class
//every page class will store webelements and methods related to that page

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage extends BasePage {
    @FindBy(id = "prependedInput")//this line will initialize web element
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")//without findby, web element will be null
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(css="[class='alert alert-error']")
    public WebElement warningMessage;



    public LoginPage(){
        //mandatory to if you want to use @FindBy annotation
        //this keyword stands for LoginPage class
        //Driver.get() returns webdriver object
        PageFactory.initElements(Driver.get(), this);//this must be here to use @FindBy
    }
    /*
    reusable login method
    just call this method to login provide username and password as parameters
    @param userName
    @param passWord
     */
    public void login (String userName, String password){
        userNameInput.sendKeys(userName);
        //Keys.ENTER to replace login click
        passwordInput.sendKeys(password, Keys.ENTER);

    }



}