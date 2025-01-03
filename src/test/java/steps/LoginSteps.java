package steps;

import Scenarios.HomePage;
import Scenarios.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = new Hooks().getDriver();
    HomePage homePage;
    Login login;

    @Given("user opens Demoblaze homepage and click on Login button")
    public void user_opens_Demoblaze_homepage_and_click_on_Login_button(){
        homePage = new HomePage(driver);
        homePage.clickLoginButton();
    }

    @When("user enters valid user name and valid password and click on login button")
    public void user_enters_valid_user_name_and_valid_password_and_click_on_login_button(){
        login = new Login(driver);
        login.sendUsername("karma");
        login.sendpassword("karma123");
        login.clickonLogin();
    }

    @Then("user should see a welcome message with the valid username")
    public void user_should_see_a_welcome_message_with_the_valid_username() {
        // WebDriverWait to wait for the message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waiting for the welcome message to be visible
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nameofuser"), "Welcome karma"));

        // Fetching the actual message displayed
        String actualMessage = driver.findElement(By.id("nameofuser")).getText();

        // Verifying if the welcome message contains the username (e.g., "karma")
        Assert.assertTrue(actualMessage.contains("karma"),
                "Login failed. Expected: 'Welcome karma', but got: " + actualMessage);
    }


}
