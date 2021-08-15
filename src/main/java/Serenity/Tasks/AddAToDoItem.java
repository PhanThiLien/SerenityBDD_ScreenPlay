package Serenity.Tasks;

import Serenity.Pages.BackBonePage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class AddAToDoItem {
    public static Task called(String item) {
        return Task.where("{0} adds a todo item called: #thingToDo",
                Enter
                        .theValue(item)
                        .into(BackBonePage.WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(Keys.RETURN)
                ).with("thingsToDo").of(item);
    }
}
