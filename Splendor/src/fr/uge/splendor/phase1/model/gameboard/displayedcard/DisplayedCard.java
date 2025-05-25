package fr.uge.splendor.phase1.model.gameboard.displayedcard;

import fr.uge.splendor.phase1.model.item.card.CardsP1;
import fr.uge.splendor.phase1.model.item.card.DevCardDeck;

import java.util.ArrayList;
import java.util.List;

public class DisplayedCard {
    private final List<CardsP1> cardPickaxe = new ArrayList<>();

    public DisplayedCard(DevCardDeck cardDeck) {
        setCardPickaxe(cardDeck);
    }

    public void setCardPickaxe(DevCardDeck cardDeck) {
        try{
            while(cardPickaxe.size() < 4) {
                cardPickaxe.add(cardDeck.drawDevCardDeck());
            }
        } catch (IllegalStateException e) {
            System.out.println("Impossible to play : deck empty !");
        }
    }

}
