package fr.uge.splendor.model.items.card;


import java.util.*;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.deck.TokenDeck;

import static fr.uge.splendor.model.items.Color.*;

public enum Noble {
	
    CATHERINE_DE_MEDICI ("Catherine de' Medici", Map.of(Color.GREEN, 3, Color.BLUE, 3, Color.RED, 3), 3),
    ELISABETH_OF_AUSTRIA ("Elisabeth Of Austria", Map.of(Color.BLACK, 3, Color.BLUE, 3, Color.WHITE, 3), 3),
    ISABELLA_I_OF_CASTILE ("Isabella I Of Castile", Map.of(Color.BLACK, 4, Color.WHITE, 4), 3),
    NICCOLO_MACHIAVELLI ("Niccolò Machiavelli", Map.of(Color.BLUE, 4, Color.WHITE, 4), 3),
    SULEIMAN_THE_MAGNIFICENT ("Suleiman The Magnificent", Map.of(Color.BLUE, 4, Color.GREEN, 4), 3),
    ANNE_OF_BRITTANY ("Anne Of Brittany", Map.of(Color.GREEN, 3, Color.BLUE, 3, Color.WHITE, 3), 3),
    CHARLES_V ("Charles V", Map.of(Color.BLACK, 3, Color.RED, 3, Color.WHITE, 3), 3),
    FRANCIS_I_OF_FRANCE ("Francis I Of France", Map.of(Color.BLACK, 3, Color.RED, 3, Color.GREEN, 3), 3),
    HENRY_VII ("Henry VII", Map.of(Color.BLACK, 4, Color.RED, 4), 3),
    MARY_STUART ("Mary Stuart", Map.of(Color.RED, 4, Color.GREEN, 4), 3);

    private final String name;
    private final TokenDeck tokenRequire;
    private final int prestigePoints;
    private final Color color; 
    
    public Noble(String name, TokenDeck tokenRequire, int prestigePoints) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tokenRequire);
        if (prestigePoints < 0) throw new IllegalArgumentException();
        this.name = name;
        //this.tokenRequire.putAll(tokenRequire); // a modifier 
        this.tokenRequire.addTokenDeck(color, prestigePoints);
        this.prestigePoints = prestigePoints;
    }

    public List<NobleCard> listNobleCards() {
        List<NobleCard> nobleCards = new ArrayList<>();
        for (Noble noble : Noble.values()) {
            nobleCards.add(new NobleCard(noble.name, noble.tokenRequire, noble.prestigePoints));
        }
        return List.copyOf(nobleCards);
    }
    
}
