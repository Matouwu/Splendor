package fr.uge.splendor.view.console;

import fr.uge.splendor.model.entity.Player;
import fr.uge.splendor.model.items.card.NobleCard;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;

import javax.xml.transform.Source;

public class ConsoleMessage {

    /* ========== Game Status Message ========== */
    public static void startMessage(){
        System.out.println("""
                Welcome to Splendor — game by Océane and Isabelle!
                    Get ready to dive into a world of precious gems, prestige, and strategy.
                    May the best merchant win!
                """);
    }

    public static void startRound(){
        System.out.println("""
                The game begins now!
                    It's time to strategize, trade, and collect your gems.
                The path to victory starts now!
                """);    }

    public static void enGame(Player p){ //TODO
        System.out.println("Congratulation player "+ p.getName() + "you won !!");
    }


    public static void wrongInputMessage(int code, TokenDeck tokenDeck){ //TODO
        switch (code){
            case 100 -> //Config
                System.out.println("""
                    - Wrong mode input -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You must enter "B" or "F" to select the game mode.
                    """);
            case 200 -> //Player
                System.out.println("""
                    - Invalid age number -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You must enter a valid age number (0 < ageNumber < 150).
                    """);
            case 201 ->
                System.out.println("""
                    - Invalid number of player -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You must enter a valid number of player (between 2 and 4).
                    """);
            case 202 ->
                System.out.println("""
                    - Invalid ressources -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You do not have enough ressources to buy card, please select an other action or card.
                    """);
            case 300 -> //Token
                System.out.println("""
                    - Wrong color -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You must enter a valid color (green, blue, red, white, black):
                    """);
            case 301 ->
                System.out.println("""
                    - Same color -
                    BE CAREFUL, I KNOW WHERE YOU LIVE!
                    You must enter a different color (green, blue, red, white, black):
                    """);
            case 302 -> {
                System.out.println("""
                    - Unavailable color -
                    Unavailable Color avec le dec qu'il reste a choisir :
                    """);
                tokenDeckMessage(1, tokenDeck);
            }
            case 303 ->
                System.out.println("""
                    - TokenDeck full -
                    Atteint le nombre maximum de token, veuille acheter une carte.
                    """);
            case 400 -> //Card
                System.out.println("""
                    - Wrong card level -
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer un niveau de carte valide !""");
            case 401 ->
                System.out.println("""
                    - Wrong card number -
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer un nombre entre 1 et 4 pour choisir la carte que tu veux acheter du plateau !""");
            case 402 ->
                System.out.println("""
                    - Not enough ressources -
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Pas asser de ressource pour acheter une carte, choisi une autre action.""");
            case 500 -> //ReservedCard
                System.out.println("""
                    - Reserve card full -
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Atteint le nombre maximum de carte reservé possible.""");
            case 501 ->
                System.out.println("""
                    - Wrong reserve card number -
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer un nombre valid pour choisir la carte reservé à acheter.""");

        }
    }

    public static void tokenDeckMessage(int code, TokenDeck tokenDeck){ //TODO
        switch(code){
            case 1 -> System.out.println("??? Il reste dans la pile de tokens :" + tokenDeck); //Liste de token du jeu
            case 2 -> System.out.println("Ta pile de tokens :" + tokenDeck); //List de token du joueur
        }

    }
    public static void nobleDeckMessage(NobleDeck nobleDeck, int number){
        System.out.println("The nobility : (Watch, you can just stare and hope they come visit you. THAT ALL !)");
        int i = 1;
        for(var card : nobleDeck.getNobleDeck()){
            if(i<=4){
                System.out.println("    " + i + " -> " + card);
                i++;
            }
        }
    }
    public static void cardDeckMessage(DevDeck devDeck, boolean mode){ //TODO
        System.out.println("Voici les cartes en vitrine :");
        if(mode){
            int i = 1;
            for(var card : devDeck.getDevDeck().get(0)){
                if(i<=4){
                    System.out.println("    " + i + " -> " + card);
                    i++;
                }
            }
        } else {
            int i = 1;
            for (var level : devDeck.getDevDeck().entrySet()){
                System.out.println("Level " + level.getKey() + " :");
                for (var card : level.getValue()) {
                    if(i<=4){
                        System.out.println("    " + i + " -> " + card);
                        i++;
                    }
                }
                i = 1;
            }
        }
    }

    public static void takeCardMessage(int code){ //TODO
        switch (code){
            case 1 ->
                System.out.println("Quelle niveau de carte voulez-vous choisir? Entrez le niveau de 1 à 3 :");
            case 2 ->
                System.out.println("Choisir entre 1 à 4 pour choisir la carte.");
            case 3 ->
                System.out.println("You have chosen to purchase a reserved card.");

        }
    }

    public static void visitOfNoble(NobleCard noble){
        System.out.println("You had the visit of the noble :"+noble);
    }
    public static void successReserveMessage(){
        System.out.println("You’ve successfully reserve the card!");
    }
    public static void successBuyMessage(){
        System.out.println("You’ve successfully bought the card!");
    }

    public static void successTakeMessage(TokenDeck tokenDeck){
        System.out.println("You successfully collected :" + tokenDeck);
    }


    public static void createNumberPlayerMessage(){ //TODO
        System.out.println("Combien de joueur joue (entre 2 - 4):");
    }
    public static void createPlayerNameMessage(int index){
        System.out.println("============ [ Player " + index + " ] ============");
        System.out.println("Enter a nickname:");
    }
    public static void createPlayerAgeMessage(){
        System.out.println("Enter your age: ");
    }

    public static void firstPlayer(Player player){
        System.out.println(player.getName() + " goes first! Because... well, this player is the smallest! NIHAHAHA ");
    }

    public static void selectAction(Player p, boolean beta){
        System.out.println("===== " + p.getName() + " turn =====");
        System.out.println(p);
        if(beta){
            System.out.println("""
                        Choose your action  :
                        - (1) Take 3 gemstones of different colors
                        - (2) Take 2 gemstones of the same color
                        - (3) Purchase 1 development card using gemstones
                        """);
        } else {
            System.out.println("""
                        Choose your action  :
                        - (1) Take 3 gemstones of different colors
                        - (2) Take 2 gemstones of the same color
                        - (3) Purchase 1 development card using gemstones
                        - (4) Reserve 1 development card
                        """);
        }

    }
    public static void action(int code, TokenDeck tokenDeck){
        switch (code){
            case 1 ->
                System.out.println("""
                    You've chosen Action 1: Take 3 different gemstones.
                    Please enter the colors you want (green, blue, red, white, black) between :""" +
                    tokenDeck);
            case 2 ->
                System.out.println("""
                    Action 2 selected! Doubling up, are we?
                    Enter the color you want two of (green, blue, red, white, black) :""" +
                    tokenDeck);
            case 3 ->
                System.out.println("""
                    You're going for the big move: buying a development card!
                    Specify which card you want to buy.
                    Remember: every point counts!""");
            case 4 ->
                System.out.println("""
                    You're going to reserved a card!
                    Specify which one you want by giving its level and position.""");
        }
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
                    - (4) Reserve 1 development card
                Each card gives you 1 prestige point and costs 3 gemstones.
                
                A simple game to learn, but with strategic depth that guarantees hours of fun.
                Are you ready to become the most prestigious merchant of the era?
                
                """);
    }

}
