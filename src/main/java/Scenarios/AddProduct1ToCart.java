package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProduct1ToCart {
    WebDriver driver;

    public AddProduct1ToCart(WebDriver driver) {
        this.driver = driver;
    }
    private By product1 = By.linkText("Sony vaio i5");

    private By addToCart = By.linkText("Add to cart");

    public void addProduct1ToCart() {
        driver.findElement(product1).click();
        driver.findElement(addToCart).click();
    }

}
