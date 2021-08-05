package Serenity.Questions;

import Serenity.Pages.BackBonePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class DisplayedItems implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text
                .of(BackBonePage.ITEMS)
                .viewedBy(actor)
                .asList();
    }
}
