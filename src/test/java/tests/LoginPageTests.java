package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class LoginPageTests {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest() {
        driver.get(Config.getProperty("sauceDemo"));
        loginPage.userName.sendKeys(Config.getProperty("sauceUser"));
        loginPage.userPassword.sendKeys(Config.getProperty("saucePassword"));
        loginPage.loginButton.click();
    }


}
