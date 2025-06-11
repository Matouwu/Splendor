package fr.uge.splendor.model.entity;

import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.card.NobleCard;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import java.util.*;

public class Player {
	private final boolean beta;
    private final String name;
    private final int age;
    private int prestigePoint;
    private final TokenDeck tokenDeck;
    private final TokenDeck tokenDeckReduction;
    private final DevDeck devDeckReserved;
    private final DevDeck devDeck;
    private final NobleDeck nobleDeck;

    public Player(String name, int age, boolean beta) {
        Objects.requireNonNull(name);
        if (age < 0) throw new IllegalArgumentException("Age must be a positive integer.");

        this.name = name;
        this.age = age;
        this.prestigePoint = 0;
        this.tokenDeck = new TokenDeck(new HashMap<>());
        this.tokenDeckReduction = new TokenDeck(new HashMap<>());
        this.devDeckReserved = new DevDeck(beta);
        this.devDeck = new DevDeck(beta);
        this.beta = beta;
        if(beta){
            this.nobleDeck = null;
        } else {
            this.nobleDeck = new NobleDeck();
        }
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }
    public int getPrestigePoint() {
        return prestigePoint;
    }
    public TokenDeck getTokenDeck(){
        return tokenDeck;
    }
    public TokenDeck getTokenDeckReduction(){
        return tokenDeckReduction;
    }
    public int getTokenNum(){
        return tokenDeck.getTokenDeck().values().stream()
                .mapToInt(i -> i)
                .sum();
    }
    public DevDeck getDevDeckReserved(){
        return devDeckReserved;
    }

    private void addPrestigePoints(DevCard card) {
        prestigePoint += card.prestigePoint();
    }
    private void addPrestigePoints(NobleCard card) {
        prestigePoint += card.prestigePoints();
    }

    public void addToken(TokenDeck tokenDeck) {
        Objects.requireNonNull(tokenDeck);
        var totalTokens = this.tokenDeck.getTokenDeck().values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        if(totalTokens >= 10) {
            throw new IllegalStateException("Player cannot have more then " + 10 + " tokens.");
        }
        this.tokenDeck.addTokenDeck(tokenDeck);
    }

    private void removeToken(TokenDeck tokenDeck) {
        Objects.requireNonNull(tokenDeck);
        for(var color : tokenDeck.getTokenDeck().entrySet()){
            this.tokenDeck.removeTokenDeck(color.getKey(),color.getValue());
        }
    }

    public void addCardsList(DevCard devCard) {
        Objects.requireNonNull(devCard);
        removeToken(devCard.tokenRequire());
        tokenDeckReduction.addTokenDeck(devCard.tokenReduction(), 1);
        devDeck.addDevCard(devCard);
        addPrestigePoints(devCard);
    }

    public void addCardsReserveList(DevCard devCard){
        Objects.requireNonNull(devCard);
        devDeckReserved.addDevCard(devCard);
    }

    public boolean checkCanBuy(TokenDeck tokenDeck){
        for(var token: tokenDeck.getTokenDeck().entrySet()){
            if(this.tokenDeck.getTokenDeck().get(token.getKey()) < token.getValue())
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String string;
        if (beta){
            string = "[Player " + name + " " + age + "y :" +
                    "\n     PointPrestige=" + prestigePoint +
                    "\n     Token=" + tokenDeck +
                    "\n     DevDeck= " + devDeck.toString() +
                    "]\n";
        } else {
            assert nobleDeck != null;
            string = "[Player " + name + " " + age + "y :" +
                    "\n     PointPrestige=" + prestigePoint +
                    "\n     Token=" + tokenDeck +
                    "\n     DevDeckReserved= " + devDeckReserved +
                    "\n     DevDeck= " + devDeck +
                    "\n     NobleDeck= " + nobleDeck+
                    "]\n";
        }
        return string;
    }

    




/*


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


    }*/

/*    public int tokenCount(Color color) {
        Objects.requireNonNull(color);
        return tokens.getOrDefault(color,0);
    }*/
}
