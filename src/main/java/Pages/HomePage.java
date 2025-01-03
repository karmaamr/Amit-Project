package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    //locators
    private By signUpButton = By.id("signin2");
    private By loginButton = By.id("login2");
    private By laptopButton = By.linkText("Laptops");
    private By HomeButton = By.xpath("//a[@href='index.html']");
    private By monitorsButton = By.linkText("Monitors");
    private By cartPage = By.id("cartur");





    //Actions

    //SignUp
    public void clickOnSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    //Login
    // Navigate to Login Page
    public Login goToLoginPage() {
        driver.findElement(loginButton).click();
        return new Login(driver);
    }
    //AddProduct1
    public AddProduct1ToCart goToLaptopsCategory() {
        driver.findElement(laptopButton).click();
        return new AddProduct1ToCart(driver);  // Navigate to AddProductsToCart after clicking Laptops
    }

    public void gotohomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(HomeButton));  // Wait for Home button to be clickable
        homeButtonElement.click();
    }

    //AddProduct2
    public AddProduct2ToCart goToMonitorsCategory() {
        driver.findElement(monitorsButton).click();
        return new AddProduct2ToCart(driver);  // Navigate to AddProductsToCart after clicking monitors
    }

    //CheckCart
    public Cart goToCartPage(){
        driver.findElement(cartPage).click();
        return new Cart(driver);
    }

}