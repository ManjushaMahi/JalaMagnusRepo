package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the Magnus login page")
    public void i_am_on_the_magnus_login_page() {
        
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/");
    }

    @When("I enter username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertEquals(expectedMessage, errorMessage.getText());
        driver.quit();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.quit();
    }

    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {
        // No action needed as fields are left empty
    }

    @Given("I am logged into the Magnus application")
    public void i_am_logged_into_the_magnus_application() {
        // Assuming a successful login before this step
        i_am_on_the_magnus_login_page();
        i_enter_username_as_and_password_as("training@jalaacademy.com", "jobprogram");
        i_click_on_the_login_button();
    }

    @When("I click on the logout button")
    public void i_click_on_the_logout_button() {
        driver.findElement(By.id("logoutButton")).click();
    }
}
