package fr.uge.splendor.model.items.deck;

import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.utils.LoadCSV;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DevDeck {
    private Map<Integer, List<DevCard>> devDeck = new HashMap<>();

    public DevDeck(){
        for(int i=0; i<3; i++){
            devDeck.put(i+1, new ArrayList<>());
        }
    }
    public Map<Integer, List<DevCard>> getDevDeck(){
        return this.devDeck;
    }

    public boolean addDevCard(DevCard devCard) {
        Objects.requireNonNull(devCard);
        if(!devDeck.containsKey(devCard.level())) return false;
        var val = devDeck.get(devCard.level());
        val.add(devCard);
        return true;
    }

    public boolean removeDevCard(DevCard devCard){
        Objects.requireNonNull(devCard);
        var devList = devDeck.get(devCard.level());
        if(devList == null || !devList.contains(devCard)) return false;
        return devDeck.get(devCard.level()).remove(devCard);
    }

    /* Game Board Deck */
    public void loadAllCards() throws IOException {
        this.devDeck = LoadCSV.loadCardFromCSV();
        for(var list: devDeck.values()){
            Collections.shuffle(list);
        }
    }





/*
    public CardsP1 drawDevCardDeck() {
        if(devCard.isEmpty()) throw new IllegalStateException("DevCards is empty");
        return devCard.removeFirst();
    }*/
    @Override
    public String toString() {
        return devDeck.entrySet().stream()
                .map(entry -> "level " + entry.getKey() + "= " + entry.getValue())
                .collect(Collectors.joining(", ", "DevDeck : {", "}"));
    }
}
