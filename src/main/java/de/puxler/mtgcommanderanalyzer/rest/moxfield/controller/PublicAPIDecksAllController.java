package de.puxler.mtgcommanderanalyzer.rest.moxfield.controller;

import de.puxler.mtgcommanderanalyzer.rest.moxfield.service.PublicAPIDecksAllService;
import de.puxler.mtgcommanderanalyzer.util.RessourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/moxfield/decks/info")
public class PublicAPIDecksAllController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicAPIDecksAllController.class.getName());

    private final PublicAPIDecksAllService publicAPIDecksAllService;

    @Autowired
    public PublicAPIDecksAllController(PublicAPIDecksAllService publicAPIDecksAllService){
        this.publicAPIDecksAllService = publicAPIDecksAllService;
    }

    @GetMapping("/deckId/{deckId}")
    public void getDeckInfoWithId(@PathVariable String deckId) {
        LOGGER.info("Call getDeckInfoWithId with ID: {}", deckId);
        this.publicAPIDecksAllService.evaluateMTGCommanderDeck(deckId);
    }


}
