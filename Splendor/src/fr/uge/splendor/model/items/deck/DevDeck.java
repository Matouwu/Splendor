package fr.uge.splendor.model.items.deck;

import fr.uge.splendor.model.items.card.DevCard;
import java.util.*;
import java.util.stream.Collectors;

public class DevDeck {
    private final Map<Integer, List<DevCard>> devDeck = new HashMap<>();

    public DevDeck(){
        for(int i=0; i<3; i++){
            devDeck.put(i+1, new ArrayList<>());
        }
    }

    @Override
    public String toString() {
        return devDeck.entrySet().stream()
                .map(entry -> "level " + entry.getKey() + "= " + entry.getValue())
                .collect(Collectors.joining("\n", "DevDeck : {", "}"));
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
