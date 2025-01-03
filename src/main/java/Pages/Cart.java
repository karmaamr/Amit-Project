package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Cart {
    WebDriver driver;
    public Cart(WebDriver driver){
        this.driver = driver;
    }
    public By product1Title = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr[1]/td[2]");
    public By product2Title = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr[2]/td[2]");
    public By product1Price = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr[1]/td[3]");
    public By product2Price = By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr[2]/td[3]");
    public By totalAmount = By.id("totalp");
    private By placeOrderButton = By.xpath("//button[@class='btn btn-success']");

    // Method to retrieve the total amount
    public int getTotalAmount() {
        String totalText = driver.findElement(totalAmount).getText();
        return Integer.parseInt(totalText); // Assumes total is displayed as a number
    }

    // Method to calculate the expected total based on product prices
    public int calculateExpectedTotal(int product1Price, int product2Price) {
        return product1Price + product2Price;
    }

    public Purchase goToPurchase() {
        driver.findElement(placeOrderButton).click();
        return new Purchase(driver); // Returns the Purchase page object
    }

    // Actions
    public String getProduct1Title() {
        return driver.findElement(product1Title).getText();
    }
    public String getProduct2Title() {
        return driver.findElement(product2Title).getText();
    }

    public String getProduct1Price() {
        return driver.findElement(product1Price).getText();
    }

    public String getProduct2Price() {
        return driver.findElement(product2Price).getText();
    }

}