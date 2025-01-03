package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    //locators
    private By SignUp = By.id("signin2");
    private By loginButton = By.id("login2");

    private By laptopButton = By.linkText("Laptops");
    private By HomeButton = By.xpath("//a[@href='index.html']");
    private By monitorsButton = By.linkText("Monitors");
    private By cartPage = By.id("cartur");

    //Actions

    public void openHomePage() {
        driver.get("https://www.demoblaze.com/");
    }

    public SignUp clickSignUpButton() {
        driver.findElement(SignUp).click();
        return new SignUp(driver);
    }

    public Login clickLoginButton() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }

    public void goToLaptopsCategory() {
        driver.findElement(laptopButton).click();
    }

    public void goToMonitorsCategory() {
        driver.findElement(monitorsButton).click();
    }

    public Cart goToCartPage(){
        driver.findElement(cartPage).click();
        return new Cart(driver);
    }
}


