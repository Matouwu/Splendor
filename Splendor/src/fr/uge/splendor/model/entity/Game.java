package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Game {
    private final Map<Integer, DevDeck> devDeck = new HashMap<>();
    private final TokenDeck tokenDeck;

    public Game(TokenDeck tokensDeck) {
        Objects.requireNonNull(tokensDeck);
        this.tokenDeck = tokensDeck;

    }


}
