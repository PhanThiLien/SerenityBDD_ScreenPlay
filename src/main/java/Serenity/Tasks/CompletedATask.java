package Serenity.Tasks;

import Serenity.Pages.BackBonePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletedATask implements Task {

    private String taskName;

    public CompletedATask(String taskName) {
        this.taskName = taskName;
    }

    public static CompletedATask called(String taskName) {
        return instrumented(CompletedATask.class, taskName);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        BackBonePage.COMPLETE_CHECKBOX.of(taskName).resolveFor(t).click();
    }
}
