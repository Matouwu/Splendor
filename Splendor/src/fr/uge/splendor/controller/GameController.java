package fr.uge.splendor.controller;

import fr.uge.splendor.model.action.BuyCard;
import fr.uge.splendor.model.action.TakeDiffCard;
import fr.uge.splendor.model.action.TakeSameCard;
import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;
import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;
import fr.uge.splendor.view.console.ConsoleMessage;
import fr.uge.splendor.view.console.ConsoleView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GameController {
    private final ConsoleView consoleView;
    private Game game;

    private boolean gameMode;

    public GameController(ConsoleView consoleView){
        Objects.requireNonNull(consoleView);
        this.consoleView = consoleView;
    }

    /* ========== Setup fiels ========== */

    private DevDeck setupDevBoardDeck() throws IOException {
        var devDeck = new DevDeck();
        devDeck.loadAllCards();
        return devDeck;
    }
    private NobleDeck setupNobleDeck(){
        var nobleDeck = new NobleDeck();
        nobleDeck.loadAllNoble();
        return nobleDeck;
    }
    private TokenDeck setupTokenBoardDeck(){
        var tokenDeck = new TokenDeck(new HashMap<>());
        tokenDeck.initBoardTokenDeck(2,true);
        return tokenDeck;
    }

    private List<Player> setupPlayerList(int index){
        List<Player> playersList = new ArrayList<>();
        for(int i=0; i<index; i++){
            ConsoleMessage.createPlayerNameMessage(i+1);
            var name = consoleView.inputString();
            ConsoleMessage.createPlayerAgeMessage();
            var age = consoleView.inputInt();
            while(age<0){
                ConsoleMessage.wrongInputMessage();
                age = consoleView.inputInt();
            }
            Player p = new Player(name, age, gameMode);
            playersList.add(p);

            System.out.println(p);
        }
        return List.copyOf(playersList);
    }
    private int setupPlayerIndex(List<Player> playerList){
        Objects.requireNonNull(playerList);
        int index = 0;
        Player younger = playerList.getFirst();
        int i=0;
        for(var p :playerList){
            if(p.age()< younger.age()){
                index = i;
                younger = p;
            }
            i++;
        }
        return index;
    }

    /* ========== Setup Game mode ========== */

    private void setupBetaMode() throws IOException {
        this.gameMode = true;
        ConsoleMessage.betaStartMessage();
        var devDeck = setupDevBoardDeck();
        var tokenDeck = setupTokenBoardDeck();
        var playerList = setupPlayerList(2);
        var currentPlayerIndex = setupPlayerIndex(playerList);
        ConsoleMessage.firstPlayer(playerList.get(currentPlayerIndex));
        this.game = new Game(devDeck, null, tokenDeck, playerList, currentPlayerIndex, true);
    }
    private void setupFinalMode() throws IOException { //FIXME
        this.gameMode = false;
        ConsoleMessage.finalStartMessage();
        var devDeck = setupDevBoardDeck();
        var nobleDeck = setupNobleDeck();
        var tokenDeck = setupTokenBoardDeck();

        var playerList = setupPlayerList(7);
        var currentPlayerIndex = setupPlayerIndex(playerList);
        ConsoleMessage.firstPlayer(playerList.get(currentPlayerIndex));
        this.game = new Game(devDeck, nobleDeck, tokenDeck, playerList, currentPlayerIndex, false);

    }

    /* ========== Game log ========== */

    private void gameConfig() throws IOException {
        var mode = consoleView.gameMode();
        while(!mode.equalsIgnoreCase("B") && !mode.equalsIgnoreCase("F")){
            ConsoleMessage.wrongInputMessage();
            mode = consoleView.gameMode();
        }
        switch (mode.toUpperCase()){
            case "B" -> setupBetaMode();
            case "F" -> setupFinalMode();
        }
    }

    private Color inputColor(){
        var color = consoleView.inputString();
        while(!color.equals(Color.values())){
            color = consoleView.inputString();
        }
    }
    private void gameRound(){
        ConsoleMessage.selectAction();
        var action = consoleView.inputInt();
        while(action!=1 && action!=2 && action !=3){
            action = consoleView.inputInt();
        }
        switch(action){
            case 1 -> {
                ConsoleMessage.actionOne();
                var color1 = consoleView.inputString();
                TakeDiffCard.excecute(game);
            }
            case 2 -> TakeSameCard.excecute(game);
            case 3 -> BuyCard.excecute(game);
        }

    }

    public void run() throws IOException {

        ConsoleMessage.startMessage();
        gameConfig();
        ConsoleMessage.startRound();

        int winnerIndex = game.checkGameEnd();
        while(winnerIndex==-1){
            gameRound();
            winnerIndex = game.checkGameEnd();
        }



    }

}
