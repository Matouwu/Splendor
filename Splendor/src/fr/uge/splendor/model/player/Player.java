package fr.uge.splendor.model.player;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.DevCard;
import fr.uge.splendor.model.card.Noble;
import fr.uge.splendor.model.card.NobleCard;
import fr.uge.splendor.model.token.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {

    private final String name;
    private final List<Cards> cardsList;
    private final List<Cards> cardsReservedList; 
    private final List<NobleCard> cardsNobleList; 
    private final Map<Color, Integer> tokens;
   

    public Player(String name) {
    	
        Objects.requireNonNull(name);
        
        this.name = name;
        this.cardsList = new ArrayList<>();
        this.cardsReservedList = new ArrayList<>(); 
    	this.cardsNobleList = new ArrayList<>(); 
        this.tokens = new  HashMap<>();
    }
    
    public String name() {
    	return name;
    }
    
    public List<Cards> cardList() {
        return cardsList;
    }
    
    public List<Cards> cardsReservedList(){
    	return cardsReservedList; 
    }
    
    public List<NobleCard> cardNobleList(){
    	return cardsNobleList; 
    }
    
    public int prestigePoints() {
    	
    	   int points = 0;
    	    for (Cards card : cardsList) {
    	        points += card.prestigePoints(); 
    	    }
    	    for (NobleCard nobleCard : cardsNobleList) {
    	        points += nobleCard.prestigePoints(); 
    	    }
    	    return points;
    }
    
    public void addCardsList(DevCard devcard) {
    	Objects.requireNonNull(devcard); 
    	
    	cardsList.add(devcard); 
    }
   
    
    public void addCardsReservedList(DevCard devcard) {
    	Objects.requireNonNull(devcard); 
    	
    	cardsReservedList.add(devcard); 
    }
    
    public void addCardNobleList(NobleCard nobleCard) {
    	Objects.requireNonNull(nobleCard); 
    	
    	cardsNobleList.add(nobleCard); 
    }
    
    
    public boolean removeCardsReservedList(DevCard devcard) {
    	Objects.requireNonNull(devcard); 
    	
		return cardsReservedList.remove(devcard);
    	
    }
 
    public boolean removeCardsList(DevCard devcard) {
    	Objects.requireNonNull(devcard); 
    	
		return cardsList.remove(devcard);
    	
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

    
    public Map<Color, Integer> getBonusCount() {
        return cardsList.stream()
        				.map(Cards::tokenReduction) 
        				.collect(Collectors.groupingBy(
        				color -> color,
        				Collectors.summingInt(x -> 1)
        				));
    }
    
    public boolean canBuyCard(DevCard card) {
        
        Map<Color, Integer> tokenRequire = card.tokenRequire();
        Map<Color, Integer> bonus = getBonusCount();
        
        return tokenRequire
        			.entrySet()
        			.stream()
                	.filter(entry -> {
                    Color color = entry.getKey();
                    int needed = entry.getValue() - bonus.getOrDefault(color, 0);
                    return needed > tokenCount(color);
                }).count() == 0; 
    }
    
    @Override
    public String toString() {
    	 return "Player " + name + "\nPointPrestige=" + prestigePoints() + "\nToken=" + tokens +  "\nCardList=" + cardsList + "\nCardReserved=" + cardsReservedList;
    }
    
    
}
