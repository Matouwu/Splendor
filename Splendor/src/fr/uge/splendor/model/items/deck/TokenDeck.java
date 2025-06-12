package fr.uge.splendor.model.items.deck;

import java.util.List;
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

    public Map<Color, Integer> getTokenDeck(){
		return tokenDeck;
    }

    public boolean isEmpty(){
        return tokenDeck.isEmpty();
    }

    public void addTokenDeck(TokenDeck tokenDeck){
        Objects.requireNonNull(tokenDeck);
        for(var token: tokenDeck.getTokenDeck().entrySet()){
            addTokenDeck(token.getKey(), token.getValue());
        }
    }
    public void addTokenDeck(Color color, int amount) {
        Objects.requireNonNull(color);
        if(amount < 0) throw new IllegalArgumentException();
        tokenDeck.put(color, tokenDeck.getOrDefault(color, 0)+ amount);
    }

    public void removeTokenDeck(Color color, int amount) {
        Objects.requireNonNull(color);
        if(tokenDeck.getOrDefault(color, 0) < 0) throw new IllegalArgumentException();
        if(tokenDeck.getOrDefault(color, 0)>=amount){
            tokenDeck.put(color, tokenDeck.getOrDefault(color, 0)-amount);
        }
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
                .map(entry -> entry.getKey().toString().substring(0, 1).toUpperCase() + entry.getKey().toString().substring(1).toLowerCase() + ": " + entry.getValue())
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
