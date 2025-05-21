package fr.uge.splendor.controller;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.NobleCard;
import fr.uge.splendor.model.player.Player;
import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.phase1.model.card.CardsP1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameController {
    private final int playersNumber;
    private final List<Player> players;
    private boolean gameEnded; 
    private int currentPlayerIndex;
    private final Map<Color, Integer> tokenPickaxe;
    private final Map<Integer, List<CardsP1>> cardPickaxe;
    private final Map<NobleCard, Integer> nobleCardsPickaxe;

    public GameController(int playersNumber) {
        if (playersNumber < 2 || playersNumber > 4) throw new IllegalArgumentException("Number of player must be between 2 and 4.");
        this.playersNumber = playersNumber;
        this.players = new ArrayList<>();
        this.gameEnded = false; 
        this.tokenPickaxe = new HashMap<>();
        setTokenPickaxe();
        this.cardPickaxe = new HashMap<>();
        this.nobleCardsPickaxe = new HashMap<>();
    }

    public void setTokenPickaxe() {
        switch (playersNumber){ 
            case 4:
                tokenPickaxe.put(Color.GREEN, 7);
                tokenPickaxe.put(Color.BLUE, 7);
                tokenPickaxe.put(Color.RED, 7);
                tokenPickaxe.put(Color.WHITE, 7);
                tokenPickaxe.put(Color.BLACK, 7);
                tokenPickaxe.put(Color.YELLOW, 5);
                break;
            case 3:
                tokenPickaxe.put(Color.GREEN, 5);
                tokenPickaxe.put(Color.BLUE, 5);
                tokenPickaxe.put(Color.RED, 5);
                tokenPickaxe.put(Color.WHITE, 5);
                tokenPickaxe.put(Color.BLACK, 5);
                tokenPickaxe.put(Color.YELLOW, 5);
                break;
            case 2:
                tokenPickaxe.put(Color.GREEN, 4);
                tokenPickaxe.put(Color.BLUE, 4);
                tokenPickaxe.put(Color.RED, 4);
                tokenPickaxe.put(Color.WHITE, 4);
                tokenPickaxe.put(Color.BLACK, 4);
                tokenPickaxe.put(Color.YELLOW, 5);
                break;
        }
    }
    
    public void setCardPickaxe() {
        switch (playersNumber){
        
        case 4:
        	
        case 3:
        	
        case 2: 
        }
    }


    public void setNobleCardPickaxe() {
    	 switch (playersNumber){ 
    	 }
    	
    	
    }
    
    public void addPlayers(Player player) {
    	Objects.requireNonNull(player); 
    	
    	if(players.size() >= playersNumber) {
    		throw new IllegalStateException("Cannot add more players than max : " + playersNumber);
    	}
   
        this.players.add(player);
    }
    
    
    public void nextPlayer() {
    	 currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
    
 /*
    public boolean reserveCard(Player player, DevCard card) {
        Objects.requireNonNull(player); 
        Objects.requireNonNull(card);
        
        if (!player.equals(players.get(currentPlayerIndex))) {
            return false;
        }
        
        if (player.cardsReservedList().size() >= 3) {
            return false; 
        }
        return true;
    }
    
   *//* public boolean buyCard() {
    	
    }*//*
    
    
    
    private boolean canNobleVisit(Player player, NobleCard nobleCard) {
        Objects.requireNonNull(player); 
        Objects.requireNonNull(nobleCard);

        Map<Color, Integer> playerBonuses = player.getBonusCount(); 
        Map<Color, Integer> requirements = nobleCard.tokenRequire(); 

        return requirements.entrySet()
        					.stream()
        					.allMatch(entry -> playerBonuses.getOrDefault(entry.getKey(), 0) >= entry.getValue());
    }
    

    public void checkNobleVisit(Player player) {
        Objects.requireNonNull(player);

        List<NobleCard> eligibleNobles = nobleCardsPickaxe.keySet().stream()
            .filter(noble -> canNobleVisit(player, noble))
            .toList(); 

        if (!eligibleNobles.isEmpty()) {
            NobleCard noble = eligibleNobles.get(0); 
            nobleCardsPickaxe.remove(noble);
            player.cardNobleList().add(noble);
        }
    }
    
    
    private void checkGameEnd() {
    	for(Player player: players) {
    		if(player.prestigePoints() >= 15) {
    			gameEnded = true; 
    		}
    	}
    }
    
    public boolean isGameOver() {
    	return gameEnded; 
    }
 
    
    public void initGame() {
    	setTokenPickaxe(); 
    	setCardPickaxe(); 
    	setNobleCardPickaxe(); 
    	
    	
    	if (players.size() != playersNumber) {
    	        throw new IllegalStateException("Nombre de joueurs incorrect : " + players.size() + "/" + playersNumber);
    	 }

    	System.out.println("Initialisation de la partie");
    	
    }*/

}
