package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Token;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DevCard implements Cards {
    private final Set<Token> tokenRequire = new HashSet<>();
    private final Token tokenReduction;
    private final int point;
    private final int level;

    public DevCard(Set<Token> tokenRequire, Token tokenReduction, int point, int level) {
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);

        this.tokenRequire.addAll(tokenRequire);
        this.tokenReduction = tokenReduction;
        this.point = point;
        this.level = level;
    }

    @Override
    public Set<Token> tokenRequire() {
        return tokenRequire;
    }

    @Override
    public Token tokenReduction() {
        return tokenReduction;
    }

    @Override
    public int point() {
        return point;
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public String toString() {
        return "DevCard : \ntokenRequire=" + tokenRequire + "\ntokenReduction=" + tokenReduction + "\npoint=" + point + "\nlevel=" + level;
    }
}
