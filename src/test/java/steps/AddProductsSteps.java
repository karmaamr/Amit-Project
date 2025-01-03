package steps;

import Scenarios.AddProduct1ToCart;
import Scenarios.AddProduct2ToCart;
import Scenarios.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddProductsSteps {

    WebDriver driver = new Hooks().getDriver();
    HomePage homePage;
    AddProduct1ToCart addProduct1;
    AddProduct2ToCart addProduct2;

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        homePage = new HomePage(driver);
        // Assume the homepage is already loaded due to the hooks setup
    }

    @When("user navigates to Laptops category and adds Sony Vaio i5 to the cart")
    public void user_adds_sony_vaio_i5_to_cart() {
        homePage.goToLaptopsCategory();
        addProduct1 = new AddProduct1ToCart(driver);
        addProduct1.addProduct1ToCart();
    }

    @Then("the product \"Sony Vaio i5\" should be added to the cart successfully")
    public void validate_product1_added_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Product added", "Sony Vaio i5 was not added to the cart");
        alert.accept();
    }

    @When("user navigates to Monitors category and adds Apple Monitor 24 to the cart")
    public void user_adds_apple_monitor_24_to_cart() {
        homePage.goToMonitorsCategory();
        addProduct2 = new AddProduct2ToCart(driver);
        addProduct2.addProduct2ToCart();
    }

    @Then("the product \"Apple Monitor 24\" should be added to the cart successfully")
    public void validate_product2_added_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Product added", "Apple Monitor 24 was not added to the cart");
        alert.accept();
    }
}