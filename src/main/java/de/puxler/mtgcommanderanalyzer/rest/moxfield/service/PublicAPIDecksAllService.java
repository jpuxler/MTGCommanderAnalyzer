package de.puxler.mtgcommanderanalyzer.rest.moxfield.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Map;

import static de.puxler.mtgcommanderanalyzer.util.StringToMapConverter.getMapOutOfString;

@Service
public class PublicAPIDecksAllService {
    public void createCsvOutOfDeckJson(String forObject){
        Gson gson = new Gson();

        String bsp = "{Body Count=[Draw], Corrupted Conviction=[Draw], Deadly Dispute=[Draw], Sign in Blood=[Draw], Village Rites=[Draw], Dawn of a New Age=[Draw*], Folk Hero=[Draw*], Herald's Horn=[Draw*], Palantír of Orthanc=[Draw*], Skullclamp=[Draw*], Staff of the Storyteller=[Draw*], Vanquisher's Banner=[Draw*, Lord], Ao, the Dawn Sky=[Lord], Celestial Crusader=[Lord], Drogskol Reinforcements=[Lord], Flowering of the White Tree=[Lord], Heraldic Banner=[Lord, Ramp], Inspiring Leader=[Lord], Intangible Virtue=[Lord], Invasion of Tolvada // The Broken Sky=[Lord, Token*], Defiant Strike=[Draw+, Protection], Niveous Wisps=[Draw+, Protection], Aether Shockwave=[Protection, WinCon], Cauldron Haze=[Protection], Clever Concealment=[Protection], Eerie Interlude=[Protection], Embolden=[Protection], Guardian of Faith=[Protection], Heaven's Gate=[Protection], Scapegoat=[Protection], Selfless Spirit=[Protection], Semester's End=[Protection], Teferi's Protection=[Protection], Touch of Darkness=[Protection], Bojuka Bog=[Land], Brightclimb Pathway // Grimclimb Pathway=[Land], Castle Locthwain=[Land], Cavern of Souls=[Land], Caves of Koilos=[Land], Command Tower=[Land], Eiganjo, Seat of the Empire=[Land], Fetid Heath=[Land], Godless Shrine=[Land], Isolated Chapel=[Land], Minas Tirith=[Land], Orzhov Basilica=[Land], Path of Ancestry=[Land], Plains=[Land], Reliquary Tower=[Land], Secluded Courtyard=[Land], Swamp=[Land], Takenuma, Abandoned Mire=[Land], Temple of Silence=[Land], Vault of Champions=[Land], Vault of the Archangel=[Land], Windbrisk Heights=[Land], Arcane Signet=[Ramp], Orzhov Signet=[Ramp], Talisman of Hierarchy=[Ramp], Wand of the Worldsoul=[Ramp], Kaya the Inexorable=[Token*, Removal], Andúril, Flame of the West=[Token*], Clarion Spirit=[Token*], Haunted Library=[Token*], Twilight Drover=[Token*], Akroma's Will=[WinCon], Katilda, Dawnhart Martyr // Katilda's Rising Dawn=[WinCon], Mirror Entity=[WinCon], Moonshaker Cavalry=[WinCon], Virtue of Loyalty // Ardenvale Fealty=[WinCon], Voice of the Blessed=[WinCon], Generous Gift=[Removal], Horobi, Death's Wail=[Removal], Invasion of New Capenna // Holy Frazzle-Cannon=[Removal, Support], Path to Exile=[Removal], Release to Memory=[Removal], Shrouded Shepherd // Cleave Shadows=[Removal], Stroke of Midnight=[Removal], Swords to Plowshares=[Removal], Drogskol Cavalry=[Support, Token], Drumbellower=[Support], Faithbound Judge // Sinner's Judgment=[Support], Kami of False Hope=[Support], Kaya, Geist Hunter=[Support], Windborn Muse=[Support], Anointed Procession=[Token], Hanged Executioner=[Token], Idol of Oblivion=[Token], Myojin of Blooming Dawn=[Token], Shadow Summoning=[Token]}";

        var map = gson.fromJson(forObject, Map.class);
        Object authorTags = map.get("authorTags");
        System.out.println(authorTags.toString());
        Map<String, String> mapOutOfString = getMapOutOfString(bsp);



    }
}
