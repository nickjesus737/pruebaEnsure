package co.com.bancolombia.certification.pruebaensure.stepdefinitions;

import co.com.bancolombia.certification.pruebaensure.questions.TheFee;
import co.com.bancolombia.certification.pruebaensure.tasks.ClickOnThe;
import co.com.bancolombia.certification.pruebaensure.tasks.MakeTheSimulation;
import co.com.bancolombia.certification.pruebaensure.tasks.OpenTheBrowser;
import co.com.bancolombia.certification.pruebaensure.tasks.SelectTheMaximum;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.LocalDate;
import java.util.List;

import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.*;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class FreeInvestmentCreditSimulatorStepDefinition {

    @Before
    public void startTheStage() {
        setTheStage(new OnlineCast());
    }

    @After
    public void finishTheStage(){
        drawTheCurtain();
    }

    @Given("The actor {string} is in the Bancolombia Free Investment Credit Simulator page")
    public void theActorIsInTheBancolombiaFreeInvestmentCreditSimulatorPage(String actor) {
        theActorCalled(actor).wasAbleTo(
                OpenTheBrowser.onTheFreeInvestmentCreditSimulationPage()
        );
    }

    @When("He makes a simulation with {int} of loan, {int} years old and {int} months of term")
    public void heMakesASimulationWithOfLoanYearsOldAndMonthsOfTerm(int loan, int years, int month) {
        theActorInTheSpotlight().attemptsTo(
                MakeTheSimulation.with(loan, years, month)
        );
    }

    @Then("He should see that the fee are not greater than {int}")
    public void heShouldSeeThatTheFeeAreNotGreaterThan(int maxValue) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.thatTheAnswerTo(TheFee.value()).isLessThan(maxValue)
        );
    }

    @When("He selects the maximum date in the calendar")
    public void heSelectsTheMaximumDateInTheCalendar() {
        theActorInTheSpotlight().attemptsTo(
                SelectTheMaximum.dateOfBirth()
        );
    }

    @Then("He should see that the date selected is before the actual date")
    public void heShouldSeeThatTheDateSelectedIsBeforeTheActualDate() {
        LocalDate actualDate = LocalDate.now();

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(SIMULATION_BIRTH_DATE_INPUT).value().asADate("d/M/yyyy").isBefore(actualDate)
        );

    }

    @When("He clicks on the si option")
    public void heClicksOnTheSiOption() {
        theActorInTheSpotlight().attemptsTo(
                ClickOnThe.siOption()
        );
    }

    @Then("He should see that the simulate button text is in upper case")
    public void heShouldSeeThatTheSimulateButtonTextIsInUpperCase() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(SIMULATE_BUTTON).text().isInUppercase()
        );
    }

    @Then("He should see that the fees values are")
    public void heShouldSeeThatTheFeesValuesAre(List<String> values) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FEE_VALUE).textValues().containsExactlyElementsFrom(values),
                Ensure.that(FEE_VALUE).textValues().containsExactlyInAnyOrderElementsFrom(values)
        );
    }

    @Then("He should see that the fees text do not have blank spaces")
    public void heShouldSeeThatTheFeesTextDoNotHaveBlankSpaces() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FEE_VALUE).text().doesNotContainAnyWhitespaces(),
                Ensure.that(FEE_VALUE).text().not().containsWhitespaces()
        );
    }

    @Then("He should see that the fees firts value is")
    public void heShouldSeeThatTheFeesFirtsValueIs(List<String> values) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FEE_VALUE).textValues().startsWithElementsFrom(values)
        );
    }

    @Then("He should see that the fees last value is")
    public void heShouldSeeThatTheFeesLastValueIs(List<String> values) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(FEE_VALUE).textValues().endsWithElementsFrom(values)
        );
    }
}
