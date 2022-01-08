package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {

    @CacheLookup
    @FindBy(css = "#block_top_menu  > ul > li:nth-child(2) > a")
    WebElement dressesSection;

    @CacheLookup
    @FindBy(css = "img[alt='Printed Dress']")
    WebElement printedDress;

    @CacheLookup
    @FindBy(css = "img[alt='Printed Summer Dress']")
    WebElement summerDress;

    @CacheLookup
    @FindBy(css = "a[data-id-product='3']")
    WebElement addCart1;

    @CacheLookup
    @FindBy(css = "a[data-id-product='5']")
    WebElement addCart2;

    @CacheLookup
    @FindBy(css = "i[class='icon-chevron-left left']")
    WebElement continueShopping;

    @CacheLookup
    @FindBy(css = "a[class='btn btn-default button button-medium']")
    WebElement checkoutButton;

    public WebElement getDressesSection() {
        return dressesSection;
    }

    public WebElement getPrintedDress() {
        return printedDress;
    }

    public WebElement getSummerDress() {
        return summerDress;
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

    public DressesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
