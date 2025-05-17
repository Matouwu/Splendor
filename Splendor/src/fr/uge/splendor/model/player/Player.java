package fr.uge.splendor.model.player;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.token.Color;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Player {

    private final String name;
    private final List<Cards> cardsList;
    private final Map<Color, Integer> tokens;

    public Player(String name, List<Cards> cardsList, Map<Color, Integer> tokens) {
        Objects.requireNonNull(name);
        this.name = name;
        this.cardsList = cardsList;
        this.tokens = tokens;
    }
}
