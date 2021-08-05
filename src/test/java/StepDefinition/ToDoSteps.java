package StepDefinition;

import Serenity.Models.TaskStatus;
import Serenity.Questions.TheItems;
import Serenity.Tasks.AddAToDoItem;
import Serenity.Tasks.CompletedATask;
import Serenity.Tasks.FilterTask;
import Serenity.Tasks.Start;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class ToDoSteps {
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void has_an_empty_todo_list(String actorName) {
        theActorCalled(actorName).wasAbleTo(Start.withEmptyTodoList());
    }

    @Given("that {string} has a todo list containing: {listOfStrings}")
    public void has_a_todo_list_containing(String actorName, List<String> items) {
        theActorCalled(actorName).wasAbleTo(Start.withTodoListContaining(items));
    }

    @Given("that {string} has a todo list containing:")
    public void has_a_todo_list_containing_a(String actorName, List<String> items) {
        theActorCalled(actorName).wasAbleTo(Start.withTodoListContaining(items));
    }

    @When("^s?he adds '(.*)' to (?:his|her|the) list$")
    public void add_new_item_to_list(String items) {
        theActorInTheSpotlight().attemptsTo(AddAToDoItem.called(items));
    }

    @Then("^(?:her|his|the) todo list should contain:$")
    public void should_contains_list_items(List<String> items) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(items)));
    }

    @Then("^(.*)'s todo list should contain:$")
    public void should_contains_list_items(String actorName, List<String> items) {
        theActorCalled(actorName).should(seeThat(TheItems.displayed(), equalTo(items)));
    }

    @Then("he(i)r(s) todo list should contain {listOfStrings}")
    public void should_contains_list_items_a(List<String> items) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(items)));
    }

    @Then("^'(.*)' should be recorded in (?:his|her|the) list$")
    public void item_should_be_recorded(String item) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), hasItem(item)));
    }

    @When("^s?he filters her list to show only '(.*)' tasks$")
    public void filters_the_list_to_show_only_tasks(TaskStatus taskStatus) {
        theActorInTheSpotlight().attemptsTo(FilterTask.hasStatus(taskStatus));
    }

    @And("(s)he has completed the task called {string}")
    public void has_completed_the_task_called(String task) {
        theActorInTheSpotlight().attemptsTo(CompletedATask.called(task));
    }

    @Then("(her|his|the) todo list should contain: '{listOfStrings}'")
    public void should_contain_list_tasks(List<String> items) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(items)));
    }

}
