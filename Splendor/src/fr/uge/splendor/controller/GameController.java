package fr.uge.splendor.controller;

import fr.uge.splendor.model.card.Cards;
import fr.uge.splendor.model.player.Player;
import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameController {
    private final int playersNumber;
    private final Set<Player> players;
    private final Map<Color, Integer> tokenPickaxe;
    private final Map<Cards, Integer> cardPickaxe;
    private final Map<Cards, Integer> nobleCardsPickaxe;

    public GameController(int playersNumber) {
        if (playersNumber < 2 || playersNumber > 4) throw new IllegalArgumentException("Number of player must be between 2 and 4.");
        this.playersNumber = playersNumber;
        this.players = new HashSet<>();
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

        }
    }


    public void addPlayers(Player players) {
        this.players.add(players);
    }






}
