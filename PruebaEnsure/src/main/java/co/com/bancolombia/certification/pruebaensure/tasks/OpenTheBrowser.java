package co.com.bancolombia.certification.pruebaensure.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheBrowser implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://qa.grupobancolombia.com/personas/creditos/consumo/credito-libre-inversion/simulador-libre-inversion")
        );
    }

    public static OpenTheBrowser onTheFreeInvestmentCreditSimulationPage(){
        return Tasks.instrumented(OpenTheBrowser.class);
    }

}
