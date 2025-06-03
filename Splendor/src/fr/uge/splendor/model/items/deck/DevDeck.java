package fr.uge.splendor.model.items.deck;


import fr.uge.splendor.model.items.card.DevCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DevDeck {
    private List<DevCard> devDeck = new ArrayList<>();

    @Override
    public String toString() {
        return "DevDeck : [level= " + level + "; prestigePoints= " + prestigePoints + "; tokenRequire= " + tokenRequire + "; tokenReduction= " + tokenReduction + "]";
    }

    public boolean isEmpty() {
        return devDeck.isEmpty();
    }

    public void setListDevCardDeck() {
        for (var card : devDeck) {
            devDeck.add(new DevCard(card.tokenRequire()));
        }
        Collections.shuffle(devCard);
    }

    public CardsP1 drawDevCardDeck() {
        if(devCard.isEmpty()) throw new IllegalStateException("DevCards is empty");
        return devCard.removeFirst();
    }
}
