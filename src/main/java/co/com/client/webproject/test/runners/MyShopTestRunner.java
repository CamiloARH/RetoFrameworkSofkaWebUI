package co.com.client.webproject.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactUs.feature","src/main/resources/features/singInAndShoppingCar.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.myStore"},
        tags = {}
)
public class MyShopTestRunner {
}
