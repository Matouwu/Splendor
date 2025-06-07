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


/*        System.out.println("""
    Welcome to Phase 1 of Splendor by Océane and Isabelle!
        Game rules:
    You play as gemstone merchants aiming to accumulate prestige points — you need 15 to win the game.
    To do this, you have 3 possible actions:
        -   (a1) Take 3 gemstones of different colors,
        -   (a2) Take 2 gemstones of the same color,
        -   (a3) Buy 1 development card using gemstones.
    Each card gives 1 prestige point and costs 3 gemstones.
    A simple game to understand, but with strategic depth that guarantees hours of fun.
    Ready to become the most prestigious merchant of the era?
    
    For this first phase of the game, I’ll need 2 players:
    #============ [ Player 1 ] ============#
    Enter a nickname:""");
    }*/
}
