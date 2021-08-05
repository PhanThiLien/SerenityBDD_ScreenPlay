package StepDefinition;

import Serenity.Models.TaskStatus;

import java.util.Arrays;
import java.util.List;

public class ParameterType {

    //(?:[^,]*) group all letter without ,. Example: lien,phan,thi => lien -- phan -- thi

    @io.cucumber.java.ParameterType("(?:[^,]*)(?:,\\s?[^,]*)*")
    public List<String> listOfStrings(String arg) {
        return Arrays.asList(arg.split(",\\s?"));
    }

}
