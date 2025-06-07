package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private final DevDeck devDeck /*= new DevDeck() */;
    private final NobleDeck nobleDeck;
    private final TokenDeck tokenDeck;

    private final List<Player> playerList;
    private int currentPlayerIndex;

    public Game(DevDeck devDeck, NobleDeck nobleDeck, TokenDeck tokensDeck, List<Player> playerList, int currentPlayerIndex) {
        Objects.requireNonNull(devDeck);
        Objects.requireNonNull(nobleDeck);
        Objects.requireNonNull(tokensDeck);
        Objects.requireNonNull(playerList);
        if(currentPlayerIndex<0 || currentPlayerIndex>playerList.size()) throw new IllegalArgumentException("Wrong starter player.");

        this.devDeck = devDeck;
        this.nobleDeck = nobleDeck;
        this.tokenDeck = tokensDeck;
        this.playerList = playerList;
        this.currentPlayerIndex = currentPlayerIndex;
    }


}
