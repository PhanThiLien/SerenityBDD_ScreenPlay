package Serenity.Tasks;

import Serenity.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {
    private final String todoListDescription;
    private final List<String> todoItems;
    private HomePage homePage;

    public Start(String todoListDescription, List<String> todoItems) {
        this.todoListDescription = todoListDescription;
        this.todoItems = todoItems;
    }

    public static Start withEmptyTodoList() {
        return instrumented(Start.class, "No item to do", Collections.EMPTY_LIST);
    }

    public static Start withTodoListContaining(List<String> items) {
        return instrumented(Start.class, "No item to do", items);
    }

    @Override
    @Step("{0} start with **#todoListDescription**")
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Open.browserOn().the(homePage),
               Click.on(HomePage.BackBoneItem),
               Check.whether(todoItems.isEmpty()).otherwise(AddAListTodoItems.called(todoItems))
       );
    }
}
