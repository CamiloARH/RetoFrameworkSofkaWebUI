package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @CacheLookup
    @FindBy(css = "a[class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedCheckoutButton;

    @CacheLookup
    @FindBy(css = "button[class='button btn btn-default button-medium']")
    WebElement proceedCheckoutButtonAddress;

    @CacheLookup
    @FindBy(id = "uniform-cgv")
    WebElement agreedTerms;

    @CacheLookup
    @FindBy(css = "button[class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedCheckoutButtonShipping;

    @CacheLookup
    @FindBy(css = "a[title='Pay by bank wire']")
    WebElement byBank;

    @CacheLookup
    @FindBy(css = "a[title='Pay by check.']")
    WebElement byCheck;

    @CacheLookup
    @FindBy(css = "button[class='button btn btn-default button-medium']")
    WebElement confirmOrderButton;

    public WebElement getProceedCheckoutButton() {
        return proceedCheckoutButton;
    }

    public WebElement getProceedCheckoutButtonAddress() {
        return proceedCheckoutButtonAddress;
    }

    public WebElement getAgreedTerms() {
        return agreedTerms;
    }

    public WebElement getProceedCheckoutButtonShipping() {
        return proceedCheckoutButtonShipping;
    }

    public WebElement getByBank() {
        return byBank;
    }

    public WebElement getByCheck() {
        return byCheck;
    }

    public WebElement getConfirmOrderButton() {
        return confirmOrderButton;
    }

    public CartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
