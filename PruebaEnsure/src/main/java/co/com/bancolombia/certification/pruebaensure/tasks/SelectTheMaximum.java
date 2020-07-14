package co.com.bancolombia.certification.pruebaensure.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectTheMaximum implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CONTINUAR_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CONTINUAR_BUTTON),
                Click.on(SI_OPTION),
                Click.on(SIMULATION_BIRTH_DATE_INPUT),
                Click.on(CALENDAR_LAST_AVAILABLE_YEAR),
                Click.on(CALENDAR_LAST_AVAILABLE_MONTH),
                Click.on(CALENDAR_LAST_AVAILABLE_DAY)
        );
    }

    public static SelectTheMaximum dateOfBirth(){
        return Tasks.instrumented(SelectTheMaximum.class);
    }
}
