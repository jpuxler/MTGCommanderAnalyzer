package de.puxler.mtgcommanderanalyzer.util;

import java.util.ResourceBundle;

public class RessourceLoader {

    private RessourceLoader(){

    }

    public static String getValueFromKey(String key){
        return ResourceBundle.getBundle("uri")
                .getString(key);
    }
}
