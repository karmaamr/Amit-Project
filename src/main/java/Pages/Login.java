package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    public Login(WebDriver driver){
        this.driver = driver;
    }

    //locators
    private By userName = By.id("loginusername");
    private By password = By.id("loginpassword");
    private By loginButton = By.xpath("//button[@onclick='logIn()']");

//Actions
public void enterUserName(String username){
    driver.findElement(userName).sendKeys(username);
}
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickOnLogin(){
        driver.findElement(loginButton).click();
    }

}