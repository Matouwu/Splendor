package fr.uge.splendor.phase1.model.card;

import fr.uge.splendor.model.token.Token;

import java.util.*;

public class CardP1 {
    private List<Token> tokenRequire = new ArrayList<>();
    private final int prestigePoints;
    private final int level;

    public CardP1(List<Token> tokenRequire) {
        Objects.requireNonNull(tokenRequire);

        this.tokenRequire = List.copyOf(tokenRequire);
        this.prestigePoints = 1;
        this.level = 1;
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }


}
