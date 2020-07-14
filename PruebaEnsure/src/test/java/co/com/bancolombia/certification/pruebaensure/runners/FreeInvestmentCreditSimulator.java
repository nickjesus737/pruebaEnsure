package co.com.bancolombia.certification.pruebaensure.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/free_investment_credit_simulator.feature",
        tags = {},
        glue = {"co.com.bancolombia.certification.pruebaensure.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false
)
public class FreeInvestmentCreditSimulator {
}
