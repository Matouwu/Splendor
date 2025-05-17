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
    private final Map<Color, Integer> tokens;

    public Player(String name) {
    	
        Objects.requireNonNull(name);
        
        this.name = name;
        this.cardsList = new ArrayList<>(); 
        this.tokens = new  HashMap<>();
    }
    
    public String name() {
    	return name; 
    }
    
    
    public void addToken(Token token) {
    	Color color= token.colorToken(); 
    	tokens.put(color, tokens.get(color));
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

    
    @Override
    public String toString() {
    	 return "Player " + name + " - Prestige: " + prestigePoints();
    }
    
    
}
