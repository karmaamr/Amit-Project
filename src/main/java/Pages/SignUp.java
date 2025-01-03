package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {

    WebDriver driver;
    public SignUp(WebDriver driver){
        this.driver = driver;
    }

    //locators
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpButton = By.xpath("//button[@onclick='register()']");

// Actions
public void enterUsername(String username) {
    driver.findElement(usernameField).sendKeys(username);
}

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
}