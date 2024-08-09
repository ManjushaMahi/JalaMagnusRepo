package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class EmployeeSteps {
    WebDriver driver;

    @Given("I am on the Magnus employee tab page")
    public void i_am_on_the_magnus_employee_tab_page() {
        
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/EmployeeTab");
    }

    @When("I enter first name as {string}")
    public void i_enter_first_name_as(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    @When("I enter last name as {string}")
    public void i_enter_last_name_as(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    @When("I enter email as {string}")
    public void i_enter_email_as(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @When("I enter mobile number as {string}")
    public void i_enter_mobile_number_as(String mobileNumber) {
        driver.findElement(By.id("mobileNumber")).sendKeys(mobileNumber);
    }

    @When("I select date of birth as {string}")
    public void i_select_date_of_birth_as(String dob) {
        driver.findElement(By.id("dob")).sendKeys(dob);
    }

    @When("I select gender as {string}")
    public void i_select_gender_as(String gender) {
        driver.findElement(By.id("gender")).sendKeys(gender);
    }

    @When("I enter address as {string}")
    public void i_enter_address_as(String address) {
        driver.findElement(By.id("address")).sendKeys(address);
    }

    @When("I select country as {string}")
    public void i_select_country_as(String country) {
        driver.findElement(By.id("country")).sendKeys(country);
    }

    @When("I select city as {string}")
    public void i_select_city_as(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    @When("I enter skills as {string}")
    public void i_enter_skills_as(String skills) {
        driver.findElement(By.id("skills")).sendKeys(skills);
    }

    @When("I click on the save button")
    public void i_click_on_the_save_button() {
        driver.findElement(By.id("saveButton")).click();
    }

    @Then("I should see a success message {string}")
    public void i_should_see_a_success_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.id("successMessage")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    @When("I leave mandatory fields empty")
    public void i_leave_mandatory_fields_empty() {
        // No action needed as fields are left empty
    }

    @Then("I should see error messages indicating missing fields")
    public void i_should_see_error_messages_indicating_missing_fields() {
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertTrue(errorMessage.contains("This field is required"));
        driver.quit();
    }

    @When("I click on the cancel button")
    public void i_click_on_the_cancel_button() {
        driver.findElement(By.id("cancelButton")).click();
    }

    @Then("I should see the form reset or be redirected to the previous page")
    public void i_should_see_the_form_reset_or_be_redirected_to_the_previous_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("EmployeeTab"));
        driver.quit();
    }

    @Given("I am on the Magnus employee list page")
    public void i_am_on_the_magnus_employee_list_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/EmployeeList");
    }

    @When("I click on the delete button for an employee")
    public void i_click_on_the_delete_button_for_an_employee() {
        driver.findElement(By.id("deleteButton")).click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String expectedMessage) {
        String actualMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
