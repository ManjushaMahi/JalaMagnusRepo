package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {
    WebDriver driver;

    @Given("I am on the Magnus forgot password page")
    public void i_am_on_the_magnus_forgot_password_page() {
        
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/ForgotPassword");
    }

    @When("I enter email as {string}")
    public void i_enter_email_as(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @When("I click on the get password button")
    public void i_click_on_the_get_password_button() {
        driver.findElement(By.id("getPasswordButton")).click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("confirmationMessage")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    @When("I leave the email field empty")
    public void i_leave_the_email_field_empty() {
        // No action needed as the field is left empty
    }

    @When("I click on the back button")
    public void i_click_on_the_back_button() {
        driver.findElement(By.id("backButton")).click();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.quit();
    }
}
