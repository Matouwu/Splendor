package fr.uge.splendor.phase1.model.player;

import fr.uge.splendor.phase1.model.item.token.ColorP1;
import fr.uge.splendor.phase1.model.item.token.TokenP1;
import fr.uge.splendor.phase1.model.item.card.CardsP1;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerP1 {
    private final String name;
    private final int age;
    private int prestigePoints;
    private final List<CardsP1> cardsList;
    private List<TokenP1> tokens;

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
    public int getAge() {return age;}
    public int getPrestigePoints() {
        return prestigePoints;
    }
    public List<CardsP1> getCardList() {
        return List.copyOf(cardsList);
    }
    public List<TokenP1> getTokens() {return tokens;}
    public int getTokenQuantity(List<TokenP1> tokenList) {
        return tokenList.stream()
                .mapToInt(TokenP1::number)
                .sum();
    }

    public void setTokens(List<TokenP1> tokens) {this.tokens = tokens;}

    @Override
    public String toString() {
        return "[Player " + name + " " + age +"y " +
                ":\nPointPrestige= " + prestigePoints +
                "\nToken= " + tokens +
                "\nCardList= " + cardsList +
                "]\n";
    }

    public void addCardsList(CardsP1 cardsP1) {
        Objects.requireNonNull(cardsP1);
        cardsList.add(cardsP1);
        prestigePoints += cardsP1.getPrestigePoints();
    }

    public void addToken(Map<ColorP1,Integer> tokenMap) {  /* ATTENTIONNNN EN ENTRER UN MAP PLS*/
        Objects.requireNonNull(tokenMap);
        if(tokenMap.size() > 3) throw new IllegalArgumentException("tokenList size exceeds 3");

        var totalTokens = tokenMap.values().stream()
                .mapToInt(i -> i)
                .sum();
        if(totalTokens == 3 && tokenMap.size()==3
            || totalTokens == 2 && tokenMap.size()==1){
            if(getTokenQuantity(tokens)+totalTokens >= 10) throw new IllegalArgumentException("tokenList size exceeds 10");

            var newMap = new HashMap<ColorP1,Integer>(tokenMap);
            for(var token: tokens){
                newMap.put(token.colorP1(),newMap.getOrDefault(token.colorP1(),0)+token.number());
            };

            var newList = new ArrayList<TokenP1>();
            for(var obj: newMap.entrySet()){
                newList.add(new TokenP1(obj.getKey(),obj.getValue()));
            }
            setTokens(newList);
        }
    }

    public boolean removeToken(List<TokenP1> tokenRequire) {
        Objects.requireNonNull(tokenRequire);

        var newMap = tokens.stream()
                .collect(Collectors.toMap(TokenP1::colorP1, TokenP1::number));
        for(var tok: tokenRequire){
            newMap.put(tok.colorP1(),newMap.getOrDefault(tok.colorP1(),0)-tok.number());
        };

        if(newMap.values().stream().allMatch(v -> v>0)){
            var newList = new ArrayList<TokenP1>();
            for(var obj: newMap.entrySet()){
                newList.add(new TokenP1(obj.getKey(),obj.getValue()));
            }
            setTokens(newList);
            return true;
        }
        return false;
    }
}
