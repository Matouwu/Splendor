package fr.uge.splendor.controller;

import fr.uge.splendor.view.console.ConsoleMessage;
import fr.uge.splendor.view.console.ConsoleView;

import java.util.Objects;

public class GameController {
    private final ConsoleView consoleView;

    public GameController(ConsoleView consoleView){
        Objects.requireNonNull(consoleView);

        this.consoleView = consoleView;
    }

    public void gameConfig(){
        var mode = consoleView.gameMode();
        while(!mode.equalsIgnoreCase("B") && !mode.equalsIgnoreCase("F")){
            ConsoleMessage.wrongInputMessage();
            mode = consoleView.gameMode();
        }
        switch (mode.toUpperCase()){
            case "B" -> Config(1);
            case "F" ->
        }
    }

    public void run(){
        ConsoleMessage.startMessage();

    }

}
