package com.TecAlliance.steps;

import com.TecAlliance.pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleSearchSteps {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Given("I am on the Google home page")
    public void goToGoogleHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goToGoogleHomePage();
    }

    @When("I enter \"$keyword\" in the search bar")
    public void enterKeyword(String keyword) {
        googleSearchPage.enterKeyword(keyword);
    }

    @When("I press the Enter key")
    public void pressEnterKey() {
        googleSearchPage.pressEnterKey();
        googleSearchPage.waitForSearchResults();
    }

    @Then("I should see results including the text \"$expectedText\"")
    public void verifySearchResults(String expectedText) {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.g"));

        boolean resultFound = searchResults.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.contains(expectedText));

        assertTrue("Search results do not include the expected text: " + expectedText, resultFound);
        driver.quit();
    }
}
