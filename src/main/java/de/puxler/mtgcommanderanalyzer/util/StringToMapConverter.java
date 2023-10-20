package de.puxler.mtgcommanderanalyzer.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringToMapConverter {
    private StringToMapConverter(){

    }

    public static Map<String, String> getMapOutOfString(String value){
        Map<String, String> result = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(value, ",");

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            String[] keyValue = token.split("=");
            System.out.println(keyValue[0] + ": " + keyValue[1]);
            result.put(keyValue[0], keyValue[1]);
        }
        return result;
    }
}
