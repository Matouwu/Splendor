package fr.uge.splendor.model.card;


import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;

import java.util.*;


public enum Noble {
    CATHERINE_DE_MEDICI ("Catherine de' Medici", Map.of(GREEN, 3, BLUE, 3, RED, 3), 3),
    ELISABETH_OF_AUSTRIA ("Elisabeth Of Austria", Map.of(BLACK, 3, BLUE, 3, WHITE, 3), 3),
    ISABELLA_I_OF_CASTILE ("Isabella I Of Castile", Map.of(BLACK, 4, WHITE, 4), 3),
    NICCOLO_MACHIAVELLI ("Niccolò Machiavelli", Map.of(BLUE, 4, WHITE, 4), 3),
    SULEIMAN_THE_MAGNIFICENT ("Suleiman The Magnificent", Map.of(BLUE, 4, GREEN, 4), 3),
    ANNE_OF_BRITTANY ("Anne Of Brittany", Map.of(GREEN, 3, BLUE, 3, WHITE, 3), 3),
    CHARLES_V ("Charles V", Map.of(BLACK, 3, RED, 3, WHITE, 3), 3),
    FRANCIS_I_OF_FRANCE ("Francis I Of France", Map.of(BLACK, 3, RED, 3, GREEN, 3), 3),
    HENRY_VII ("Henry VII", Map.of(BLACK, 4, RED, 4), 3),
    MARY_STUART ("Mary Stuart", Map.of(RED, 4, GREEN, 4), 3);

    private final String name;
    private final Map<Color, Integer> tokenRequire = new HashMap<>();
    private final int prestigePoints;

    Noble(String name, Map<Color, Integer> tokenRequire, int prestigePoints) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tokenRequire);
        if (prestigePoints < 0) throw new IllegalArgumentException();

        this.name = name;
        this.tokenRequire.putAll(tokenRequire);
        this.prestigePoints = prestigePoints;
    }

    public List<NobleCard> listNobleCards() {
        List<NobleCard> nobleCards = new ArrayList<>();
        for (Noble noble : Noble.values()) {
            nobleCards.add(new NobleCard(noble.name,noble.tokenRequire,noble.prestigePoints));
        }
        return List.copyOf(nobleCards);
    }
}
