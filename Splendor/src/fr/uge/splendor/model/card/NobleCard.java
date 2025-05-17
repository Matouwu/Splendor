package fr.uge.splendor.model.card;


import fr.uge.splendor.model.token.Color;

import java.util.*;

public class NobleCard implements Cards {
    private final String name;
    private final Map<Color, Integer> tokenRequire = new HashMap<>();
    private final int prestigePoints;

    public NobleCard(String name, Map<Color, Integer> tokenRequire, int prestigePoints) {
        Objects.requireNonNull(tokenRequire);

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
