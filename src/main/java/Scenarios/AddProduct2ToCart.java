package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProduct2ToCart {
    WebDriver driver;

    public AddProduct2ToCart(WebDriver driver) {
        this.driver = driver;
    }
    private By product2 = By.linkText("Apple monitor 24");

    private By addToCart = By.linkText("Add to cart");

    public void addProduct2ToCart() {
        driver.findElement(product2).click();
        driver.findElement(addToCart).click();
    }
}
