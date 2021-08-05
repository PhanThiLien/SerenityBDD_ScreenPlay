package Serenity.CustomActions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoubleClick implements Interaction {

    private final Target target;

    public DoubleClick(Target target) {
        this.target = target;
    }

    public DoubleClick on(Target target){
        return instrumented(DoubleClick.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement webElement = target.resolveFor(actor).getElement();

        as(actor).doubleClick(webElement).perform();

    }

    private Actions as(Actor actor){
        return new Actions(BrowseTheWeb.as(actor).getDriver());
    }
}
