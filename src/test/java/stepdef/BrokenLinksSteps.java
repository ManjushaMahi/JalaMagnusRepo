package stepdef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksSteps {
    WebDriver driver;

    @Given("I am on the Magnus home page")
    public void i_am_on_the_magnus_home_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magnus.jalatechnologies.com/Home/Index");
    }

    @Then("I should find all broken links on the page")
    public void i_should_find_all_broken_links_on_the_page() {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("Broken link found: " + url + " - Response code: " + responseCode);
                } else {
                    System.out.println("Valid link: " + url + " - Response code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println("Exception checking link: " + url + " - " + e.getMessage());
            }
        }

        driver.quit();
    }
}
