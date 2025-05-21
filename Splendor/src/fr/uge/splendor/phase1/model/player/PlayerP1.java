package fr.uge.splendor.phase1.model.player;

import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;
import fr.uge.splendor.phase1.model.card.CardP1;

import java.util.*;

public class PlayerP1 {
    private final String name;
    private final int age;
    private int prestigePoints;
    private List<CardP1> cardsList;
    private List<Token> tokens;

    public PlayerP1(String name, int age) {
        Objects.requireNonNull(name);
        if(age < 0) throw new IllegalArgumentException("age cannot be negative");

        this.name = name;
        this.age = age;
        this.prestigePoints = 0;
        this.cardsList = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "[ Player " + name + " " + age +"y " +
                ":\nPointPrestige= " + prestigePoints +
                "\nToken= " + tokens +
                "\nCardList= " + cardsList +
                "]\n";
    }

    public void setCardsList(List<CardP1> cardsList) {
        this.cardsList = cardsList;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void addCardsList(CardP1 cardP1) {
        Objects.requireNonNull(cardP1);
        cardsList.add(cardP1);
        prestigePoints += cardP1.getPrestigePoints();
    }

    public int getTokenQuantity(List<Token> tokenList) {
        return tokenList.stream()
                .mapToInt(Token::number)
                .sum();
    }

    public void addToken(Map<Color,Integer> tokenMap) {  /* ATTENTIONNNN EN ENTRER UN MAP PLS*/
        Objects.requireNonNull(tokenMap);
        if(tokenMap.size() > 3) throw new IllegalArgumentException("tokenList size exceeds 3");

        var totalTokens = tokenMap.values().stream()
                .mapToInt(i -> i)
                .sum();
        if(totalTokens == 3 && tokenMap.size()==3
            || totalTokens == 2 && tokenMap.size()==1){
            if(getTokenQuantity(tokens)+totalTokens >= 10) throw new IllegalArgumentException("tokenList size exceeds 10");

            var newMap = new HashMap<Color,Integer>(tokenMap);
            for(var token: tokens){
                newMap.put(token.color(),newMap.getOrDefault(token.color(),0)+token.number());
            };

            var newList = new ArrayList<Token>();
            for(var obj: newMap.entrySet()){
                newList.add(new Token(obj.getKey(),obj.getValue()));
            }
            this.tokens = newList;
        }
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






}
