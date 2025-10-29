package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class LoginDemoSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the Login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(Config.getProperty("sauceDemo"));
    }

    @When("user provides a valid username")
    public void user_provides_a_valid_username() {
        loginPage.userName.sendKeys(Config.getProperty("sauceUser"));
    }

    @When("user provides a valid password")
    public void user_provides_a_valid_password() {
        loginPage.userPassword.sendKeys(Config.getProperty("saucePassword"));
    }

    @When("user clicks on loginbutton")
    public void user_clicks_on_loginbutton() {
        loginPage.loginButton.click();
    }

    @Then("verify user successfuly logged in")
    public void verify_user_successfuly_logged_in() {
        Assert.assertEquals(Config.getProperty("productPageURL"), Driver.getDriver().getCurrentUrl());
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().close();
        Driver.getDriver().quit();
    }
}
