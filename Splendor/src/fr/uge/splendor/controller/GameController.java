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

    public GameController(int playersNumber) {
        this.playersNumber = playersNumber;
        this.players = new HashSet<>();
        this.tokenPickaxe = new HashMap<>();
        this.cardPickaxe = new HashMap<>();
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
        }
    }


    public void addPlayers(Player players) {
        this.players.add(players);
    }






}
