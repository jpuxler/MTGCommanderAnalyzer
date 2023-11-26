package de.puxler.mtgcommanderanalyzer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Set;

@Getter @Setter @ToString
public class DeckInfoEntity {
    private String name;
    private String description;
    private String format;
    private String publicUrl;

    private int drawSpells;
    private int winConSpells;
    private int protectionSpells;
    private Set<String> tags;

    public void addDrawSpell(){
        drawSpells++;
    }

    public void addWinConSpell(){
        winConSpells++;
    }

    public void addProtectionSpell(){
        protectionSpells++;
    }

    @Override
    public String toString(){
        return "DeckInfo: " +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nFormat: " + format +
                "\nPublicUrl: " + publicUrl +
                "\nDraw Spells: " + drawSpells +
                "\nWinCon Spells: " + winConSpells +
                "\nProtection Spells: " + protectionSpells;
    }
}
