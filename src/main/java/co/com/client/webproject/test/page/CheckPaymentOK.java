package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckPaymentOK {
    @CacheLookup
    @FindBy(css = "p[class='alert alert-success']")
    WebElement checkPaymentOK;

    public WebElement getCheckPaymentOK() {
        return checkPaymentOK;
    }

    public CheckPaymentOK(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
