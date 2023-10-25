package de.puxler.mtgcommanderanalyzer.rest.moxfield.service;

import com.google.gson.Gson;
import de.puxler.mtgcommanderanalyzer.entity.DeckInfoEntity;
import de.puxler.mtgcommanderanalyzer.util.RessourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static de.puxler.mtgcommanderanalyzer.util.StringToMapConverter.getMapOutOfString;

@Service
public class PublicAPIDecksAllService {
    public static final String AUTHOR_TAGS = "authorTags";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String FORMAT = "format";
    public static final String PUBLIC_URL = "publicUrl";
    private final DeckInfoEntity deckInfoEntity;
    private Map<String, String> mtgDeckMetadataMap;

    public PublicAPIDecksAllService(){
        deckInfoEntity = new DeckInfoEntity();
    }
    public void evaluateMTGCommanderDeck(String deckId) {
        moxfieldCallWithDeckIdForMetadata(deckId);
        persistDeckInformation();
        evaluateTagsFromDeck();
    }

    private void moxfieldCallWithDeckIdForMetadata(String deckId) {
        Gson gson = new Gson();
        mtgDeckMetadataMap = gson.fromJson(new RestTemplate().getForObject(
                RessourceLoader.getValueFromKey("moxfield")+ deckId, String.class
        ), Map.class);
    }

    private void persistDeckInformation() {
        deckInfoEntity.setName(getInformation(NAME));
        deckInfoEntity.setDescription(getInformation(DESCRIPTION));
        deckInfoEntity.setFormat(getInformation(FORMAT));
        deckInfoEntity.setPublicUrl(getInformation(PUBLIC_URL));
        deckInfoEntity.setTags(getUniqueTags());
    }

    private Set<String> getUniqueTags() {
        return new HashSet<>(createMapOutOfTagsFromDeck().values());
    }

    private Map<String, String> createMapOutOfTagsFromDeck() {
        Object s = mtgDeckMetadataMap.get(AUTHOR_TAGS);
        return getMapOutOfString(s.toString());
    }

    private String getInformation(String key){
        return mtgDeckMetadataMap.get(key);
    }

    private void evaluateTagsFromDeck() {
        Map<String, String> mapOutOfTagsFromDeck = createMapOutOfTagsFromDeck();

        mapOutOfTagsFromDeck.forEach(
                (String k, String v) ->
                {

                }
        );
    }



}

