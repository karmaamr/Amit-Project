package CartTest;

import Pages.Cart;
import Pages.HomePage;
import Pages.Login;
import Pages.Purchase;
import BaseSteps.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Carttest extends TestBase {
    HomePage homePage;
    Login loginPage;
    Cart cartPage;
    Purchase purchasePage;

    @Test
    public void verifyCartContents() {
        homePage = new HomePage(driver);
        loginPage = homePage.goToLoginPage(); // Navigate to the Login page
        loginPage.enterUserName("karma");
        loginPage.enterPassword("karma123");
        loginPage.clickOnLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nameofuser"), "Welcome karma"));

        homePage.goToLaptopsCategory().addProduct1ToCart();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        homePage.gotohomepage();


        homePage.goToMonitorsCategory().addProduct2ToCart();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        cartPage = homePage.goToCartPage(); // Go to the cart page

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product1TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product1Title));
        WebElement product2TitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product2Title));
        WebElement product1PriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product1Price));
        WebElement product2PriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage.product2Price));

        // Retrieve product details from the Cart page
        String product1Title = product1TitleElement.getText();
        String product2Title = product2TitleElement.getText();
        int product1Price = Integer.parseInt(product1PriceElement.getText());
        int product2Price = Integer.parseInt(product2PriceElement.getText());

        // Assertions to verify cart contents

        Assert.assertEquals(product1Title, "Sony vaio i5", "Product 1 title mismatch in the cart.");
        Assert.assertEquals(product2Title, "Apple monitor 24", "Product 2 title mismatch in the cart.");
        Assert.assertEquals(product1Price, 790, "Product 1 price mismatch in the cart.");
        Assert.assertEquals(product2Price, 400, "Product 2 price mismatch in the cart.");

        int expectedTotal = cartPage.calculateExpectedTotal(product1Price, product2Price);
        int actualTotal = cartPage.getTotalAmount();
        Assert.assertEquals(actualTotal, expectedTotal, "Total amount mismatch in the cart.");
        System.out.println(actualTotal);


        purchasePage = cartPage.goToPurchase();
        purchasePage.fillCheckoutDetails("Karma Amr", "Egypt", "Cairo", "1234567812345678", "12", "2025");
        purchasePage.clickPurchase();

        Assert.assertTrue(purchasePage.isPurchaseSuccessful(), "Purchase success message not displayed.");
    }

    }