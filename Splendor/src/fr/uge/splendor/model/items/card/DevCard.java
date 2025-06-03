package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.Color;

import java.util.Map;
import java.util.Objects;

public record DevCard(int level, int prestigePoints, Map<Color, Integer> tokenRequire, Color tokenReduction) {
    public DevCard {
        if (level < 0 ||prestigePoints < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);
    }
}
