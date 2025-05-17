package fr.uge.splendor.model.card;


import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public enum Noble {
    CATHERINE_DE_MEDICI ("Catherine de' Medici", Map.of(GREEN, 3, BLUE, 3, RED, 3), 3),
    ELISABETH_OF_AUSTRIA ("Elisabeth Of Autrisa", Map.of(BLACK, 3, BLUE, 3, WHITE, 3), 3),
    ;

    private final String name;
    private final Map<Color, Integer> tokenRequire;
    private final int prestigePoints;
    Noble(String name, Map<Color, Integer> tokenRequire, int prestigePoints) {
        this.name = name;
        this.tokenRequire = tokenRequire;
        this.prestigePoints = prestigePoints;
    }

    public List<NobleCard> listNobleCards() {
        List<NobleCard> nobleCards = new ArrayList<>();
        for (Noble noble : Noble.values()) {
            nobleCards.add(new NobleCard(name,tokenRequire,prestigePoints));
        }
        return nobleCards;
    }
}
