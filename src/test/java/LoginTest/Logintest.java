package LoginTest;

import Pages.HomePage;
import Pages.Login;
import BaseSteps.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class Logintest extends TestBase {
    HomePage homePage;
    Login login;
    @Test
    public void userLogin(){
        homePage = new HomePage(driver);
        homePage.goToLoginPage();

        login = new Login(driver);
        login.enterUserName("karma");
        login.enterPassword("karma123");
        login.clickOnLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nameofuser"), "Welcome karma"));

        String welcomeMessage = driver.findElement(By.id("nameofuser")).getText();
        Assert.assertTrue(welcomeMessage.contains("Welcome karma"), "User login was not successful.");
    }
}