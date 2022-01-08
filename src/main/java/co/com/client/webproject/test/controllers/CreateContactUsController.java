package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.ContactUsFillUp;
import co.com.client.webproject.test.page.FillUpContactUSPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateContactUs;

public class CreateContactUsController {
    private WebAction webAction;
    private ContactUsFillUp contactUsFillUp;

    public ContactUsFillUp getContactUsFillUp() {
        return contactUsFillUp;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void fillUpContactUs(){
        try{
            contactUsFillUp = generateContactUs(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            FillUpContactUSPage fillUpContactUSPage = new FillUpContactUSPage(webAction.getDriver());

            webAction.click(fillUpContactUSPage.getSubjectHeadingCustumer(), 2, true);
            webAction.sendText(fillUpContactUSPage.getEmail(), contactUsFillUp.getEmail(), true);
            webAction.sendText(fillUpContactUSPage.getOrderReference(), contactUsFillUp.getIdOrder(), true);
            webAction.sendText(fillUpContactUSPage.getMessage(), contactUsFillUp.getMessage(), true);
            webAction.click(fillUpContactUSPage.getSubmitMessageBotton(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar mandar el mensaje", e);
        }
    }

    public void fillUpContactUsWithOutMessage(){
        try{
            contactUsFillUp = generateContactUs(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            FillUpContactUSPage fillUpContactUSPage = new FillUpContactUSPage(webAction.getDriver());

            webAction.click(fillUpContactUSPage.getSubjectHeadingCustumer(), 2, true);
            webAction.sendText(fillUpContactUSPage.getEmail(), contactUsFillUp.getEmail(), true);
            webAction.sendText(fillUpContactUSPage.getOrderReference(), contactUsFillUp.getIdOrder(), true);
            webAction.click(fillUpContactUSPage.getSubmitMessageBotton(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("No se reporto el error del no envio del mensaje.", e);
        }
    }
}
