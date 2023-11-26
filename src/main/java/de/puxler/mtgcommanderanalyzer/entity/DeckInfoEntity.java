package de.puxler.mtgcommanderanalyzer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Set;

@Getter @Setter @ToString
public class DeckInfoEntity {
    private String name;
    private String description;
    private String format;
    private String publicUrl;

    private Set<String> tags;
    private HashMap<String, Integer> ammountOfTags = new HashMap<>();

    @Override
    public String toString(){
        return "DeckInfo: " +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nFormat: " + format +
                "\nPublicUrl: " + publicUrl +
                "\nAmmount of Tags: " + ammountOfTags;
    }
}
