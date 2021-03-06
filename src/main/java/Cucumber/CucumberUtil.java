package Cucumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CucumberUtil {
    public static synchronized List<String> TableDictionaryConverter(List<String> data) {
        List<String> mapTable = new ArrayList<>();
        mapTable.addAll(data);
        return mapTable;
    }

    public static synchronized Map<String, String> TableWithHeaderDictionaryConverter(List<List<String>> data) {
        Map<String, String> mapTable = new HashMap<>();
        for(List<String> rows: data) {
            mapTable.put(rows.get(0), rows.get(1));
        }
        return mapTable;
    }
}
