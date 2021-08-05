package Serenity.CustomActions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class JSClick implements Interaction {

    private final Target target;

    public JSClick(Target target) {
        this.target = target;
    }

    public JSClick on(Target target){
        return instrumented(JSClick.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);

        BrowseTheWeb.as(actor).evaluateJavascript("arguments[0].click()", element);

    }
}
