package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsError {
    @CacheLookup
    @FindBy(css = "div[class='alert alert-danger'] li")
    WebElement contactUsError;

    public WebElement getContactUsError() {
        return contactUsError;
    }

    public ContactUsError(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
