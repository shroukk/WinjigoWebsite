package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("inputPassword");
    private By logInButton = By.id("btnLogin");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(logInButton).click();
    }
}

