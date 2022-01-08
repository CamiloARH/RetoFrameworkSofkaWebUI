package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.DressesPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class DressesSectionController {
    private WebAction webAction;


    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void starShopping2(){
        try{
            DressesPage dressesPage = new DressesPage(webAction.getDriver());

            webAction.click(dressesPage.getDressesSection(), 3, true);
            webAction.moveTo(dressesPage.getPrintedDress(), 5, true);
            webAction.click(dressesPage.getAddCart1(), 2,true);
            webAction.click(dressesPage.getContinueShopping(),2,true);
            webAction.moveTo(dressesPage.getSummerDress(), 5, true);
            webAction.click(dressesPage.getAddCart2(), 2,true);
            webAction.click(dressesPage.getCheckoutButton(),2,true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
