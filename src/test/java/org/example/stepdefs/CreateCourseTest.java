package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_LoginPage;
import org.example.pages.P02_CoursesPage;
import org.example.pages.P03_CourseFormPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCourseTest {
    private P01_LoginPage loginPage;
    private P02_CoursesPage coursesPage;
    private P03_CourseFormPage createCoursePage;
    private WebDriverWait wait;



    @Given("login with email {string} and password {string}")
    public void loginWithUsernameAndPassword(String email, String password) {
        loginPage = new P01_LoginPage(Hooks.driver);
        loginPage.login(email, password);

    }

    @When("navigate to the courses page")
    public void navigateToTheCoursesPage()  {
        coursesPage = new P02_CoursesPage(Hooks.driver);
        coursesPage.clickCoursesPage();
    }

    @And("create a course with name {string}")
    public void createACourseWithName(String courseName) throws InterruptedException {

        coursesPage.clickCreateCourse();
        createCoursePage = new P03_CourseFormPage(Hooks.driver);
        createCoursePage.fillCourseBasicInfo(courseName);
    }

    @Then("user should see the course title {string} displayed in the courses list")
    public void userShouldSeeTheCourseTitleDisplayedInTheCoursesList(String courseName) throws InterruptedException {

        coursesPage.clickCoursesPage();
        Assert.assertTrue(coursesPage.getCourseTitle().contains(courseName));

    }
}
