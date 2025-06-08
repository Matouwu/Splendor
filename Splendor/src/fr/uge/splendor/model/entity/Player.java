package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.*;

public class Player {
	private final boolean beta;
    private final String name;
    private final int age;
    private int prestigePoint;
    private final TokenDeck tokens;
    private final DevDeck devDeckReserved;
    private final DevDeck devDeck;
    private final NobleDeck nobleDeck;

    public Player(String name, int age, boolean beta) {
        Objects.requireNonNull(name);
        if (age < 0) throw new IllegalArgumentException("Age must be a positive integer.");

        this.name = name;
        this.age = age;
        this.prestigePoint = 0;
        this.tokens = new TokenDeck(new HashMap<>());
        this.devDeckReserved = new DevDeck();
        this.devDeck = new DevDeck();
        this.beta = beta;
        if(beta){
            this.nobleDeck = null;
        } else {
            this.nobleDeck = new NobleDeck();
        }
    }
    public int age(){
        return age;
    }
    public int prestigePoint() {
        return prestigePoint;
    }


    @Override
    public String toString() {
        String string;
        if (beta){
            string = "[Player " + name + " " + age + "y :" +
                    "\n     PointPrestige=" + prestigePoint +
                    "\n     Token=" + tokens +
                    "\n     DevDeckReserved= " + devDeckReserved.toString() +
                    "\n     DevDeck= " + devDeck.toString() +
                    "]\n";
        } else {
            assert nobleDeck != null;
            string = "[Player " + name + " " + age + "y :" +
                    "\n     PointPrestige=" + prestigePoint +
                    "\n     Token=" + tokens +
                    "\n     DevDeckReserved= " + devDeckReserved.toString() +
                    "\n     DevDeck= " + devDeck.toString() +
                    "\n     NobleDeck= " + nobleDeck.toString() +
                    "]\n";
        }
        return string;
    }

    


/*    private void addPrestigePoints(DevCard card) {
        prestigePoint += card.prestigePoints();
    }
    private void addPrestigePoints(NobleCard card) {
        prestigePoint += card.prestigePoints();
    }

    public void addCardsReservedList(DevCard card) {
        Objects.requireNonNull(card);
        cardsReservedList.add(card);
    }
    public boolean removeCardsReservedList(DevCard devcard) {
        Objects.requireNonNull(devcard);
        return cardsReservedList.remove(devcard);
    }

    public void addCardsList(DevCard devcard) {
        Objects.requireNonNull(devcard);
        cardsList.add(devcard);
        addPrestigePoints(devcard);
    }

    public void addNoble(NobleCard noble) {
        Objects.requireNonNull(noble);
        nobleDeck.add(noble);
        addPrestigePoints(noble);
    }

    public void addToken(Color color) {
        Objects.requireNonNull(color);
        var totalTokens = tokens.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        if(totalTokens >= 10) {
            throw new IllegalStateException("Player cannot have more then " + 10 + " tokens.");
        }
        tokens.put(color, tokens.getOrDefault(color,0) + 1);
    }

    public boolean removeToken(Color color) {
        Objects.requireNonNull(color);
        int count = tokens.getOrDefault(color, 0);
        if (count > 0) {
            tokens.put(color, count - 1);
            return true;
        } else {
            return false;
        }
    }*/

/*    public int tokenCount(Color color) {
        Objects.requireNonNull(color);
        return tokens.getOrDefault(color,0);
    }*/
}
