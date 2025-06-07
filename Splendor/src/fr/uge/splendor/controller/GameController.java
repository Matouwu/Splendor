package fr.uge.splendor.controller;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.view.console.ConsoleMessage;
import fr.uge.splendor.view.console.ConsoleView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {
    private final ConsoleView consoleView;
    private final Game game;

    public GameController(ConsoleView consoleView){
        Objects.requireNonNull(consoleView);
        this.consoleView = consoleView;
    }

    private List<Player> setupPlayerList(int index){
        List<Player> playersList = new ArrayList<>();
        for(int i=0; i<index; i++){
            ConsoleMessage.creatPlayerNameMessage(i+1);
            var name = consoleView.inputString();
            var age = consoleView.inputInt();
            while(age<0){
                ConsoleMessage.wrongInputMessage();
                age = consoleView.inputInt();
            }
            playersList.add(new Player(name, age));
        }
        return List.copyOf(playersList);
    }

    private void setupBetaMode() throws IOException {
        ConsoleMessage.betaStartMessage();
        var devDeck = new DevDeck();
        devDeck.loadAllCards();
        var playerList = setupPlayerList(2);


    }
    private void setupFinalMode(){

    }

    private void gameConfig(){
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

    public void run(){
        ConsoleMessage.startMessage();
        gameConfig();
    }

}
