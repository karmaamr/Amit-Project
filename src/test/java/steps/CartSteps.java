package steps;

import Scenarios.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartSteps {
    WebDriver driver = new Hooks().getDriver();
    HomePage homePage;
    Login loginPage;
    AddProduct1ToCart addProduct1ToCart;
    AddProduct2ToCart addProduct2ToCart;
    Cart cartPage;
    Purchase purchasePage;

    @Given("the user logs in with username karma and password karma123")
    public void the_user_logs_in_with_username_and_password() {
        try {
            homePage = new HomePage(driver);
            loginPage = homePage.clickLoginButton();
            loginPage.sendUsername("karma");
            loginPage.sendpassword("karma123");
            loginPage.clickonLogin();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nameofuser"), "Welcome karma"));

            System.out.println("Login successful.");
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            throw e; // Re-throw the exception to fail the test if login fails
        }
    }

    @When("the user adds the first product to the cart")
    public void the_user_adds_the_first_product_to_the_cart() {
        try {
            homePage.goToLaptopsCategory();

            addProduct1ToCart = new AddProduct1ToCart(driver);

            addProduct1ToCart.addProduct1ToCart();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            System.out.println("First product added to cart.");
        } catch (Exception e) {
            System.err.println("Error adding the first product to the cart: " + e.getMessage());
            throw e;
        }
    }

    @When("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        try {
            homePage.openHomePage();
            System.out.println("Navigated to homepage.");
        } catch (Exception e) {
            System.err.println("Error navigating to the homepage: " + e.getMessage());
            throw e;
        }
    }

    @When("the user adds the second product to the cart")
    public void the_user_adds_the_second_product_to_the_cart() {
        try {
            homePage.goToMonitorsCategory();
            addProduct2ToCart = new AddProduct2ToCart(driver);

            addProduct2ToCart.addProduct2ToCart();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            System.out.println("Second product added to cart.");
        } catch (Exception e) {
            System.err.println("Error adding the second product to the cart: " + e.getMessage());
            throw e;
        }
    }

    @Then("the cart should contain the correct products with prices")
    public void the_cart_should_contain_the_correct_products_with_prices() {
        try {
            cartPage = homePage.goToCartPage();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement product1TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product1Title));
            WebElement product2TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product2Title));
            WebElement product1PriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product1Price));
            WebElement product2PriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product2Price));

            String product1Title = product1TitleElement.getText();
            String product2Title = product2TitleElement.getText();
            int product1Price = Integer.parseInt(product1PriceElement.getText());
            int product2Price = Integer.parseInt(product2PriceElement.getText());

            Assert.assertEquals("Sony vaio i5", product1Title);
            Assert.assertEquals("Apple monitor 24", product2Title);
            Assert.assertEquals(790, product1Price);
            Assert.assertEquals(400, product2Price);

            int expectedTotal = cartPage.calculateExpectedTotal(product1Price, product2Price);
            int actualTotal = cartPage.getTotalAmount();
            Assert.assertEquals(expectedTotal, actualTotal);

            System.out.println("Cart contents are correct.");
        } catch (Exception e) {
            System.err.println("Error verifying cart contents: " + e.getMessage());
            throw e;
        }
    }

    @Then("the user completes the purchase with name {string}, country {string}, city {string}, card {string}, month {string}, and year {string}")
    public void the_user_completes_the_purchase_with_name_country_city_card_month_and_year(String name, String country, String city, String card, String month, String year) {
        try {
            purchasePage = cartPage.goToPurchase();
            purchasePage.fillCheckoutDetails(name, country, city, card, month, year);
            purchasePage.clickPurchase();

            Assert.assertTrue(purchasePage.isPurchaseSuccessful());

            System.out.println("Purchase completed successfully.");
        } catch (Exception e) {
            System.err.println("Error completing the purchase: " + e.getMessage());
            throw e;
        }
    }
}
