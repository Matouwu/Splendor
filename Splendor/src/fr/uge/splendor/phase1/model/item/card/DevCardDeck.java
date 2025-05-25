package fr.uge.splendor.phase1.model.item.card;


import java.util.*;

public class DevCardDeck {
    public final List<CardsP1> devCard = new ArrayList<>();

    public DevCardDeck() {
        setListDevCardDeck();
    }

    public void setListDevCardDeck() {
        for (DevCardsP1 card : DevCardsP1.values()) {
            devCard.add(new CardsP1(card.tokenRequire));
        }
        Collections.shuffle(devCard);
    }

    public CardsP1 drawDevCardDeck() {
        if(devCard.isEmpty()) throw new IllegalStateException("DevCards is empty");
        return devCard.removeFirst();
    }
}
