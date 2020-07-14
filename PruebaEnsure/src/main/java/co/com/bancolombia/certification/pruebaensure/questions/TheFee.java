package co.com.bancolombia.certification.pruebaensure.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import static co.com.bancolombia.certification.pruebaensure.userinterfaces.FreeInvestmentCreditSimulatorHomePage.FEE_VALUE;

public class TheFee {

    public static Question<Integer> value(){
        return actor -> Integer.parseInt(TextContent.of(FEE_VALUE).viewedBy(actor).asString().replaceAll("[$, ]", ""));
    }

}
