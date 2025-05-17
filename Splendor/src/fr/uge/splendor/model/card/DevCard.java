package fr.uge.splendor.model.card;

import java.util.*;

public class DevCard implements Cards {
    private final Map<Token, Integer> tokenRequire = new HashMap<>();
    private final Token tokenReduction;
    private final int prestigePoints;
    private final int level;

    public DevCard(Map<Token, Integer> tokenRequire, Token tokenReduction, int prestigePoints, int level) {
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);

        this.tokenRequire.putAll(tokenRequire);
        this.tokenReduction = tokenReduction;
        this.prestigePoints = prestigePoints;
        this.level = level;
    }

    @Override
    public Map<Token, Integer> tokenRequire() {
        return tokenRequire;
    }

    @Override
    public Token tokenReduction() {
        return tokenReduction;
    }

    @Override
    public int prestigePoints() {
        return prestigePoints;
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public String toString() {
        return "DevCard : \ntokenRequire=" + tokenRequire + "\ntokenReduction=" + tokenReduction + "\nprestigePoints=" + prestigePoints + "\nlevel=" + level;
    }
}
