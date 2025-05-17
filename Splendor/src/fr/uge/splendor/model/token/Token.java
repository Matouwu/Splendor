package fr.uge.splendor.model.token;

import fr.uge.splendor.model.token.Color;
import java.util.Objects;

public record Token(Color color) {
	
    public Token {
        Objects.requireNonNull(color);
    }
    public Color color() {
        return color;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
