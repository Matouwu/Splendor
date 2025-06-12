package fr.uge.splendor.controller;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;
import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.NobleDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;
import fr.uge.splendor.view.console.ConsoleMessage;
import fr.uge.splendor.view.console.ConsoleView;

import java.io.IOException;
import java.util.*;


public class GameController {
    private final ConsoleView consoleView;
    private Game game;
    private boolean gameMode;
    public GameController(ConsoleView consoleView){
        Objects.requireNonNull(consoleView);
        this.consoleView = consoleView;
    }


    /* ========== Setup fiels ========== */

    private DevDeck setupBetaDevBoardDeck(){
        DevDeck devDeck = new DevDeck(gameMode);
        devDeck.loadBetaCards();
        return devDeck;
    }
    private DevDeck setupDevBoardDeck() throws IOException {
        var devDeck = new DevDeck(gameMode);
        devDeck.loadAllCards();
        return devDeck;
    }
    private NobleDeck setupNobleDeck(){
        var nobleDeck = new NobleDeck();
        nobleDeck.loadAllNoble();
        return nobleDeck;
    }
    private TokenDeck setupTokenBoardDeck(int nbPlayer, boolean beta){
        var tokenDeck = new TokenDeck(new HashMap<>());
        tokenDeck.initBoardTokenDeck(nbPlayer, beta);
        return tokenDeck;
    }
    private int setupPlayerNumber(){
        ConsoleMessage.createNumberPlayerMessage();
        int nb = consoleView.inputInt();
        while (nb<2 || nb>4){
            ConsoleMessage.wrongInputMessage(201, null);
            nb = consoleView.inputInt();
        }
        return nb;
    }
    private List<Player> setupPlayerList(int index){
        List<Player> playersList = new ArrayList<>();
        for(int i=0; i<index; i++){
            ConsoleMessage.createPlayerNameMessage(i+1);
            var name = consoleView.inputString();
            ConsoleMessage.createPlayerAgeMessage();
            var age = consoleView.inputInt();
            while(age<0 || age > 150){
                ConsoleMessage.wrongInputMessage(1,null);
                age = consoleView.inputInt();
            }
            Player p = new Player(name, age, gameMode);
            playersList.add(p);

            System.out.println(p);
        }
        return List.copyOf(playersList);
    }
    private int setupPlayerIndex(List<Player> playerList){
        Objects.requireNonNull(playerList);
        int index = 0;
        Player younger = playerList.getFirst();
        int i=0;
        for(var p :playerList){
            if(p.getAge()< younger.getAge()){
                index = i;
                younger = p;
            }
            i++;
        }
        return index;
    }


    /* ========== Setup Game mode ========== */

    private void setupBetaMode(){
        this.gameMode = true;
        ConsoleMessage.betaStartMessage();
        var devDeck = setupBetaDevBoardDeck();
        var tokenDeck = setupTokenBoardDeck(2, true);
        var playerList = setupPlayerList(2);
        var currentPlayerIndex = setupPlayerIndex(playerList);
        ConsoleMessage.firstPlayer(playerList.get(currentPlayerIndex));
        this.game = new Game(devDeck, null, tokenDeck, playerList, currentPlayerIndex, true);
    }
    private void setupFinalMode() throws IOException {
        this.gameMode = false;
        ConsoleMessage.finalStartMessage();
        var devDeck = setupDevBoardDeck();
        var nobleDeck = setupNobleDeck();
        var nbPlayer = setupPlayerNumber();
        var playerList = setupPlayerList(nbPlayer);
        var currentPlayerIndex = setupPlayerIndex(playerList);
        var tokenDeck = setupTokenBoardDeck(playerList.size(), false);
        ConsoleMessage.firstPlayer(playerList.get(currentPlayerIndex));
        this.game = new Game(devDeck, nobleDeck, tokenDeck, playerList, currentPlayerIndex, false);

    }


    /* ========== Game log ========== */

    private void gameConfig() throws IOException {
        var mode = consoleView.gameMode();
        while(!mode.equalsIgnoreCase("B") && !mode.equalsIgnoreCase("F")){
            ConsoleMessage.wrongInputMessage(100, null);
            mode = consoleView.gameMode();
        }
        switch (mode.toUpperCase()){
            case "B" -> setupBetaMode();
            case "F" -> setupFinalMode();
        }
    }


    /* ========== Input ========== */

    private Color getInputColor(int nbTake) {
        var input = consoleView.inputString();
        while(!Color.isValidEnum(input)){
            ConsoleMessage.wrongInputMessage(300, null);
            input = consoleView.inputString();
        }
        Color color = Color.valueOf(input.toUpperCase());
        while(nbTake==1 && game.getTokenDeck().getTokenDeck().get(color) < 1 ||
                nbTake==2 && game.getTokenDeck().getTokenDeck().get(color) < 2) {
            ConsoleMessage.wrongInputMessage(302, game.getTokenDeck());
            input = consoleView.inputString();
            while(!Color.isValidEnum(input)){
                ConsoleMessage.wrongInputMessage(300, null);
                input = consoleView.inputString();
            }
            color = Color.valueOf(input.toUpperCase());
        }
        return color;
    }

    /* ========== Action method ========== */

    private void actionDiffTokenDeck(){
        var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        if(player.getTokenNum()+3>10) {
            ConsoleMessage.wrongInputMessage(303, null);
        } else {
            TokenDeck tokenDeck = new TokenDeck(new HashMap<>());
            Set<String> tmp = new HashSet<>();
            while (tokenDeck.getTokenDeck().size() < 3) {
                var color = getInputColor(1);
                if (tmp.contains(color.name())) {
                    ConsoleMessage.wrongInputMessage(301, game.getTokenDeck());
                } else {
                    game.getTokenDeck().getTokenDeck().put(color, game.getTokenDeck().getTokenDeck().get(color) - 1);
                    tmp.add(color.name());
                    tokenDeck.addTokenDeck(color, 1);
                }
            }
            player.addToken(tokenDeck);
            ConsoleMessage.successTakeMessage(tokenDeck);
            ConsoleMessage.tokenDeckMessage(1, game.getTokenDeck());
            System.out.println(player);
            game.nextPlayer();
        }
    }

    private void actionSameTokenDeck(){
        var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        if(player.getTokenNum()+3>10) {
            ConsoleMessage.wrongInputMessage(303, null);
        } else {
            TokenDeck tokenDeck = new TokenDeck(new HashMap<>());
            var color = getInputColor(2);
            game.getTokenDeck().getTokenDeck().put(color, game.getTokenDeck().getTokenDeck().get(color) - 2);
            tokenDeck.addTokenDeck(color, 2);
            player.addToken(tokenDeck);
            ConsoleMessage.successTakeMessage(tokenDeck);
            ConsoleMessage.tokenDeckMessage(1, game.getTokenDeck());
            System.out.println(player);
            game.nextPlayer();
        }
    }

    private int buyLevel(boolean code){
        int level = 0;
        if(!gameMode) {
            if (code) {
                ConsoleMessage.takeCardMessage(1);
                System.out.println("(ou 4 pour acheter une carte réservée)");

            } else {
                ConsoleMessage.takeCardMessage(3);
                ConsoleMessage.takeCardMessage(1);
            }
            level = consoleView.inputInt();
            while (level < 0 || level > game.getDevDeck().getDevDeck().size() + 1) {
                ConsoleMessage.wrongInputMessage(400, null);
                level = consoleView.inputInt();
            }
        }
        return level;
    }
    private int buyCardIndex(boolean isReserved){
        if(isReserved){
            ConsoleMessage.cardDeckMessage(game.getPlayerList().get(game.getCurrentPlayerIndex()).getDevDeckReserved(), gameMode);
        } else {
            ConsoleMessage.cardDeckMessage(game.getDevDeck(), gameMode);
        }
        ConsoleMessage.tokenDeckMessage(2, game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck());
        ConsoleMessage.takeCardMessage(2);
        var cardIndex = consoleView.inputInt();

        int code = 401;
        boolean test = cardIndex > 4;
        if(isReserved){
            code = 501;
            test = cardIndex>game.getPlayerList().get(game.getCurrentPlayerIndex()).getDevDeckReserved().getDevDeck().size();
        }
        while (cardIndex<0 || test){
            ConsoleMessage.wrongInputMessage(code, null);
            cardIndex = consoleView.inputInt();
        }
        return cardIndex;
    }
    private DevCard buyDevCard(int level, int cardIndex, boolean reserved){
        DevCard devCard;
        if(reserved){
            devCard = game.getPlayerList().get(game.getCurrentPlayerIndex()).getDevDeckReserved().removeDevCard(level,cardIndex);
        } else {
            devCard = game.getDevDeck().removeDevCard(level, cardIndex);
        }
        return devCard;
    }

    private void actionBuyCard(){
        if(game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck().isEmpty()){
            ConsoleMessage.wrongInputMessage(202, null);
        } else {
            int level = buyLevel(true);
            boolean reserved = false;
            if(level==4){
                level = buyLevel(false);
                reserved = true;
            }
            var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
            int cardIndex = buyCardIndex(reserved);
            var devCard = buyDevCard(level, cardIndex, reserved);
            if(player.checkCanBuy(devCard.tokenRequire())){
                player.addCardsList(devCard);
                game.getTokenDeck().addTokenDeck(devCard.tokenRequire());
                ConsoleMessage.successBuyMessage();
                var noble  = game.checkNobleVisit();
                if(noble != null){
                    ConsoleMessage.visitOfNoble(noble);
                }
                System.out.println(player);
                game.nextPlayer();
            } else {
                ConsoleMessage.wrongInputMessage(402,null);
            }
        }
    }

    private void actionReservedCard() {
        var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        if (player.getDevDeckReserved().getDevDeck().size() > 3){
            ConsoleMessage.wrongInputMessage(500, null);
        } else {
            int level = 0;
            if (!gameMode) {
                ConsoleMessage.takeCardMessage(1);
                level = consoleView.inputInt();
                while (level < 0 || level > game.getDevDeck().getDevDeck().size()) {
                    ConsoleMessage.wrongInputMessage(400, null);
                    level = consoleView.inputInt();
                }
            }
            ConsoleMessage.tokenDeckMessage(2, game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck());
            ConsoleMessage.cardDeckMessage(game.getDevDeck(), gameMode);
            ConsoleMessage.takeCardMessage(2);
            var card = consoleView.inputInt();
            while (card < 0 || card > 4) {
                ConsoleMessage.wrongInputMessage(401, null);
                card = consoleView.inputInt();
            }
            var devCard = game.getDevDeck().removeDevCard(level, card);

            player.addCardsReserveList(devCard);
            player.getTokenDeck().addTokenDeck(Color.YELLOW,1);
            game.getTokenDeck().getTokenDeck().put(Color.YELLOW, game.getTokenDeck().getTokenDeck().get(Color.YELLOW) - 1);
            ConsoleMessage.successReserveMessage();
            System.out.println(player);
            game.nextPlayer();
        }
    }

    private void gameRound(){;
        ConsoleMessage.selectAction(game.getPlayerList().get(game.getCurrentPlayerIndex()), gameMode);
        var action = consoleView.inputInt();
        while(action!=1 && action!=2 && action!=3 && action!=4){
            action = consoleView.inputInt();
        }
        switch(action){
            case 1 -> {
                ConsoleMessage.nobleDeckMessage(game.getNobleDeck(), game.getPlayerList().size());
                ConsoleMessage.cardDeckMessage(game.getDevDeck(), gameMode);
                ConsoleMessage.action(1, game.getTokenDeck());
                actionDiffTokenDeck();
            }
            case 2 -> {
                ConsoleMessage.nobleDeckMessage(game.getNobleDeck(), game.getPlayerList().size());
                ConsoleMessage.cardDeckMessage(game.getDevDeck(),gameMode);
                ConsoleMessage.action(2, game.getTokenDeck());
                actionSameTokenDeck();
            }
            case 3 -> {
                if(game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck().getTokenDeck().isEmpty()){
                    ConsoleMessage.wrongInputMessage(402, null);
                } else {
                    ConsoleMessage.nobleDeckMessage(game.getNobleDeck(), game.getPlayerList().size());
                    ConsoleMessage.action(3, null);
                    actionBuyCard();
                }
            }
            case 4 -> {
                ConsoleMessage.nobleDeckMessage(game.getNobleDeck(), game.getPlayerList().size());
                ConsoleMessage.action(4, null);
                actionReservedCard();
            }
        }
    }

    public void run() throws IOException {

        ConsoleMessage.startMessage();
        gameConfig();
        ConsoleMessage.startRound();

        int winnerIndex = game.checkGameEnd();
        while(winnerIndex==-1){
            gameRound();
            winnerIndex = game.checkGameEnd();
        }
        ConsoleMessage.enGame(game.getPlayerList().get(winnerIndex));
    }

}
