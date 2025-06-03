package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.Card;
import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.DevCard;

import java.util.*;

public class Player {
    private final String name;
    private final int age;
    private final int prestigePoints;
    private final List<Card> cardsList;
    private final List<Card> cardsReservedList;
    private final Map<Color, Integer> tokens;

    public Player(String name, int age) {
        Objects.requireNonNull(name);
        if (age < 0) throw new IllegalArgumentException("Age must be a positive integer.");

        this.name = name;
        this.age = age;
        this.prestigePoints = 0;
        this.cardsList = new ArrayList<>();
        this.cardsReservedList = new ArrayList<>();
        this.tokens = new HashMap<>();
    }

    @Override
    public String toString() {
        return "[Player " + name + " " + age + "y :" +
                "\n     PointPrestige=" + prestigePoints +
                "\n     Token=" + tokens +
                "\n     CardList=" + cardsList +
                "\n     CardReserved=" + cardsReservedList +
                "]\n";
    }

    public void addCardsList(DevCard devcard) {
        Objects.requireNonNull(devcard);
        cardsList.add(devcard);
    }

    public boolean removeCardsReservedList(DevCard devcard) {
        Objects.requireNonNull(devcard);
        return cardsReservedList.remove(devcard);
    }

    public void addToken(Color color) {
        Objects.requireNonNull(color);
        var totalTokens = tokens.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        if(totalTokens >= 10) {
            throw new IllegalStateException("Le joueur ne peut pas avoir plus de " + 10);
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

    public int tokenCount(Color color) {
        Objects.requireNonNull(color);
        return tokens.getOrDefault(color,0);
    }

}
