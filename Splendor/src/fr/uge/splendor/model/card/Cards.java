package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Token;

import java.util.Map;
import java.util.Set;

public interface Cards {
    Map<Token, Integer> tokenRequire();
    Token tokenReduction();
    int prestigePoints();
    int level();
}
