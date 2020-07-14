package co.com.bancolombia.certification.pruebaensure.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.CONTINUAR_BUTTON;
import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.SI_OPTION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnThe implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CONTINUAR_BUTTON, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(CONTINUAR_BUTTON),
                Click.on(SI_OPTION)
        );
    }

    public static ClickOnThe siOption(){
        return Tasks.instrumented(ClickOnThe.class);
    }

}
