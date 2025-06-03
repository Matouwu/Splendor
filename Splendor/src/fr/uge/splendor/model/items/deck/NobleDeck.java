package fr.uge.splendor.model.items.deck;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import fr.uge.splendor.model.items.Color;

public class NobleDeck {
	
		private final String name;
	    private final Map<Color, Integer> tokenRequire = new HashMap<>();
	    private final int prestigePoints;

	    public NobleCard(String name, Map<Color, Integer> tokenRequire, int prestigePoints) {
	    	
	        Objects.requireNonNull(name);
	        Objects.requireNonNull(tokenRequire);
	        if(prestigePoints < 0) throw new IllegalArgumentException();

	        this.name = name;
	        this.tokenRequire.putAll(tokenRequire);
	        this.prestigePoints = prestigePoints;
	    }

	    @Override
	    public Map<Color, Integer> tokenRequire() {
	        return tokenRequire;
	    }

	    @Override
	    public int prestigePoints() {
	        return prestigePoints;
	    }

	    @Override
	    public Color tokenReduction() {
	        return null;
	    }
	    @Override
	    public int level() {
	        return 0;
	    }

	    @Override
	    public String toString() {
	        return "NobleCard " + name + ": \ntokenRequire= [" + tokenRequire + "]\nprestigePoints=" + prestigePoints;
	    }
}
