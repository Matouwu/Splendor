package fr.uge.splendor.model.items.deck;

import fr.uge.splendor.model.items.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DevDeck {
	
	private Map<Color, Integer> tokenRequire = new HashMap<>();
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

    public Map<Color, Integer> tokenRequire() {
        return tokenRequire;
    }

    public Color tokenReduction() {
        return tokenReduction;
    }

    public int prestigePoints() {
        return prestigePoints;
    }

    public int level() {
        return level;
    }

    @Override
    public String toString() {
        return "DevDeck : [level= " + level + "; prestigePoints= " + prestigePoints + "; tokenRequire= " + tokenRequire + "; tokenReduction= " + tokenReduction + "]";
    }
}
