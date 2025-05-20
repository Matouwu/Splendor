package fr.uge.splendor.phase1.model;

import fr.uge.splendor.model.token.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CardP1 {
    private final Map<Color, Integer> tokenRequire = new HashMap<>();
    private final int prestigePoints;
    private final int level;

    public CardP1(Map<Color, Integer> tokenRequire) {
        Objects.requireNonNull(tokenRequire);

        this.tokenRequire.putAll(tokenRequire);
        this.prestigePoints = 1;
        this.level = 1;
    }

}
