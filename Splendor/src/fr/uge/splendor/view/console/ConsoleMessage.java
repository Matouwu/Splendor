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


}
