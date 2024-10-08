package stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindFramesSteps {
    WebDriver driver;

    @Given("I am on the Magnus home page")
    public void finding_the_frames () {
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magnus.jalatechnologies.com/Home/Index");
    }

    @Then("I should find the number of frames available on the page")
    public void i_should_find_the_number_of_frames_available_on_the_page() {
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of frames on the page: " + frames.size());
        driver.quit();
    }
}
