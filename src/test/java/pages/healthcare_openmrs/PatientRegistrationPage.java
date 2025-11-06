package pages.healthcare_openmrs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientRegistrationPage {

    public PatientRegistrationPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Name is Known?')]/../following-sibling::div/button/span[@title='Yes']/..")
    public WebElement nameKnownSwitchYes;

    @FindBy(xpath = "//span[contains(text(),'Name is Known?')]/../following-sibling::div/button/span[@title='No']/..")
    public WebElement nameKnownSwitchNo;

    @FindBy(id = "givenName")
    public WebElement firstName;

    @FindBy(id = "middleName")
    public WebElement middleName;

    @FindBy(id = "familyName")
    public WebElement familyName;

    @FindBy(id = "gender-option-male")
    public WebElement genderMale;

    @FindBy(id = "gender-option-female")
    public WebElement genderFemale;

    @FindBy(id = "gender-option-unknown")
    public WebElement genderUnknown;

    @FindBy(id = "gender-option-other")
    public WebElement genderOther;

    @FindBy(xpath = "//span[contains(text(),'Date of Birth Known?')]/../following-sibling::div/button/span[@title='Yes']/..")
    public WebElement birthKnownSwitchYes;

    @FindBy(xpath = "//span[contains(text(),'Date of Birth Known?')]/../following-sibling::div/button/span[@title='No']/..")
    public WebElement birthKnownSwitchNo;

    @FindBy(id = ":r2a:")
    public WebElement birthDateInput;

    @FindBy(xpath = "//div[@id=':r2a:']/following-sibling::button")
    public WebElement birthCalendarButton;


}
