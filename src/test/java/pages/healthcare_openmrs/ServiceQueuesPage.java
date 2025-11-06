package pages.healthcare_openmrs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v140.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ServiceQueuesPage {

    public ServiceQueuesPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//p[text()='Service queues']")
    public WebElement textServiceQueues;




}
