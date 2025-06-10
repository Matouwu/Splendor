package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game {
    private final boolean beta;
    private final DevDeck devDeck /*= new DevDeck() */;
    private final NobleDeck nobleDeck;
    private final TokenDeck tokenDeck;

    private final List<Player> playerList;
    private int currentPlayerIndex;

    public Game(DevDeck devDeck, NobleDeck nobleDeck, TokenDeck tokensDeck, List<Player> playerList, int currentPlayerIndex, boolean beta) {
        Objects.requireNonNull(devDeck);
        Objects.requireNonNull(tokensDeck);
        Objects.requireNonNull(playerList);
        if(currentPlayerIndex<0 || currentPlayerIndex>playerList.size()) throw new IllegalArgumentException("Wrong starter player.");

        this.devDeck = devDeck;
        this.beta = beta;
        if(beta){
            this.nobleDeck = null;
        } else {
            this.nobleDeck = nobleDeck;
        }
        this.tokenDeck = tokensDeck;
        this.playerList = playerList;
        this.currentPlayerIndex = currentPlayerIndex;
    }
    public DevDeck getDevDeck() {
        return devDeck;
    }
    public TokenDeck getTokenDeck(){
        return tokenDeck;
    }
    public List<Player> getPlayerList(){
        return playerList;
    }

    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }

    public void nextPlayer() {
        this.currentPlayerIndex = (currentPlayerIndex + 1)% playerList.size();
    }

    public int checkGameEnd() {
        for(var p: playerList) {
            if(p.getPrestigePoint() >= 15) {
                return playerList.indexOf(p);
            }
        }
        return -1;
    }



    @Override
    public String toString(){
        String string = devDeck.getDevDeck().entrySet().stream()
                .map(entry -> "level " + entry.getKey() + ": " + entry.getValue().stream().limit(4))
                .collect(Collectors.joining("\n","DevDeck= {\n","}"));
        if(!beta){
            string += "NobleDeck= " + nobleDeck.toString();
        }
        string += "TokenDeck= " + tokenDeck.toString();
        return string;
    }
}
