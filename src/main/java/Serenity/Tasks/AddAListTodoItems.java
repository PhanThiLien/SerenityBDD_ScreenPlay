package Serenity.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddAListTodoItems implements Task {
    private final List<String> listToDoItems;

    public AddAListTodoItems(List<String> listToDoItems) {
        this.listToDoItems = listToDoItems;
    }

    public static AddAListTodoItems called(List<String> items){
        return instrumented(AddAListTodoItems.class, items);
    }

    @Override
    @Step("{0} adds the todo items called: #listToDoItems")
    public <T extends Actor> void performAs(T actor) {
        listToDoItems.forEach(item -> actor.attemptsTo(AddAToDoItem.called(item)));
    }
}
