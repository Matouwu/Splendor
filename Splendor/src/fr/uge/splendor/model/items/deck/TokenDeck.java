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

    public void initBoardTokenDeck() {
        tokenDeck.put(Color.GREEN, 4);
        tokenDeck.put(Color.BLUE, 4);
        tokenDeck.put(Color.RED, 4);
        tokenDeck.put(Color.WHITE, 4);
        tokenDeck.put(Color.BLACK, 4);
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

    @Override
    public String toString(){
        return tokenDeck.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
    }
}
