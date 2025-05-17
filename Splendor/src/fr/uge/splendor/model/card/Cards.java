package fr.uge.splendor.model.card;

import java.util.Map;

public interface Cards {
    Map<Token, Integer> tokenRequire();
    Token tokenReduction();
    int prestigePoints();
    int level();
}
