package SignUpTest;

import Pages.HomePage;
import Pages.SignUp;
import BaseSteps.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUptest extends TestBase {

    HomePage homePage;
    SignUp signUp;


    @Test
    public void userSignUp(){
        homePage = new HomePage(driver);
        homePage.clickOnSignUpButton();

        signUp = new SignUp(driver);

        // Generate unique username
        String uniqueUsername = "karma" + System.currentTimeMillis();
        signUp.enterUsername(uniqueUsername);
        signUp.enterPassword("karma123");

        signUp.clickSignUpButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Sign up successful.", "Sign-up success message does not match!");

        // Accept the alert
        driver.switchTo().alert().accept();
    }
}