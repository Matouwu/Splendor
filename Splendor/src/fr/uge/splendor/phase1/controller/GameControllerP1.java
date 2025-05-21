package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.token.ColorP1;
import fr.uge.splendor.phase1.model.card.CardsP1;
import fr.uge.splendor.phase1.model.card.DevCardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.*;


public class GameControllerP1 {
    private int currentPlayerIndex;
    private final List<PlayerP1> players = new ArrayList<>();
    private final Map<ColorP1, Integer> tokenPickaxe;
    private final List<CardsP1> cardPickaxe;

    private List<CardsP1> devCards;

    public GameControllerP1(List<PlayerP1> players, int currentPlayerIndex) {
        Objects.requireNonNull(players);
        if(players.size() != 2) throw new IllegalArgumentException("The number of players must equal 2");

        this.currentPlayerIndex = currentPlayerIndex;
        this.players.addAll(players);
        this.tokenPickaxe = new HashMap<>();
        setTokenPickaxe();
        this.devCards = DevCardsP1.listDevCards();
        this.cardPickaxe = new ArrayList<>();
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
        Random rand = new Random();

        while(cardPickaxe.size() < 3) {
            if(devCards.isEmpty()) throw new IllegalArgumentException("DevCards is empty");
            int cardIndex = rand.nextInt(devCards.size());
            CardsP1 card = devCards.remove(cardIndex);
            cardPickaxe.add(card);
        }
    }

    public void nextPlayer() {
        this.currentPlayerIndex = (currentPlayerIndex + 1)%2;
    }

    public void action1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu dois donc choisir 3 pierres précieuses entre : " + tokenPickaxe +
                "\nPour cela tu va rentrer les couleurs que tu veux (ex: green, bleu ...):");
        /*ColorP1 c1= sc.nextLine().toUpperCase();*/


    }

    public void action2(){
        System.out.println("Tu dois choisir 2 pierres identiques entre : " + tokenPickaxe);
    }
    public void action3(){

    }



    public void oneRound(String action) {
        switch (action) {
            case "a1" -> {action1();}
            case "a2" -> {action2();}
            case "a3" -> {action3();}
        }
    }


}
