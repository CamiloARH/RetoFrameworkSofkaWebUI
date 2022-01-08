package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.BankPaymentOK;
import co.com.client.webproject.test.page.ContactUsOK;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class BankValidation {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String bankPaymentOk(){
        String message = "";
        try{
            BankPaymentOK bankPaymentOK = new BankPaymentOK(webAction.getDriver());
            message = webAction.getText(bankPaymentOK.getBankPaymentOK(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar el pago por el banco.", e);
        }

        return message;
    }
}
