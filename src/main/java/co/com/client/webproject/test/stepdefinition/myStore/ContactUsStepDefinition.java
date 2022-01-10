package co.com.client.webproject.test.stepdefinition.myStore;

import co.com.client.webproject.test.controllers.ContactUsErrorValidation;
import co.com.client.webproject.test.controllers.ContactUsOkValidation;
import co.com.client.webproject.test.controllers.CreateContactUsController;
import co.com.client.webproject.test.controllers.LoginPageWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.ContactUsFillUp;
import co.com.client.webproject.test.stepdefinition.GeneralSetup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.assertj.core.api.Assertions;


public class ContactUsStepDefinition extends GeneralSetup {


    private WebAction webAction;
    private ContactUsFillUp contactUsFillUp;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    //Scenario 1
    @Dado("el usuario esta en la pagina y desea contactarse con servicio al cliente")
    public void elUsuarioEstaEnLaPaginaYDeseaContactarseConServicioAlCliente() {
        try {
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();

            LoginPageWebController loginPageWebController = new LoginPageWebController();
            loginPageWebController.setWebAction(webAction);
            loginPageWebController.irHaciaContactUsPage();

        } catch (Exception e) {
            Report.reportFailure("Error en el setup Scenario 1 del Contact Us");
            Assertions.fail("Error en el setup Scenario 1 del Contact Us");
        }
    }

    @Cuando("el usuario llena todos los campos")
    public void elUsuarioLlenaTodosLosCampos() {
        try {
            CreateContactUsController createContactUsController = new CreateContactUsController();
            createContactUsController.setWebAction(webAction);
            createContactUsController.fillUpContactUs();
            contactUsFillUp = createContactUsController.getContactUsFillUp();

        } catch (Exception e) {
            Report.reportFailure("Error en el llenado del Scenario 1 del Contact Us");
            Assertions.fail("Error en el llenado del Scenario 1 del Contact Us");
        }
    }

    @Entonces("el usuario deberia ver el mensaje {string}")
    public void elUsuarioDeberiaVerElMensaje(String answerOk) {
        try {
            ContactUsOkValidation contactUsOkValidation = new ContactUsOkValidation();
            contactUsOkValidation.setWebAction(webAction);

            Assert.Hard
                    .thatString(contactUsOkValidation.obtenerContactUsOk())
                    .isEqualTo(answerOk);

        } catch (Exception e) {
            Report.reportFailure("Error en la validacion del Scenario 1 del Contact Us");
            Assertions.fail("Error en la validacion del Scenario 1 del Contact Us");
        }
    }

    //Scenario 2
    @Dado("el usuario entra en la pagina y desea contactarse con servicio al cliente")
    public void elUsuarioEntraEnLaPaginaYDeseaContactarseConServicioAlCliente() {
        try {
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();

            LoginPageWebController loginPageWebController = new LoginPageWebController();
            loginPageWebController.setWebAction(webAction);
            loginPageWebController.irHaciaContactUsPage();

        } catch (Exception e) {
            Report.reportFailure("Error en el setup Scenario 2 del Contact Us");
            Assertions.fail("Error en el setup Scenario 2 del Contact Us");
        }
    }

    @Cuando("el usuario llena los campos pero no escribe el mensaje")
    public void elUsuarioLlenaLosCamposPeroNoEscribeElMensaje() {
        try {
            CreateContactUsController createContactUsController = new CreateContactUsController();
            createContactUsController.setWebAction(webAction);
            createContactUsController.fillUpContactUsWithOutMessage();
            contactUsFillUp = createContactUsController.getContactUsFillUp();

        } catch (Exception e) {
            Report.reportFailure("Error en el llenado del Scenario 2 del Contact Us");
            Assertions.fail("Error en el llenado del Scenario 2 del Contact Us");
        }
    }

    @Entonces("el usuario debera ver el mensaje {string}")
    public void elUsuarioDeberaVerElMensaje(String answerError) {
        try {
            ContactUsErrorValidation contactUsErrorValidation = new ContactUsErrorValidation();
            contactUsErrorValidation.setWebAction(webAction);

            Assert.Hard
                    .thatString(contactUsErrorValidation.obtenerContactUsError())
                    .isEqualTo(answerError);

        } catch (Exception e) {
            Report.reportFailure("Error en la validacion del Scenario 2 del Contact Us");
            Assertions.fail("Error en la validacion del Scenario 2 del Contact Us");
        }
    }

    @After
    public void tearDown2() throws WebActionsException {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}

