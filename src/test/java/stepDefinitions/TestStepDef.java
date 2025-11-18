package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class TestStepDef {
   WebDriver driver;
    LoginPage loginPage;

    @Given("I am in Login Page")
    public void i_am_in_login_page() {

        driver = DriverFactory.getDriver(); //
        loginPage = new LoginPage(driver);  // Write code here that turns the phrase above into concrete actions
       driver.get("https://www.saucedemo.com/");
    }
//    @When("I login with username <string> and password <string>")
//
//    public void i_login_with_username_standard_user_and_password_secret_sauce(String userName,String password) {
//        // Write code here that turns the phrase above into concrete actions
//
//    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameUserNameAndPasswordPassword(String userName,String password) {
        loginPage.login(userName,password);

    }

    @Then("I Verify the title {string}")
    public void verifyTitle(String title){
        Assert.assertEquals(loginPage.getTitle(),title);
    }

}
