package Cucumber;

import io.cucumber.java.ParameterType;

import java.util.Arrays;
import java.util.List;

public class ParameterTypes {

    @ParameterType("(?:[^,]*)(?:,\\s?[^,]*)*")
    public List<String> listOfStrings(String arg) {
        return Arrays.asList(arg.split(",\\s?"));
    }
}
