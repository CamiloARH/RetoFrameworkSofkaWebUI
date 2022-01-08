package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageContactUs {

    @CacheLookup
    @FindBy(id = "contact-link")
    WebElement contactUs;

    public WebElement getContactUs() {
        return contactUs;
    }

    public LandingPageContactUs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
