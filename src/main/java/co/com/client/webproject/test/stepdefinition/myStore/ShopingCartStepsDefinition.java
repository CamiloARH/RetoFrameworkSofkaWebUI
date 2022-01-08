package co.com.client.webproject.test.stepdefinition.myStore;

import co.com.client.webproject.test.controllers.*;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.Customer;
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

import static co.com.client.webproject.test.helpers.Dictionary.SPACE_STRING;

public class ShopingCartStepsDefinition extends GeneralSetup {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    //Scenario 1
    @Dado("el usuario logeado esta en la pagina y desea realizar dos compras")
    public void elUsuarioLogeadoEstaEnLaPaginaYDeseaRealizarDosCompras() {
        try {
            StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();

            LoginPageWebController loginPageWebController = new LoginPageWebController();
            loginPageWebController.setWebAction(webAction);
            loginPageWebController.irHaciaLoginPage();

            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);
            createAnAccountWebController.crearUnaCuenta();
            customer = createAnAccountWebController.getCustomer();
        }catch (Exception e){
            Assertions.fail("Error en el setup Scenario 1 del cart shopping");
        }
    }

    @Cuando("el usuario entra a Women y agrega dos productos")
    public void elUsuarioEntraAWomenYAgregaDosProductos() {
        try {
            WomenSectionController womenSectionController = new WomenSectionController();
            womenSectionController.setWebAction(webAction);
            womenSectionController.starShopping();

            CartShoppingBankController cartShoppingBankController = new CartShoppingBankController();
            cartShoppingBankController.setWebAction(webAction);
            cartShoppingBankController.readyToPayWithBank();
        }catch (Exception e){
            Assertions.fail("Error en la compra del Scenario 1 del cart shopping");
        }

    }

    @Entonces("el usuario completa los pasos y debera ver el mensaje {string}")
    public void elUsuarioCompletaLosPasosYDeberaVerElMensaje(String bankOk) {
        try {
            BankValidation bankValidation = new BankValidation();
            bankValidation.setWebAction(webAction);

            Assert.Hard
                    .thatString(bankValidation.bankPaymentOk())
                    .isEqualTo(bankOk);
        }catch (Exception e){
            Assertions.fail("Error en la validacion del Scenario 1 del cart shopping");
        }

    }

    //Scenario 2
    @Dado("el usuario logeado entra en la pagina y desea realizar minimo dos compras")
    public void elUsuarioLogeadoEntraEnLaPaginaYDeseaRealizarMinimoDosCompras() {
        try {StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
            startBrowserWebController.setBrowser(browser());
            startBrowserWebController.setWebAction(webAction);
            startBrowserWebController.setFeature(testInfo.getFeatureName());
            startBrowserWebController.abrirTiendaOnline();
            LoginPageWebController loginPageWebController = new LoginPageWebController();
            loginPageWebController.setWebAction(webAction);
            loginPageWebController.irHaciaLoginPage();

            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);
            createAnAccountWebController.crearUnaCuenta();
            customer = createAnAccountWebController.getCustomer();
        }catch (Exception e){
            Assertions.fail("Error en el setup Scenario 2 del cart shopping");
        }
    }

    @Cuando("el usuario entra a Dresses y agrega dos productos")
    public void elUsuarioEntraADressesYAgregaDosProductos() {
        try {
            DressesSectionController dressesSectionController = new DressesSectionController();
            dressesSectionController.setWebAction(webAction);
            dressesSectionController.starShopping2();

            CartShoppingChekController cartShoppingChekController = new CartShoppingChekController();
            cartShoppingChekController.setWebAction(webAction);
            cartShoppingChekController.readyToPayWithChek();
        }catch (Exception e){
            Assertions.fail("Error en la compra del Scenario 2 del cart shopping");
        }
    }

    @Entonces("el usuario completa los pasos y deberia ver el mensaje {string}")
    public void elUsuarioCompletaLosPasosYDeberiaVerElMensaje(String checkOk) {
        try {
            CheckValidation checkValidation = new CheckValidation();
            checkValidation.setWebAction(webAction);

            Assert.Hard
                    .thatString(checkValidation.checkPaymentOk())
                    .isEqualTo(checkOk);
        }catch (Exception e){
            Assertions.fail("Error en la validacion del Scenario 2 del cart shopping");
        }
    }

    @After
    public void tearDown() throws WebActionsException {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
