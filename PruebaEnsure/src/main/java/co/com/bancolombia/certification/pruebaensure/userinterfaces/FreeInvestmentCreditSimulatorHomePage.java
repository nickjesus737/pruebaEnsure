package co.com.bancolombia.certification.pruebaensure.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FreeInvestmentCreditSimulatorHomePage {

    public static final Target CONTINUAR_BUTTON = Target.the("Continuar button in the home page").located(By.id("boton-seleccion-tarjeta"));

    public static final Target SI_OPTION = Target.the("Si option in the home page").located(By.id("opcion-si"));
    public static final Target SIMULATION_LOAN_INPUT = Target.the("input for the loan value").located(By.id("valor-simulacion"));
    public static final Target SIMULATION_BIRTH_DATE_INPUT = Target.the("input for the birth date value").located(By.id("campo-fecha"));
    public static final Target CALENDAR_LAST_AVAILABLE_YEAR = Target.the("last available year to select in the calendar").locatedBy("//mat-calendar//tr[last()]//td[last()]");
    public static final Target CALENDAR_LAST_AVAILABLE_MONTH = Target.the("last available month to select in the calendar").locatedBy("//td[contains(@class, 'active')]");
    public static final Target CALENDAR_LAST_AVAILABLE_DAY = Target.the("last available day to select in the calendar").locatedBy("//td[contains(@class, 'active')]");
    public static final Target SIMULATION_MONTHS_OF_TERM_INPUT = Target.the("input for the months of term value").located(By.id("valor-plazo"));
    public static final Target SIMULATE_BUTTON = Target.the("simulation button").located(By.id("boton-simular"));

    public static final Target FEE_VALUE = Target.the("simulation fee values").located(By.id("valor-resultados-compras"));

}
