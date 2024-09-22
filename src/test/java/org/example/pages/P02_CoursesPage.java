package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_CoursesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators

    private By coursesPageButton = By.id("btnMyCoursesList");

    private By createCourseButton = By.id("btnListAddCourse");
    private By courseTitle = By.xpath("//a[text()='1TestingCourse5631']");
    private By searchCourseField = By.id("txtCourseSearch");
    private By searchButton = By.id("btnCourseSearch");


    public P02_CoursesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an explicit wait

    }
    public WebElement getCoursesPageButton(){
        return driver.findElement(coursesPageButton);
    }
    public WebElement getCreateCourseButton(){
        return driver.findElement(createCourseButton);
    }
    public WebElement getCourseTitleElment(){
        return driver.findElement(courseTitle);
    }
    public void clickCoursesPage() {
        wait.until(ExpectedConditions.elementToBeClickable(coursesPageButton));

        driver.findElement(coursesPageButton).click();
    }
    public void clickCreateCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(createCourseButton));
        driver.findElement(createCourseButton).click();
    }

    public String getCourseTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseTitle));

        return driver.findElement(courseTitle).getText();
    }
}

