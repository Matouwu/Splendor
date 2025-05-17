package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Token;

import java.util.Set;

public interface Cards {
    Set<Token> tokenRequire();
    Token tokenReduction();
    int point();
    int level();
}
