package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.Card;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.card.NobleCard;

import java.util.*;

public class Player {
	
    private final String name;
    private final int age;
    private int prestigePoints;
    private final Map<Color, Integer> tokens;
    private final List<DevCard> cardsReservedList;
    private final List<DevCard> cardsList;
    private final List<NobleCard> noblesList;

    public Player(String name, int age) {
        Objects.requireNonNull(name);
        if (age < 0) throw new IllegalArgumentException("Age must be a positive integer.");

        this.name = name;
        this.age = age;
        this.prestigePoints = 0;
        this.tokens = new HashMap<>();
        this.cardsReservedList = new ArrayList<>();
        this.cardsList = new ArrayList<>();
        this.noblesList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "[Player " + name + " " + age + "y :" +
                "\n     PointPrestige=" + prestigePoints +
                "\n     Token=" + tokens +
                "\n     CardReserved= " + cardsReservedList +
                "\n     CardList= " + cardsList +
                "\n     NoblesList= " + noblesList +
                "]\n";
    }
    private void addPrestigePoints(DevCard card) {
        prestigePoints += card.prestigePoints();
    }
    private void addPrestigePoints(NobleCard card) {
        prestigePoints += card.prestigePoints();
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
        noblesList.add(noble);
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
    }

/*    public int tokenCount(Color color) {
        Objects.requireNonNull(color);
        return tokens.getOrDefault(color,0);
    }*/
}
