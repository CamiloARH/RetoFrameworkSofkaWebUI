package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.CheckPaymentOK;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CheckValidation {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String checkPaymentOk(){
        String message = "";
        try{
            CheckPaymentOK checkPaymentOK = new CheckPaymentOK(webAction.getDriver());
            message = webAction.getText(checkPaymentOK.getCheckPaymentOK(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar el pago con cheque.", e);
        }

        return message;
    }
}
