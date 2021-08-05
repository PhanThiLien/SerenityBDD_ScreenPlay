package Serenity.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://todomvc.com")
public class HomePage extends PageObject {

    public static Target BackBoneItem = Target.the("BackBone.js link").located(new By.ByLinkText("Backbone.js"));

}
