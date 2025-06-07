package fr.uge.splendor.application;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.Map;

public class Application {
    public static void main(String[] args) {

        DevDeck deck = new DevDeck();
        DevCard c1 = new DevCard(1, Color.BLUE, 2, new TokenDeck(Map.of(Color.BLACK, 1)), "Belle");
        DevCard c2 = new DevCard(2, Color.BLUE, 4, new TokenDeck(Map.of(Color.GREEN, 3)), "Choupette");

        deck.addDevCard(c1);
        deck.addDevCard(c2);
        System.out.println(deck+"\n");

        System.out.println(deck.removeDevCard(c1));
        System.out.println(deck);
    }
}
