package fr.uge.splendor.model.items.deck;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.utils.LoadCSV;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DevDeck {
    private Map<Integer, List<DevCard>> devDeck = new HashMap<>();
    private final boolean mode;

    public DevDeck(boolean mode){
        this.mode = mode;
    }

    public Map<Integer, List<DevCard>> getDevDeck(){
        return this.devDeck;
    }

    public void addDevCard(DevCard devCard) {
        Objects.requireNonNull(devCard);
        if(devDeck.containsKey(devCard.level())){
            var val = devDeck.get(devCard.level());
            val.add(devCard);
        } else {
            List<DevCard> list = new ArrayList<>();
            list.add(devCard);
            devDeck.put(devCard.level(),list);
        }
    }

    public DevCard removeDevCard(int level, int index){
        if(index<0 || index>4){
            return null;
        }
        return devDeck.get(level).remove(index-1);
    }

    /* Game Board Deck */
    public void loadAllCards() throws IOException {
        this.devDeck = LoadCSV.loadCardFromCSV();
        for(var list: devDeck.values()){
            Collections.shuffle(list);
        }
    }
    public void loadBetaCards(){
        for(var color : Color.values()){
            for(int i=0; i<8; i++){
                if(!color.equals(Color.YELLOW)) {
                    Map<Color, Integer> map = new HashMap<>();
                    map.put(color, 3);
                    addDevCard(new DevCard(0, null, 1, new TokenDeck(map), "", true));
                }
            }
        }
        for(var list: devDeck.values()){
            Collections.shuffle(list);
        }
    }

    @Override
    public String toString() {
        if(mode){
            return devDeck.values().toString();
        }
        return devDeck.entrySet().stream()
                .map(entry -> "level " + entry.getKey() + "= " + entry.getValue())
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
