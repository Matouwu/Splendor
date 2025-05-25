package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.item.token.ColorP1;
import fr.uge.splendor.phase1.model.item.card.CardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.*;

import static fr.uge.splendor.phase1.controller.ControllerP1.isValidEnum;


public class GameControllerP1 {
    private int currentPlayerIndex;
    private final List<PlayerP1> players = new ArrayList<>();


    private final List<CardsP1> devCards;

    public GameControllerP1(List<PlayerP1> players, int currentPlayerIndex) {
        Objects.requireNonNull(players);
        if(players.size() != 2) throw new IllegalArgumentException("The number of players must equal 2");

        this.currentPlayerIndex = currentPlayerIndex;
        this.players.addAll(players);

        this.devCards = DevCardsPickaxe.listDevCards();
        this.cardPickaxe = new ArrayList<>();
        setCardPickaxe();
    }


    public void nextPlayer() {
        this.currentPlayerIndex = (currentPlayerIndex + 1)%2;
    }

    public ColorP1 getInputColor(int a) {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine();
        while(!isValidEnum(input)){
            System.out.println("""
                (Couleur invalide!)
                ATTENTION A TOI, JE SAIS OU TU HABITE !
                Tu dois rentrer soit green, blue, red, white, black !""");
            input = sc.nextLine();
        }
        ColorP1 color = ColorP1.valueOf(input.toUpperCase());
        while(a==1 && tokenPickaxe.get(color) < 1 ||
        a==2 && tokenPickaxe.get(color) < 2) {
            System.out.println("""
                (Couleur indisponible!)
                ATTENTION A TOI, JE SAIS OU TU HABITE !
                Tu dois rentrer une couleur disponible entre :""" + tokenPickaxe);
            input = sc.nextLine();
            color = ColorP1.valueOf(input.toUpperCase());
        }
        sc.close();
        return color;
    }

    private void buy(PlayerP1 player, CardsP1 chosenCard) {
        Objects.requireNonNull(player);
        if (player.removeToken(chosenCard.getTokenRequire())){
            player.addCardsList(chosenCard);
            cardPickaxe.remove(chosenCard);
            System.out.println("Carte achetée avec succès !");
            if (!devCards.isEmpty()) {
                setCardPickaxe();
            } else {
                System.out.println("Il n'y a plus de carte dans la pioche.");
            }
        } else {
            System.out.println("Erreur : les jetons n'ont pas pu être retirés." +
                    "Vous ne disposez pas assez de jetons pour acheter la carte\n");
        }
    }


    public void action1(){
        System.out.println("Tu dois donc choisir 3 pierres précieuses entre : " + tokenPickaxe +
                "\nPour cela tu va rentrer les couleurs que tu veux (green, blue, red, white, black):");

        Map<ColorP1,Integer> tokenMap = new HashMap<>();
        Set<String> tmp = new HashSet<>();
        while(tokenMap.size() < 3) {
            var color = getInputColor(1);
            if(tmp.contains(color.name())){
                System.out.println("""
                    (Couleur invalide!)
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer une couleur different de ce que tu a déja rentré !""");
            } else {
                tokenPickaxe.put(color, tokenPickaxe.get(color)-1);
                tokenMap.put(color, 1);
                tmp.add(color.name());
            }
        }
        System.out.println("Tu a récupéré : " + tokenMap);
        System.out.println("Il ne reste plus que : " + tokenPickaxe);

        var player = players.get(currentPlayerIndex);
        player.addToken(tokenMap);
        System.out.println(player);
        nextPlayer();
    }

    public void action2(){
        System.out.println("Tu va choisir 2 pierres identiques entre : " + tokenPickaxe+
                "\nPour cela tu devra rentrer UNE couleur de ton choix entre (green, blue, red, white, black):");

        Map<ColorP1,Integer> tokenMap = new HashMap<>();
        var color = getInputColor(2);
        tokenPickaxe.put(color, tokenPickaxe.get(color)-2);
        tokenMap.put(color, 2);

        System.out.println("Tu a récupéré : " + tokenMap);
        System.out.println("Il ne reste plus que : " + tokenPickaxe);

        var player = players.get(currentPlayerIndex);
        player.addToken(tokenMap);
        System.out.println(player);
        nextPlayer();
    }

    public void action3() {
        var currentPlayer = players.get(currentPlayerIndex);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tu peux acheter des cartes si tu le souhaites, voici les cartes à l'achat :");
        int i = 1;
        for (CardsP1 card : cardPickaxe) {
            System.out.println(i + " -> " + card);
            i++;
        }
        System.out.println("Quelle carte voulez-vous acheter ? (Entrez le numéro de 1 à " + cardPickaxe.size() + ")");
        var choice = scanner.nextInt();
        while (choice < 1 || choice > cardPickaxe.size()) {
            System.out.println("""
                    (Choix invalide!)
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer une chiffre entre 1 et""" +cardPickaxe.size() + ")");
            choice = scanner.nextInt();
        }

        var chosenCard = cardPickaxe.get(choice - 1);
        var cardCost = chosenCard.getTokenRequire();
        System.out.println("Coût de la carte : " + cardCost);
        System.out.println("Jetons du joueur : " + currentPlayer.getTokens());

        buy(currentPlayer, chosenCard);
        System.out.println(currentPlayer);
        nextPlayer();
        scanner.close();
    }


    public void oneRound(String action) {
        switch (action) {
            case "a1" -> action1();
            case "a2" -> action2();
            case "a3" -> action3();
        }
    }


}
