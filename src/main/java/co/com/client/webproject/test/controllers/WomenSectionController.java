package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CreateAnAccountPage;
import co.com.client.webproject.test.page.WomenPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class WomenSectionController {
    private WebAction webAction;


    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void starShopping(){
        try{
            WomenPage womenPage = new WomenPage(webAction.getDriver());

            webAction.click(womenPage.getWomenSection(), 2, true);
            webAction.moveTo(womenPage.gettShirts(), 5, true);
            webAction.click(womenPage.getAddCart1(), 2,true);
            webAction.click(womenPage.getContinueShopping(),2,true);
            webAction.moveTo(womenPage.getBlouse(), 5, true);
            webAction.click(womenPage.getAddCart2(), 2,true);
            webAction.click(womenPage.getCheckoutButton(),2,true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al seleccionar las prendas en Women.", e);
        }
    }
}
