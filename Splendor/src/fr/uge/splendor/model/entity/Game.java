package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final DevDeck devDeck = new DevDeck() ;
    private final TokenDeck tokenDeck;

    private final List<Player> playerList = new ArrayList<>();
    private int currentPlayerIndex;

    public Game(TokenDeck tokensDeck) {
        Objects.requireNonNull(tokensDeck);
        this.tokenDeck = tokensDeck;

    }


}
