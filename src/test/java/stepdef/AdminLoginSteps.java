package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLoginSteps {
    WebDriver driver;

    @Given("I am on the Magnus login page")
    public void i_am_on_the_magnus_login_page() {
        
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/");
    }

    @When("I click on the admin login tab")
    public void i_click_on_the_admin_login_tab() {
        driver.findElement(By.id("adminLoginTab")).click();
    }

    @When("I enter admin email or mobile as {string} and password as {string}")
    public void i_enter_admin_email_or_mobile_as_and_password_as(String emailOrMobile, String password) {
        driver.findElement(By.id("emailOrMobile")).sendKeys(emailOrMobile);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
        driver.findElement(By.id("signInButton")).click();
    }

    @Then("I should be redirected to the admin dashboard")
    public void i_should_be_redirected_to_the_admin_dashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("adminDashboard"));
        driver.quit();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    @When("I click on the back button")
    public void i_click_on_the_back_button() {
        driver.findElement(By.id("backButton")).click();
    }

    @Then("I should be redirected to the main login page")
    public void i_should_be_redirected_to_the_main_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.quit();
    }
}
