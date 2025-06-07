package fr.uge.splendor.model.items.deck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.utils.LoadCSV;

public class DevDeck {
    private final Map<Integer, List<DevCard>> devDeck = new HashMap<>();

    @Override
    public String toString() {
        return "DevDeck = " + devDeck;
    }

    public void addDevCard(DevCard devCard) {
        Objects.requireNonNull(devCard);
        if (devDeck.containsKey(devCard.level())) {
            var val = devDeck.get(devCard.level());
            val.add(devCard);
        } else {
            List<DevCard> newList = new ArrayList<>();
            newList.add(devCard);
            devDeck.put(devCard.level(), newList);
        }
    }

    public void loadAllCards() throws IOException {
        Map<Integer, List<DevCard>> loadedCards = LoadCSV.loadCardFromCSV();
        for (var entry : loadedCards.entrySet()) {
            for (DevCard card : entry.getValue()) {
                addDevCard(card);
            }
        }
    }
    
    public List<DevCard> getCardsByLevel(int level) {
        return devDeck.getOrDefault(level, new ArrayList<>());
    }
    
    public boolean isEmpty() {
        return devDeck.values().stream().allMatch(List::isEmpty);
    }
}