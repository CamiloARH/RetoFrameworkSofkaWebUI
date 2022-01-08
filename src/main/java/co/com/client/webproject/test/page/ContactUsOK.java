package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsOK {
    @CacheLookup
    @FindBy(css = "#center_column  :nth-child(2)")
    WebElement contactUsOK;

    public WebElement getContactUsOK() {
        return contactUsOK;
    }

    public ContactUsOK(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
