package fr.uge.splendor.phase1.player;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.DevCard;
import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;
import fr.uge.splendor.phase1.model.CardP1;

import java.util.*;

public class PlayerP1 {
    private final String name;
    private final int age;
    private int prestigePoints;
    private final List<CardP1> cardsList;
    private final List<Token> tokens;

    public PlayerP1(String name, int age) {
        Objects.requireNonNull(name);
        if(age < 0) throw new IllegalArgumentException("age cannot be negative");

        this.name = name;
        this.age = age;
        this.prestigePoints = 0;
        this.cardsList = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }
    
    
    public String getName() {
    	return name;
    }
    
    public int getPrestigePoints() {
    	return prestigePoints; 
    }
    
    public List<CardP1> getCardList(){
    	return List.copyOf(cardsList); 
    }
    
    public int getTokenQuantity(List<Token> tokenList) {
        return tokenList.stream()
                .mapToInt(Token::number)
                .sum();
    }

    public void addCardsList(CardP1 cardP1) {
        Objects.requireNonNull(cardP1);
        cardsList.add(cardP1);
        prestigePoints += cardP1.getPrestigePoints();
    }

    public void addToken(List<Token> tokenList) {
        Objects.requireNonNull(tokenList);
        if(tokenList.size() > 3) throw new IllegalArgumentException("tokenList size exceeds 3");

        var totalTokens = getTokenQuantity(tokenList);
        if(totalTokens == 3 && tokenList.size()==3
            || totalTokens == 2 && tokenList.size()==1){
            if(getTokenQuantity(tokens)+totalTokens >= 10) throw new IllegalArgumentException("tokenList size exceeds 10");
            for(var token : tokenList) {
                tokens.contains(token);
            }
        }
        if(totalTokens >= 10) {
            throw new IllegalStateException("The player cannot have more than " + 10);
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


    @Override
    public String toString() {
        return "[ Player " + name + " " + age +"y " +
                ":\nPointPrestige= " + prestigePoints +
                "\nToken= " + tokens +
                "\nCardList= " + cardsList +
                "]\n";
    }


}
