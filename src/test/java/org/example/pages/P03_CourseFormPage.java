package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_CourseFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By courseNameField = By.id("txtCourseName");
    private By selectGradeField = By.id("courseGrade");
    private By selectTeacherField = By.id("teacherOnBehalf");
    private By courseTitle = By.xpath("//a[text()='1TestingCourse5631']");

    private By createButton = By.id("btnSaveAsDraftCourse");

    public P03_CourseFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an explicit wait

    }
    public void selectGrade(String grade) {
        Select selectGrade = new Select(driver.findElement(selectGradeField));
        selectGrade.selectByVisibleText(grade);
    }

    public void selectTeacher(String teacher) {
        driver.findElement(selectTeacherField).click();
        By teacherName = By.xpath("//h5[contains(text(), '" + teacher + "')]");
        driver.findElement(teacherName).click();
    }
    public void fillCourseBasicInfo(String courseName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseNameField));
        driver.findElement(courseNameField).sendKeys(courseName);
        selectGrade("6");
        selectTeacher("Test Teacher");
        driver.findElement(createButton).click();
    }
}

