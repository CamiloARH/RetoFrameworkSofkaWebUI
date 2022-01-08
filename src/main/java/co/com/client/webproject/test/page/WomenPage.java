package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    @CacheLookup
    @FindBy(css = "a[title='Women']")
    WebElement womenSection;

    @CacheLookup
    @FindBy(css = "img[alt='Faded Short Sleeve T-shirts']")
    WebElement tShirts;

    @CacheLookup
    @FindBy(css = "img[alt='Blouse']")
    WebElement blouse;

    @CacheLookup
    @FindBy(css = "a[data-id-product='1']")
    WebElement addCart1;

    @CacheLookup
    @FindBy(css = "a[data-id-product='2']")
    WebElement addCart2;

    @CacheLookup
    @FindBy(css = "i[class='icon-chevron-left left']")
    WebElement continueShopping;

    @CacheLookup
    @FindBy(css = "a[class='btn btn-default button button-medium']")
    WebElement checkoutButton;

    public WebElement getWomenSection() {
        return womenSection;
    }

    public WebElement gettShirts() {
        return tShirts;
    }

    public WebElement getBlouse() {
        return blouse;
    }

    public WebElement getAddCart1() {
        return addCart1;
    }

    public WebElement getAddCart2() {
        return addCart2;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WomenPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
