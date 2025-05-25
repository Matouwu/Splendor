package fr.uge.splendor.phase1.model.item.token;

import java.util.Objects;

public record TokenP1(ColorP1 colorP1, int number) {
    public TokenP1 {
        Objects.requireNonNull(colorP1);
        if(number < 0) throw new IllegalArgumentException();
    }

    public ColorP1 colorP1() {
        return colorP1;
    }
    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return colorP1.toString() + " :"+ number;
    }

}
