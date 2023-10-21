package de.puxler.mtgcommanderanalyzer.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeckInfoEntity {
    private String name;
    private String description;
    private String format;
    private String publicUrl;

    private int drawSpells;
    private int winConSpells;
    private int protectionSpells;

    public void addDrawSpell(){
        drawSpells++;
    }

    public void addWinConSpell(){
        winConSpells++;
    }

    public void addProtectionSpell(){
        protectionSpells++;
    }
    
}
