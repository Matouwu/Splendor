package fr.uge.splendor.model.items.deck;

import java.util.*;

import fr.uge.splendor.model.items.card.NobleCard;

public class NobleDeck {
	private List<NobleCard> NobleDeck = new ArrayList<>();
	@Override
	public String toString() {
		return "DevDeck: {" + NobleDeck.toString() + "}";
	}

}
