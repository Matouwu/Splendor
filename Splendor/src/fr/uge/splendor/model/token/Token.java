package fr.uge.splendor.model.token;

import java.util.Objects;

public record Token(Color color, int number) {
    public Token {
        Objects.requireNonNull(color);
        if(number < 0) throw new IllegalArgumentException();
    }

    public Color color() {
        return color;
    }
    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return color.toString() + " :"+ number;
    }


}
