package stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class PopupSteps {
    WebDriver driver;

    @Given("I am on the Magnus home page")
    public void i_am_on_the_magnus_home_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://magnus.jalatechnologies.com/Home/Index");
    }

    @Then("I should find the popup and print the message on the screen")
    public void i_should_find_the_popup_and_print_the_message_on_the_screen() {
        try {
           // WebDriverWait wait = new WebDriverWait(driver, 10);
           // wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            System.out.println("Popup message: " + alertMessage);
            alert.accept();
        } catch (Exception e) {
            System.out.println("No popup found on the page.");
        } finally {
            driver.quit();
        }
    }
}
