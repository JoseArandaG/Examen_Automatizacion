package com.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnabledIfSystemProperty(named = "acceptance", matches = "true")
class AceptacionWebIT {
    private WebDriver driver;

    @BeforeEach void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test void laPaginaCarga() {
        driver.get(System.getProperty("staging.url", "https://example.com"));
        String titulo = driver.getTitle();
        assertTrue(titulo != null && !titulo.isBlank());
    }

    @AfterEach void tearDown() {
        if (driver != null) driver.quit();
    }
}