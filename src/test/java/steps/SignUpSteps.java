package steps;

import Scenarios.HomePage;
import Scenarios.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpSteps {
      WebDriver driver = new Hooks().getDriver();
      HomePage homePage;
      SignUp signUp;
    String generatedUsername;

    @Given("user opens Demoblaze homepage and click on Sign Up button")
    public void user_opens_Demoblaze_homepage_and_click_on_Sign_Up_button() {
        homePage = new HomePage(driver);
        signUp = homePage.clickSignUpButton();
    }
    @When("user enters valid user name and valid password and click on Sign Up button")
    public void user_enters_valid_user_name_and_valid_password_and_click_on_Sign_Up_button() {
        generatedUsername = "karma" + System.currentTimeMillis(); // Generate unique username
        signUp.sendUsername(generatedUsername);
        signUp.sendpassword("karma123");
        signUp.clickonsignUp();
    }

    @Then("the Sign Up Successful message should be displayed")
    public void the_Sign_Up_Successful_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); // Wait until the alert is present

        String expectedMessage = "Sign up successful.";
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, expectedMessage, "Sign-up success message does not match!");
        driver.switchTo().alert().accept();
    }
}
