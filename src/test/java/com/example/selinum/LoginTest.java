package com.example.selinum;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setup() {

        driver = new ChromeDriver();

        String page = getClass()
                .getResource("/login.html")
                .toExternalForm();

        driver.get(page);
    }

    @Test
    void validLogin() {

        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("admin123");

        driver.findElement(By.tagName("button"))
                .click();

        String result = driver.findElement(By.id("message"))
                .getText();

        assertEquals("Login Successful!", result);

        System.out.println("Valid Login: PASSED");
    }

    @Test
    void invalidLogin() {

        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("wrong123");

        driver.findElement(By.tagName("button"))
                .click();

        String result = driver.findElement(By.id("message"))
                .getText();

        assertEquals(
                "Invalid Username or Password!", result
        );

        System.out.println("Invalid Login: PASSED");
    }

    @AfterEach
    void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}
