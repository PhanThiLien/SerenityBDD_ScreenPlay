package Serenity.Tasks;

import Serenity.Models.TaskStatus;
import Serenity.Pages.BackBonePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterTask implements Task {

    private final TaskStatus status;

    public FilterTask(TaskStatus status) {
        this.status = status;
    }

    public static FilterTask hasStatus(TaskStatus status){
        return instrumented(FilterTask.class, status);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        BackBonePage.FILTER_BUTTON.of(String.valueOf(status)).resolveFor(t).click();
    }
}
