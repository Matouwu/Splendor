package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Map<Integer, DevDeck> devDeck = new HashMap<>();
    private final TokenDeck tokenDeck = new TokenDeck();

}
