package fr.uge.splendor.view.console;

import fr.uge.splendor.model.entity.Player;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView(Scanner scanner){
        Objects.requireNonNull(scanner);
        this.scanner = scanner;
    }

    public String gameMode() {
        System.out.println("""                
                Please choose the game mode:
                    - (B) - Beta
                    - (F) - Final
                """);
        return scanner.nextLine();
    }

    public String inputString(){
        return scanner.next();
    }
    public int inputInt(){
        return scanner.nextInt();
    }


}
