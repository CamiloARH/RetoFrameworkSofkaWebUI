package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ContactUsOK;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsOkValidation {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerContactUsOk(){
        String message = "";
        try{
            ContactUsOK contactUsOK = new ContactUsOK(webAction.getDriver());
            message = webAction.getText(contactUsOK.getContactUsOK(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al enviar el contact Us ok.", e);
        }

        return message;
    }
}
