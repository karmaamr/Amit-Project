package AddProductsToCart;

import Pages.AddProduct1ToCart;
import Pages.HomePage;
import BaseSteps.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Product1 extends TestBase {
    HomePage homePage;
    AddProduct1ToCart product1;

    @Test
    public void addProduct1ToCart(){
        homePage = new HomePage(driver);
        homePage.goToLaptopsCategory();

        product1 = new AddProduct1ToCart(driver);
        product1.addProduct1ToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Product added", "Product 1 was not added to the cart");
        alert.accept();
    }
}
