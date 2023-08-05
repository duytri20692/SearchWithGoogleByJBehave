package com.TecAlliance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {
    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToGoogleHomePage() {
        driver.get("https://www.google.com");
    }

    public void enterKeyword(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void pressEnterKey() {
        searchInput.sendKeys(Keys.ENTER);
    }

    public void waitForSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(By.cssSelector("div.g")).size() > 0); // Search results are within <div class="g">
    }
}
