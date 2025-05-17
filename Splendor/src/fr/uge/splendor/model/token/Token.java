package fr.uge.splendor.model.token;

import java.util.Objects;

public record Token(Color token) {
	
    public Token {
        Objects.requireNonNull(token);
    }
    public Color color() {
        return token;
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
