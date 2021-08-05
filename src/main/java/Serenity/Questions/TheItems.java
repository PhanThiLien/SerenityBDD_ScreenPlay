package Serenity.Questions;

import net.serenitybdd.screenplay.Question;

import java.util.List;

public class TheItems {

    public static Question<List<String>> displayed() {
        return new DisplayedItems();
    }
}
