package steps.healthcare_openmrs;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.healthcare_openmrs.*;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class LoginSteps{
    LoginPage loginPage = new LoginPage();
    ServiceQueuesPage serviceQueuesPage = new ServiceQueuesPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("the user is on the OpenMRS login page")
    public void the_user_is_on_the_open_mrs_login_page() {
        Driver.getDriver().get(Config.getProperty("openMRS3Login"));
    }
    @When("the user enters valid username")
    public void the_user_enters_valid_username() {
        loginPage.userName.sendKeys(Config.getProperty("openMRS3User"));
        actions.sendKeys(Keys.ENTER).perform();
    }
    @When("the user enters valid password")
    public void the_user_enters_valid_password() {
        loginPage.userPassword.sendKeys(Config.getProperty("openMRS3Password"));
    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("the user should be redirected to the service queues page")
    public void the_user_should_be_redirected_to_the_service_queues_page() {
        wait.until(ExpectedConditions.visibilityOf(serviceQueuesPage.textServiceQueues));
        Assert.assertEquals(Config.getProperty("openMRS3ServQueues"), Driver.getDriver().getCurrentUrl());
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().close();
        Driver.getDriver().quit();


    }




}




