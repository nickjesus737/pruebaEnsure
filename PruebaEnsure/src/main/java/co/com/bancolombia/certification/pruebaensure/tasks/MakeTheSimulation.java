package co.com.bancolombia.certification.pruebaensure.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MakeTheSimulation implements Task {

    private final int loan;
    private int years;
    private final int months;

    public MakeTheSimulation(int loan, int years, int months) {
        this.loan = loan;
        this.years = years;
        this.months = months;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CONTINUAR_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CONTINUAR_BUTTON),
                Click.on(SI_OPTION),
                Enter.theValue(String.valueOf(loan)).into(SIMULATION_LOAN_INPUT),
                Click.on(SIMULATION_BIRTH_DATE_INPUT),
                Click.on(CALENDAR_LAST_AVAILABLE_YEAR),
                Click.on(CALENDAR_LAST_AVAILABLE_MONTH),
                Click.on(CALENDAR_LAST_AVAILABLE_DAY),
                Enter.theValue(String.valueOf(months)).into(SIMULATION_MONTHS_OF_TERM_INPUT),
                Click.on(SIMULATE_BUTTON),
                WaitUntil.the(FEE_VALUE, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static MakeTheSimulation with(int loan, int years, int month){
        return Tasks.instrumented(MakeTheSimulation.class, loan, years, month);
    }

}
