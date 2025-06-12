package fr.uge.splendor.model.items.deck;

import java.util.*;
import java.util.stream.Collectors;

import fr.uge.splendor.model.items.card.Noble;
import fr.uge.splendor.model.items.card.NobleCard;

public class NobleDeck {
	private List<NobleCard> nobleDeck = new ArrayList<>();

	public List<NobleCard> getNobleDeck(){
		return nobleDeck;
	}

	public void addNobleCard(NobleCard nobleCard){
		Objects.requireNonNull(nobleCard);
		if(nobleDeck.contains(nobleCard)) throw new IllegalArgumentException("This noble is already in the list.");
		nobleDeck.add(nobleCard);
	}

	public boolean removeNobleCard(NobleCard nobleCard){
		Objects.requireNonNull(nobleCard);
		return nobleDeck.remove(nobleCard);
	}


	/* Game Board Deck */
	public void loadAllNoble(){
		this.nobleDeck = Noble.listNobleCards();
		Collections.shuffle(nobleDeck);
	}

	@Override
	public String toString() {
		return nobleDeck.stream()
				.map(NobleCard::toString)
				.collect(Collectors.joining("\n","[","]"));
	}
}
