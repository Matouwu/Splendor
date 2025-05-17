package fr.uge.splendor.model.card;


import fr.uge.splendor.model.token.Token;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NobleCard implements Cards {
    private final Set<Token> tokenRequire = new HashSet<>();
    private final int point;

    public NobleCard(Set<Token> tokenRequire, int point) {
        Objects.requireNonNull(tokenRequire);

        this.tokenRequire.addAll(tokenRequire);
        this.point = point;
    }

    @Override
    public Set<Token> tokenRequire() {
        return tokenRequire;
    }

    @Override
    public int point() {
        return point;
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
        return "NobleCard [tokenRequire=" + tokenRequire + ", point=" + point + "]";
    }
}
