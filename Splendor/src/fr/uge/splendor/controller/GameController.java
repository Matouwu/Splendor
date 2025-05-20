package fr.uge.splendor.controller;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.card.NobleCard;
import fr.uge.splendor.model.player.Player;
import fr.uge.splendor.model.token.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GameController {
    private final int playersNumber;
    private final List<Player> players;
    private boolean gameEnded; 
    private int currentPlayerIndex;
    private final Map<Color, Integer> tokenPickaxe;
    private final Map<Cards, Integer> cardPickaxe;
    private final Map<Cards, Integer> nobleCardsPickaxe;

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
        switch (playersNumber){ // streams ici à la place 
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
        switch (playersNumber){ // on peut faire un stream ici 
        case 4:
        	
        case 3:
        	
        case 2: 
        }
    }


    public void setNobleCardPickaxe() {
    				// streams ici à la place 
    	
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
    
   
    // A voir si on garde cette méthode car ce n'est pas vraiment une action du jeu
    
    /*public void checkNobleVisit(Player player) {
        Objects.requireNonNull(player);
        
        List<NobleCard> eligibleNobles = 
        		nobleCardsPickaxe.stream()
        						  .filter(noble -> canNobleVisit(player, noble))
        						  .collect(Collectors.toList());
            
        if (eligibleNobles.isEmpty()) {
            return;
        }
        
        if (eligibleNobles.size() == 1) {
            NobleCard noble = eligibleNobles.get(0);
            nobleCardsPickaxe.remove(noble);
            player.cardNobleList().add(noble);
            return;
        }
      
        NobleCard chosenNoble = eligibleNobles.get(0);
        nobleCardsPickaxe.remove(chosenNoble);
        player.cardNobleList().add(chosenNoble);
    }*/
    
    
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
    	
    }

}
