package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.token.ColorP1;
import fr.uge.splendor.phase1.model.card.CardsP1;
import fr.uge.splendor.phase1.model.card.DevCardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.*;

public class GameControllerP1 {
    private boolean gameEnded;
    private int currentPlayerIndex;
    private final List<PlayerP1> players = new ArrayList<>();
    private final Map<ColorP1, Integer> tokenPickaxe;
    private final Map<Integer, List<CardsP1>> cardPickaxe;

    public GameControllerP1(List<PlayerP1> players, int currentPlayerIndex) {
        Objects.requireNonNull(players);

        this.gameEnded = false;
        this.currentPlayerIndex = currentPlayerIndex;
        this.players.addAll(players);
        this.tokenPickaxe = new HashMap<>();
        setTokenPickaxe();
        this.cardPickaxe = new HashMap<>();
        setCardPickaxe();
    }

    public void setTokenPickaxe() {
        tokenPickaxe.put(ColorP1.GREEN, 4);
        tokenPickaxe.put(ColorP1.BLUE, 4);
        tokenPickaxe.put(ColorP1.RED, 4);
        tokenPickaxe.put(ColorP1.WHITE, 4);
        tokenPickaxe.put(ColorP1.BLACK, 4);
    }

    public void setCardPickaxe() {
        List<CardsP1> cards = DevCardsP1.listDevCards();

        Random rand = new Random();
        int cardIndex = rand.nextInt(cards.size());
        this.cardPickaxe.put();
    }






    private void checkGameEnd() {
        for(PlayerP1 p: players) {
            if(p.getPrestigePoints() >= 15) {
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

        if (players.size() != playersNumber) {
            throw new IllegalStateException("Nombre de joueurs incorrect : " + players.size() + "/" + playersNumber);
        }

        System.out.println("Initialisation de la partie");

    }


}
