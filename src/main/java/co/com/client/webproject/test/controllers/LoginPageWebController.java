package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.LandingPageContactUs;
import co.com.client.webproject.test.page.LandingPageSignIn;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class LoginPageWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaLoginPage(){
        try{
            LandingPageSignIn landingPageSignIn = new LandingPageSignIn(webAction.getDriver());
            webAction.click(landingPageSignIn.getSignIn(), 2, false);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la página de login.", e);
        }
    }

    public void irHaciaContactUsPage(){
        try{
            LandingPageContactUs landingPageContactUs = new LandingPageContactUs(webAction.getDriver());
            webAction.click(landingPageContactUs.getContactUs(), 2, true);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la página de Contact Us.", e);
        }
    }
}
