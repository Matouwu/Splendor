package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.Color;

import java.util.Map;
import java.util.Objects;

public record NobleCard(String name, int prestigePoints, Map<Color, Integer> tokenRequire) {
	
    public NobleCard {
        Objects.requireNonNull(name);
        if (prestigePoints < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
    }


}
