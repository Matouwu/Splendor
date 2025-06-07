package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.Objects;

public record DevCard(int level, Color tokenReduction, int prestigePoint, TokenDeck tokenRequire, String illustration) {

    public DevCard {
        if (level < 0 ||prestigePoint < 0) throw new IllegalArgumentException();
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);
        Objects.requireNonNull(illustration);
    }

    @Override
    public String toString() {
        return "DevCard (level= " + level +
                ", prestigePoint= " + prestigePoint +
                ", tokenRequire= " + tokenRequire.toString() +
                ", tokenReduction= " + tokenReduction +
                ", illustration= " + illustration +
                ")";
    }
   
}
