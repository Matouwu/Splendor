package fr.uge.splendor.model.card;


import java.util.*;

public class NobleCard implements Cards {
    private final String name;
    private final Map<Token, Integer> tokenRequire = new HashMap<>();
    private final int prestigePoints;

    public NobleCard(String name, Map<Token, Integer> tokenRequire, int prestigePoints) {
        Objects.requireNonNull(tokenRequire);

        this.name = name;
        this.tokenRequire.putAll(tokenRequire);
        this.prestigePoints = prestigePoints;
    }

    @Override
    public Map<Token, Integer> tokenRequire() {
        return tokenRequire;
    }

    @Override
    public int prestigePoints() {
        return prestigePoints;
    }

    @Override
    public Token tokenReduction() {
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
