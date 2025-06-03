package fr.uge.splendor.model.items.deck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.Token;
import java.util.Objects;

public class DevDeck {
	
	private Map<Color, Integer> tokenRequire;
    private final Color tokenReduction;
    private final int prestigePoints;
    private final int level;

    public DevDeck(int level, int prestigePoints, Map<Color, Integer> tokenRequire, Color tokenReduction ) {
        if(prestigePoints < 0 || level < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);

        this.level = level;
        this.prestigePoints = prestigePoints;
        this.tokenRequire = tokenRequire;
        this.tokenReduction = tokenReduction;
    }
    
    private static Map<Color, Integer> convertTokenListToCosts(List<Token> tokens) {
        Map<Color, Integer> costs = new HashMap<>();
        for (Color color : Color.values()) {
            costs.put(color, 0);
        }
        
        for (Token token : tokens) {
            Color color = token.color();
            var quantity = token.number();
            costs.put(color, costs.get(color) + quantity);
        }
        return costs;
    }
    
    
/*    public static List<Token> convertCostsToTokenList(Map<Color, Integer> costs) {
        List<Token> tokens = new ArrayList<>();
        
        for (Map.Entry<Color, Integer> entry : costs.entrySet()) {
            if (entry.getValue() > 0) {
                tokens.add(new Token(entry.getKey(), entry.getValue()));
            }
        }
        
        return tokens;
    }*/
    
    
    public boolean canBePurchasedBy(Map<Color, Integer> playerTokens, Map<Color, Integer> costs) {
     
    		for (Map.Entry<Color, Integer> cost : costs.entrySet()) {
    		Color color = cost.getKey();
    		var required = cost.getValue();
    		var available = playerTokens.getOrDefault(color, 0) + costs.getOrDefault(color, 0);

    		if (available < required) {
    				return false;
    			}
    		}
    		return true;
    }
    
    
    @Override
    public String toString() {
        return "DevDeck : [level= " + level + "; prestigePoints= " + prestigePoints + "; tokenRequire= " + tokenRequire + "; tokenReduction= " + tokenReduction + "]";
    }
}
