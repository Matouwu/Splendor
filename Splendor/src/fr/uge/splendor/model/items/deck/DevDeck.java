package fr.uge.splendor.model.items.deck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.uge.splendor.model.items.card.DevCard;

import java.util.Objects;

public class DevDeck {
	
	private final Map<Integer, List<DevCard>> devDeck = new HashMap<>();

    @Override
    public String toString() {
        return "DevDeck = " + devDeck;
    }
    
    public void addDevCard(DevCard devCard) {
        Objects.requireNonNull(devCard);
        if(devDeck.containsKey(devCard.level())){
            var val = devDeck.get(devCard.level());
            val.add(devCard);
        } else {
            devDeck.put(devCard.level(),List.of(devCard));
        }
    }

   
}
