package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 * Created by mohammadmuntakim.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up", "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password) text fields on home screen$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(anyText);
                break;
            case "password":
                homePage.enterPassword(anyText);
                break;
            case "firstname":
                homePage.enterFirstName(anyText);
                break;
            case "lastname":
                homePage.enterLastName(anyText);
                break;
            case "mobile number":
                homePage.enterMobileNumber(anyText);
                break;
            case "new password":
                homePage.enterNewPassword(anyText);
                break;
        }
    }

    @When("^I click on (new password|email mobile) field on home screen$")
    public void clickingNewPasswordTxtField(String text) {
        switch (text) {
            case "new password":
                homePage.clickOnNewPasswordField();
                break;
            case "email mobile":
                homePage.clickOnEmailMobileField();
                break;

        }
    }

    @When("^I click on (login|create account) button on home screen$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "create account":
                //Implement Create account object
                break;
        }
    }

    @Then("^I verify that i am an invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }

    @Then("^I verify invalid email error message on home screen$")
    public void verifyInvalidEmailError() {
        Assert.assertEquals(homePage.emailError(), "Please enter a valid mobile number or email address.");

    }

    @When("^I select on (birthday) dropdown on home screen$")
    public void selectMonthDropDown(String months) {
        homePage.clickOnBirthdayDropDown();

    }


    @When("^I click on (current month) from the dropdown on home screen$")
    public String selectCurrentMonth(String currentMonth) {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        String currentM = sdf.format(currentDate);
        return currentMonth;
    }


    @Then("^I verify (october) is selected$")
    public void isCurrentMonthSelected(String October) {
        Assert.assertEquals(selectCurrentMonth("Oct"), "Oct");
    }

    @Then("^I verify month is not duplicate$")
    public void isDDDuplicate() {
        homePage.isDuplicate();

    }
}


