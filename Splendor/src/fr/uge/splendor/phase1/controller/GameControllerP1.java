package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.token.ColorP1;
import fr.uge.splendor.phase1.model.card.CardsP1;
import fr.uge.splendor.phase1.model.card.DevCardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.*;

import static fr.uge.splendor.phase1.controller.ControllerP1.isValidEnum;


public class GameControllerP1 {
    private int currentPlayerIndex;
    private final List<PlayerP1> players = new ArrayList<>();
    private final Map<ColorP1, Integer> tokenPickaxe;
    private final List<CardsP1> cardPickaxe;

    private List<CardsP1> devCards;

    public GameControllerP1(List<PlayerP1> players, int currentPlayerIndex) {
        Objects.requireNonNull(players);
        if(players.size() != 2) throw new IllegalArgumentException("The number of players must equal 2");

        this.currentPlayerIndex = currentPlayerIndex;
        this.players.addAll(players);
        this.tokenPickaxe = new HashMap<>();
        setTokenPickaxe();
        this.devCards = DevCardsP1.listDevCards();
        this.cardPickaxe = new ArrayList<>();
        setCardPickaxe();
    }

    public void setTokenPickaxe() {
        tokenPickaxe.put(ColorP1.GREEN, 4);
        tokenPickaxe.put(ColorP1.BLUE, 4);
        tokenPickaxe.put(ColorP1.RED, 4);
        tokenPickaxe.put(ColorP1.WHITE, 4);
        tokenPickaxe.put(ColorP1.BLACK, 4);
    }

    public void setCardPickaxe() {
        Random rand = new Random();

        while(cardPickaxe.size() < 3) {
            if(devCards.isEmpty()) throw new IllegalArgumentException("DevCards is empty");
            int cardIndex = rand.nextInt(devCards.size());
            CardsP1 card = devCards.remove(cardIndex);
            cardPickaxe.add(card);
        }
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
            return color;
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

        PlayerP1 player = players.get(currentPlayerIndex);
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

        PlayerP1 player = players.get(currentPlayerIndex);
        player.addToken(tokenMap);
        System.out.println(player);
        nextPlayer();
    }
    public void action3(){

    }



    public void oneRound(String action) {
        switch (action) {
            case "a1" -> action1();
            case "a2" -> action2();
            case "a3" -> action3();
        }
    }


}
