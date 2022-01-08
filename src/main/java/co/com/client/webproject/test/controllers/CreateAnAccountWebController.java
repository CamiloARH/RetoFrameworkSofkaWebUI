package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class CreateAnAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(
                    createAnAccountPage.getEmailAddress(),
                    customer.getEmail(),
                    2,
                    false
            );
            webAction.click(createAnAccountPage.getCreateAnAccount(), 2, false);
            webAction.click(createAnAccountPage.getMr(), 10, false);
            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(), false);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(), false);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(), false);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(), false);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(), false);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(), false);
            webAction.click(createAnAccountPage.getNewsLetter(), 5, false);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(), false);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(), false);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(), false);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(), false);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(), false);
            webAction.click(createAnAccountPage.getRegister(), false);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
