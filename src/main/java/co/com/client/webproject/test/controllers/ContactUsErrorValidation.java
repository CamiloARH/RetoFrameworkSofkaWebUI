package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ContactUsError;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsErrorValidation {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerContactUsError(){
        String message = "";
        try{
            ContactUsError contactUsError = new ContactUsError(webAction.getDriver());
            message = webAction.getText(contactUsError.getContactUsError(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar error en contact us.", e);
        }

        return message;
    }
}
