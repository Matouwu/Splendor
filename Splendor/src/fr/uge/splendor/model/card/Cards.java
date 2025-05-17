package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Color;

import java.util.Map;

public interface Cards {
    Map<Color, Integer> tokenRequire();
    Color tokenReduction();
    int prestigePoints();
    int level();
}
