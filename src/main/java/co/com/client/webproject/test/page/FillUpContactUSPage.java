package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillUpContactUSPage {

    @CacheLookup
    @FindBy(css = "#id_contact :nth-child(2)")
    WebElement subjectHeadingCustumer;

    @CacheLookup
    @FindBy(css = "#id_contact :nth-child(1)")
    WebElement subjectHeadingWebMaster;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orderReference;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitMessageBotton;

    public WebElement getSubjectHeadingCustumer() {
        return subjectHeadingCustumer;
    }

    public WebElement getSubjectHeadingWebMaster() {
        return subjectHeadingWebMaster;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmitMessageBotton() {
        return submitMessageBotton;
    }

    public FillUpContactUSPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
