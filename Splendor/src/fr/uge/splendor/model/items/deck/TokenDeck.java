package fr.uge.splendor.model.items.deck;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import fr.uge.splendor.model.items.Color;

public class TokenDeck {
	private final Map<Color, Integer> tokenDeck;

    public TokenDeck(Map<Color, Integer> tokenDeck){
        Objects.requireNonNull(tokenDeck);
        this.tokenDeck = tokenDeck;
    }

    public Map<Color, Integer> getTokens(){
		return tokenDeck;
    }

    public void addTokenDeck(Color color, int amount) {
        Objects.requireNonNull(color);
        tokenDeck.put(color, tokenDeck.get(color)+ amount);
    }

    public void removeTokenDeck(Color color) {
        Objects.requireNonNull(color);
        if(tokenDeck.get(color) < 0) throw new IllegalArgumentException();
        tokenDeck.put(color, tokenDeck.get(color)-1);
    }

    /* Game Board Deck */

    public void initBoardTokenDeck(int nbPlayer, boolean beta) {
        for(var color:Color.values()){
            if(!color.equals(Color.YELLOW)) {
                if(nbPlayer==4){
                    tokenDeck.put(color, 7);
                } else {
                    tokenDeck.put(color, nbPlayer + 2);
                }
            }
        }

        if(!beta){
            tokenDeck.put(Color.YELLOW, 5);
        }
    }

    @Override
    public String toString(){
        return tokenDeck.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
    }
}
