package Serenity.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://todomvc.com/examples/backbone/")
public class BackBonePage extends PageObject {

    public static Target WHAT_NEEDS_TO_BE_DONE = Target.the("'What needs to be done?' field").locatedBy(".new-todo");

    public static Target ITEMS = Target.the("List of todo items").locatedBy("li:not([class ='hidden']) .view label");

    public static Target ITEM_LABEL = Target.the("Item Name").locatedBy("//*[contains(@class,'view')]//label[. ='{0}']");

    public static Target COMPLETE_CHECKBOX = Target.the("Completed item check box").locatedBy("//*[@class='view' and contains(.,'{0}')]//input[@type='checkbox']");

    public static Target FILTER_BUTTON = Target.the("Filter button").locatedBy("//*[@class = 'filters']//a[. = '{0}']");

    public static Target CLEAR_COMPLETED_BUTTON = Target.the("Clear completed button").locatedBy("//*[contains(.,'filters')]//button[contains(@class, 'clear')]");

}
