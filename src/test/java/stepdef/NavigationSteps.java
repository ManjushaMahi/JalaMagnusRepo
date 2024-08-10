package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps {
    WebDriver driver;

    @Given("I am on the Magnus home page")
    public void i_am_on_the_magnus_home_page() {
        
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/Home/Index");
    }

    @When("I navigate to the \"More\" options")
    public void i_navigate_to_the_more_options() {
        WebElement moreOptions = driver.findElement(By.id("moreOptions"));  // Update this locator based on actual ID or class
        moreOptions.click();
    }

    @Then("I print all options under \"More\"")
    public void i_print_all_options_under_more() {
        List<WebElement> options = driver.findElements(By.cssSelector("#moreOptionsDropdown > li"));  // Update CSS selector as needed
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @When("I click on the \"Menu\" option")
    public void i_click_on_the_menu_option() {
        driver.findElement(By.linkText("Menu")).click();
    }

    @When("I click on the \"Testing\" option")
    public void i_click_on_the_testing_option() {
        driver.findElement(By.linkText("Testing")).click();
    }

    @When("I click on the \"Links\" option")
    public void i_click_on_the_links_option() {
        driver.findElement(By.linkText("Links")).click();
    }

    @When("I click on the \"Images\" option")
    public void i_click_on_the_images_option() {
        driver.findElement(By.linkText("Images")).click();
    }

    @Then("I should be on the respective pages")
    public void i_should_be_on_the_respective_pages() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Menu") || 
                          currentUrl.contains("Testing") || 
                          currentUrl.contains("Links") || 
                          currentUrl.contains("Images"));
        driver.quit();
    }
}
