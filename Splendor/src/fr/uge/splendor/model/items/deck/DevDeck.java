package fr.uge.splendor.model.items.deck;


import fr.uge.splendor.model.items.card.DevCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DevDeck {
    private Map<Integer, DevCard> devDeck = new HashMap<>();
    @Override
    public String toString() {
        return "DevDeck: {" + devDeck.toString() + "}";
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
