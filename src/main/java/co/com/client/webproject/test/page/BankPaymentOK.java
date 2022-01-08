package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankPaymentOK {
    @CacheLookup
    @FindBy(css = "p[class='cheque-indent'] :nth-child(1)")
    WebElement bankPaymentOK;

    public WebElement getBankPaymentOK() {
        return bankPaymentOK;
    }

    public BankPaymentOK(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
