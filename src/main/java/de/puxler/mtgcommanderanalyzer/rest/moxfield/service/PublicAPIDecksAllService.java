package de.puxler.mtgcommanderanalyzer.rest.moxfield.service;

import com.google.gson.Gson;
import de.puxler.mtgcommanderanalyzer.entity.DeckInfoEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static de.puxler.mtgcommanderanalyzer.util.StringToMapConverter.getMapOutOfString;

@Service
public class PublicAPIDecksAllService {




    public void createCsvOutOfDeckJson(String forObject){
        Gson gson = new Gson();


        var map = gson.fromJson(forObject, Map.class);
        Object authorTags = map.get("authorTags");

        DeckInfoEntity deckInfoEntity = new DeckInfoEntity();
        deckInfoEntity.setName(map.get("name").toString());
        deckInfoEntity.setDescription(map.get("description").toString());
        deckInfoEntity.setFormat(map.get("format").toString());
        deckInfoEntity.setPublicUrl(map.get("publicUrl").toString());

        Map<String, String> mapOutOfString = getMapOutOfString(authorTags.toString());

        mapOutOfString.forEach(
                (String key, String value) ->
                {
                    if(value.contains("Draw")){
                        deckInfoEntity.addDrawSpell();
                    }
                    if(value.contains("WinCon")){
                        deckInfoEntity.addWinConSpell();
                    }
                    if(value.contains("Protection")){
                        deckInfoEntity.addProtectionSpell();
                    }
                }
        );


        System.out.println("Draw Spell: " + deckInfoEntity.getDrawSpells());
        System.out.println("WinCon Spell: " + deckInfoEntity.getWinConSpells());
        System.out.println("Protection Spell: " + deckInfoEntity.getProtectionSpells());



    }

    public Set<String> getUniqueTags(String forObject) {
        Gson gson = new Gson();
        var map = gson.fromJson(forObject, Map.class);
        Object authorTags = map.get("authorTags");
        Map<String, String> mapOutOfString = getMapOutOfString(authorTags.toString());
        return new HashSet<>(mapOutOfString.values());
    }

    public Map<String, Integer> createMapOutOfTags(Set<String> uniqueTags){
        Map<String, Integer> deckAnalytics = new HashMap<>();
        uniqueTags.forEach(tag ->
                        deckAnalytics.put(tag, 0)
                );
        return deckAnalytics;

    }

    public Map<String, Integer> analyzeDeckWithMatchingTags(String forObject, Map<String, Integer> mapOutOfTags) {
        Gson gson = new Gson();
        var map = gson.fromJson(forObject, Map.class);
        Object authorTags = map.get("authorTags");

        Map<String, String> mapOutOfString = getMapOutOfString(authorTags.toString());

        mapOutOfString.forEach(
                (String cardName, String tag) ->
                {
                    mapOutOfTags.forEach(
                            (String key, Integer value) ->
                            {
                                System.out.println(tag + " : " + key);
                                if(tag.contains(key)){
                                    mapOutOfTags.put(key, ++value);
                                }
                            }
                    );
                }
        );
        return mapOutOfTags;
    }

    private int increaseValueByOne(int value){
        return value++;
    }
}

