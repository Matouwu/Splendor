package fr.uge.splendor.view.console;

public class ConsoleMessage {
    public static void startMessage(){
        System.out.println("""
                Welcome to Splendor — game by Océane and Isabelle!
                    Get ready to dive into a world of precious gems, prestige, and strategy.
                    May the best merchant win!
                """);
    }

    public static void wrongInputMessage(){
        System.out.println("""
                - Wrong input -
                BE CAREFUL, I KNOW WHERE YOU LIVE!
                """);
    }

    public static void successBuyMessage(){
        System.out.println("You’ve successfully bought the card!");
    }

    public static void successTakeMessage(){
        System.out.println("Tokens successfully collected.");
    }

    public static void creatPlayerNameMessage(int index){
        System.out.println("============ [ Player " + index + " ] ============");
        System.out.println("Enter a nickname:");
    }
    public static void createPlayerAgeMessage(){
        System.out.println("Enter your age: ");
    }

    /* - Beta Mode Message - */
    public static void betaStartMessage(){
        System.out.println("""
                Welcome to 'Beta Splendor' by Océane LUYEYE and Isabelle ZHAN!
                    Game Rules:
                You play as gemstone merchants aiming to accumulate prestige points — you'll need 15 points to win the game.
                To do so, you have 3 possible actions:
                    - (a1) Take 3 gemstones of different colors
                    - (a2) Take 2 gemstones of the same color
                    - (a3) Purchase 1 development card using gemstones
                Each card gives you 1 prestige point and costs 3 gemstones.
                This Beta version is limited to 2 players only.
                
                A simple game to learn, but with strategic depth that guarantees hours of fun.
                Are you ready to become the most prestigious merchant of the era?
                
                """);
    }

}
