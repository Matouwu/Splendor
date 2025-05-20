package fr.uge.splendor.phase1.player;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.DevCard;
import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.phase1.model.CardP1;

import java.util.*;

public class PlayerP1 {
    private final String name;
    private final int age;
    private int prestigePoints;
    private final List<CardP1> cardsList;
    private final Map<Color, Integer> tokens;

    public PlayerP1(String name, int age) {
        Objects.requireNonNull(name);
        if(age < 0) throw new IllegalArgumentException("age cannot be negative");

        this.name = name;
        this.age = age;
        this.prestigePoints = 0;
        this.cardsList = new ArrayList<>();
        this.tokens = new HashMap<>();
    }

    @Override
    public String toString() {
        return "[ Player " + name + " " + age +"y " +
                ":\nPointPrestige= " + prestigePoints +
                "\nToken= " + tokens +
                "\nCardList= " + cardsList +
                "]\n";
    }

/*    public String name() {return name;}
public List<Cards> cardList() {return cardsList;}
public int prestigePoints() {return cardsList.size();}*/

    public void addCardsList(CardP1 cardP1) {
        Objects.requireNonNull(cardP1);
        cardsList.add(cardP1);
        prestigePoints += cardP1.getPrestigePoints();
    }

/*    public void addCardsReservedList(CardP1 cardP1) {
        Objects.requireNonNull(cardP1);
        cardsReservedList.add(cardP1);
    }
    public boolean removeCardsReservedList(DevCard devcard) {
        Objects.requireNonNull(devcard);
        return cardsReservedList.remove(devcard);
    }*/

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
