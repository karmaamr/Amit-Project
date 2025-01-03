package Scenarios;

import io.cucumber.java.ro.Si;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignUp {

    WebDriver driver;

    public SignUp(WebDriver driver){
       this.driver = driver;
    }

    //locators
    private By Username = By.id("sign-username");
    private By Password = By.id("sign-password");
    private By SignUpButton = By.xpath("//button[@onclick='register()']");

    //Actions
    public void sendUsername(String username){
        driver.findElement(Username).sendKeys(username);
    }

    public void sendpassword(String password){

        driver.findElement(Password).sendKeys(password);
    }


    public void clickonsignUp(){
        driver.findElement(SignUpButton).click();
    }
}
