package fr.uge.splendor.model.items.deck;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import fr.uge.splendor.model.items.Color;

public class NobleDeck {
	
		private final String name;
	    private final Map<Color, Integer> tokenRequire = new HashMap<>();
	    private final int prestigePoints;

	    public NobleDeck(String name, Map<Color, Integer> tokenRequire, int prestigePoints) {
	    	
	        Objects.requireNonNull(name);
	        Objects.requireNonNull(tokenRequire);
	        if(prestigePoints < 0) throw new IllegalArgumentException();

	        this.name = name;
	        this.tokenRequire.putAll(tokenRequire);
	        this.prestigePoints = prestigePoints;
	    }

	    public Map<Color, Integer> tokenRequire() {
	        return tokenRequire;
	    }

	    public int prestigePoints() {
	    	
	        return prestigePoints;
	    }

	    @Override
	    public String toString() {
	        return "NobleCard " + name + ": \ntokenRequire= [" + tokenRequire + "]\nprestigePoints=" + prestigePoints;
	    }
}
