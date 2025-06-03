package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public record DevCard(int level, int prestigePoints, Map<Color, Integer> tokenRequire, Color tokenReduction, String illustration) {
	
    public DevCard {
        if (level < 0 ||prestigePoints < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);
        Objects.requireNonNull(illustration);
    }
   
}
