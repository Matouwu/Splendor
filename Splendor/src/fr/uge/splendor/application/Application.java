package fr.uge.splendor.application;

import fr.uge.splendor.controller.GameController;
import fr.uge.splendor.view.console.ConsoleView;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        var consoleView = new ConsoleView(scanner);
        var gameController = new GameController(consoleView);

        gameController.run();
    }
}
