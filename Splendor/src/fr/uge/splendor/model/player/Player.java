package fr.uge.splendor.model.player;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.DevCard;
import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Player {

    private final String name;
    private final List<Cards> cardsList;
    private final List<Cards> cardsReservedList; 
    private final Map<Color, Integer> tokens;
    
    private static final int MAX_TOKENS= 10; 

    public Player(String name) {
    	
        Objects.requireNonNull(name);
        
        this.name = name;
        this.cardsList = new ArrayList<>(); 
        this.tokens = new  HashMap<>();
        this.cardsReservedList = new ArrayList<>(); 
    }
    
    public String name() {
    	return name;
    }
    
    
    public void addToken(Token token) {
    	
    	int totalTokens = 0; 
    	
    	for(int count : tokens.values()) {
    		totalTokens += count;
    	}
    	
    	if(totalTokens >= MAX_TOKENS) {
    		throw new IllegalStateException("Le joueur ne peut pas avoir plus de " + MAX_TOKENS);
    	}
    	
    	Color color= token.token(); 
    	tokens.put(color, tokens.getOrDefault(color,0) + 1);
    }
    
    
    public boolean removeToken(Color color) {
    	int count = tokens.getOrDefault(color, 0);
        if (count > 0) {
            tokens.put(color, count - 1);
            return true;
        } else {
            return false;
        }
    }
    

    public List<Cards> cardList() {
        return cardsList;
    }
    
    public int prestigePoints() {
        return cardsList.size();
    }
    
    
    public int tokenCount(Color color) {
    	return tokens.getOrDefault(color,0); 
    }

    
    @Override
    public String toString() {
    	 return "Player " + name + "\nPointPrestige=" + prestigePoints() + "\nToken=" + tokens +  "\nCardList=" + cardsList + "\nCardReserved=" + cardsReservedList;
    }
    
    
}
