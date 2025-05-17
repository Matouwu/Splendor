package fr.uge.splendor.model.token;

import java.util.Objects;

public record Token(Color token) {
    public Token {
        Objects.requireNonNull(token);
    }
}
