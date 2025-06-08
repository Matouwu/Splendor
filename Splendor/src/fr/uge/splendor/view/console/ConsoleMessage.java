package fr.uge.splendor.view.console;

import fr.uge.splendor.model.entity.Player;

public class ConsoleMessage {

    /* ========== Game Status Message ========== */
    public static void startMessage(){
        System.out.println("""
                Welcome to Splendor — game by Océane and Isabelle!
                    Get ready to dive into a world of precious gems, prestige, and strategy.
                    May the best merchant win!
                """);
    }

    public static void startRound(){ //TODO
        System.out.println(" ??? Faire Message de debut de game comme lets the game begin ??? ");
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


    public static void createPlayerNameMessage(int index){
        System.out.println("============ [ Player " + index + " ] ============");
        System.out.println("Enter a nickname:");
    }
    public static void createPlayerAgeMessage(){
        System.out.println("Enter your age: ");
    }

    public static void firstPlayer(Player player){ //TODO
        System.out.println("??? en mode le player joue dab et : Eh ouai, parce que c'est le plus petit HAHAHAHHAHHAHA (ou juste que c'est le meilleur °*°)!!!!! ???");
    }

    public static void selectAction(){//TODO
        System.out.println("??? en mode choose commande  :" +
                "- (1) Take 3 gemstones of different colors\n" +
                "- (2) Take 2 gemstones of the same color\n" +
                "- (3) Purchase 1 development card using gemstones???");
    }
    public static void actionOne(){//TODO
        System.out.println("??? En mode ta choisi l'action 1 donc du pren 3 diff " +
                "You have to enter the colors you want (green, blue, red, white, black): ???");
    }
    public static void actionTwo(){//TODO
        System.out.println("??? En mode ta choisi l'action 2 donc du pren 2 id ???");
    }
    public static void actionThree(){//TODO
        System.out.println("??? En mode ta choisi l'action 3 donc du achete une carte ???");
    }

    /* - Beta Mode Message - */
    public static void betaStartMessage(){
        System.out.println("""
                Welcome to 'Beta Splendor' game, develop by Océane LUYEYE and Isabelle ZHAN!
                    Game Rules:
                You play as gemstone merchants aiming to accumulate prestige points — you'll need 15 points to win the game.
                To do so, you have 3 possible actions:
                    - (1) Take 3 gemstones of different colors
                    - (2) Take 2 gemstones of the same color
                    - (3) Purchase 1 development card using gemstones
                Each card gives you 1 prestige point and costs 3 gemstones.
                This Beta version is limited to 2 players only.
                
                A simple game to learn, but with strategic depth that guarantees hours of fun.
                Are you ready to become the most prestigious merchant of the era?
                
                """);
    }
    /* - Final Mode Message - */
    public static void finalStartMessage(){
        System.out.println("""
                Welcome to 'Splendor' game, develop by Océane LUYEYE and Isabelle ZHAN!
                    Game Rules:
                You play as gemstone merchants aiming to accumulate prestige points — you'll need 15 points to win the game.
                To do so, you have 3 possible actions:
                    - (1) Take 3 gemstones of different colors
                    - (2) Take 2 gemstones of the same color
                    - (3) Purchase 1 development card using gemstones
                Each card gives you 1 prestige point and costs 3 gemstones.
                
                A simple game to learn, but with strategic depth that guarantees hours of fun.
                Are you ready to become the most prestigious merchant of the era?
                
                """);
    }

}
