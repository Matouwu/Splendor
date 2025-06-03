package fr.uge.splendor.model.items.deck;


import fr.uge.splendor.model.items.card.DevCard;

import java.util.*;

public class DevDeck {
    private final Map<Integer, List<DevCard>> devDeck = new HashMap<>();

    public boolean addDevCard(DevCard devCard) {
        Objects.requireNonNull(devCard);
        return devDeck.get(devCard.level()).add(devCard);
    }




/*    public boolean isEmpty() {
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
    }*/
}
