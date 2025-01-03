package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Purchase {
    WebDriver driver;

    public Purchase(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By creditCardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[@onclick='purchaseOrder()']");
    private By successMessage = By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]");



    // Methods to perform purchase actions
    public void fillCheckoutDetails(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(creditCardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }
    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

    public boolean isPurchaseSuccessful() {
        WebElement messageElement = driver.findElement(successMessage);
        return messageElement.isDisplayed();
    }
}