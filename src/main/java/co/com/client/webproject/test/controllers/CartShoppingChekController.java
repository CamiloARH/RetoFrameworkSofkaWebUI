package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.CartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CartShoppingChekController {
    private WebAction webAction;


    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void readyToPayWithChek(){
        try{
            CartPage cartPage = new CartPage(webAction.getDriver());

            webAction.scroll(200);
            webAction.click(cartPage.getProceedCheckoutButton(), 2, true);
            webAction.scroll(200);
            webAction.click(cartPage.getProceedCheckoutButtonAddress(), 2, true);
            webAction.scroll(200);
            webAction.click(cartPage.getAgreedTerms(), 2, true);
            webAction.scroll(200);
            webAction.click(cartPage.getProceedCheckoutButtonShipping(), 2, true);
            webAction.scroll(200);
            webAction.click(cartPage.getByCheck(), 8, true);
            webAction.scroll(500);
            webAction.click(cartPage.getConfirmOrderButton(), 5, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al navegar en el carro de compras hacia el pago por cheque.", e);
        }
    }
}
