package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.Objects;

public record NobleCard(String name, int prestigePoints, TokenDeck tokenRequire) {
    public NobleCard {
        Objects.requireNonNull(name);
        if (prestigePoints < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
    }

    @Override
    public String toString() {
        return "NobleCard [name= " + name +
                ", prestigePoints= " + prestigePoints +
                ", tokenRequire= " + tokenRequire +
                "]";
    }

}
