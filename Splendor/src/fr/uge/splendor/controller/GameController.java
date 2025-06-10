package fr.uge.splendor.controller;

import fr.uge.splendor.model.action.BuyCard;
import fr.uge.splendor.model.action.TakeToken;
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
    private TokenDeck setupTokenBoardDeck(boolean mode){
        var tokenDeck = new TokenDeck(new HashMap<>());
        if(mode){
            tokenDeck.initBoardTokenDeck(2, true);
        } else {
        }
        return tokenDeck;
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
        var tokenDeck = setupTokenBoardDeck(gameMode);
        var playerList = setupPlayerList(2);
        var currentPlayerIndex = setupPlayerIndex(playerList);
        ConsoleMessage.firstPlayer(playerList.get(currentPlayerIndex));
        this.game = new Game(devDeck, null, tokenDeck, playerList, currentPlayerIndex, true);
    }
    private void setupFinalMode() throws IOException { //FIXME
        this.gameMode = false;
        ConsoleMessage.finalStartMessage();
        var devDeck = setupDevBoardDeck();
        var nobleDeck = setupNobleDeck();
        var tokenDeck = setupTokenBoardDeck(gameMode);

        var playerList = setupPlayerList(7);
        var currentPlayerIndex = setupPlayerIndex(playerList);
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

    private TokenDeck setupDiffTokenDeck(){
        TokenDeck tokenDeck = new TokenDeck(new HashMap<>());
        Set<String> tmp = new HashSet<>();
        while(tokenDeck.getTokenDeck().size() < 3){
            var color = getInputColor(1);
            if(tmp.contains(color.name())){
                ConsoleMessage.wrongInputMessage(301, game.getTokenDeck());
            } else {
                game.getTokenDeck().getTokenDeck().put(color, game.getTokenDeck().getTokenDeck().get(color)-1);
                tmp.add(color.name());
                tokenDeck.addTokenDeck(color, 1);
            }
        }
        return tokenDeck;
    }

    private TokenDeck setupSameTokenDeck(){
        TokenDeck tokenDeck = new TokenDeck(new HashMap<>());
        var color = getInputColor(2);
        game.getTokenDeck().getTokenDeck().put(color, game.getTokenDeck().getTokenDeck().get(color)-2);
        tokenDeck.addTokenDeck(color, 2);
        return tokenDeck;
    }

    private DevCard setupBuyCard(){
        int level = 0;
        if(!gameMode){
            level = consoleView.inputInt();
            while (level<0 || level>game.getDevDeck().getDevDeck().size()){
                ConsoleMessage.wrongInputMessage(400, null);
                level = consoleView.inputInt();
            }
        }
        ConsoleMessage.tokenDeckMessage(2, game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck());
        ConsoleMessage.buyCardMessage(2,game.getDevDeck() , gameMode);
        var card = consoleView.inputInt();
        while (card<0 || card > 4){
            ConsoleMessage.wrongInputMessage(401, null);
            card = consoleView.inputInt();
        }
        return game.getDevDeck().removeDevCard(level, card);
    }

    private void gameRound(){
        ConsoleMessage.selectAction(game.getPlayerList().get(game.getCurrentPlayerIndex()));
        var action = consoleView.inputInt();
        while(action!=1 && action!=2 && action !=3){
            action = consoleView.inputInt();
        }
        switch(action){
            case 1 -> {
                ConsoleMessage.cardDeckMessage(game.getDevDeck(), gameMode);
                ConsoleMessage.action(1, game.getTokenDeck());
                var diffTokenDeck = setupDiffTokenDeck();
                TakeToken.execute(game, diffTokenDeck);
            }
            case 2 -> {
                ConsoleMessage.cardDeckMessage(game.getDevDeck(),gameMode);
                ConsoleMessage.action(2, game.getTokenDeck());
                var sameTokenDeck = setupSameTokenDeck();
                TakeToken.execute(game, sameTokenDeck);
            }
            case 3 -> {
                if(game.getPlayerList().get(game.getCurrentPlayerIndex()).getTokenDeck().getTokenDeck().isEmpty()){
                    ConsoleMessage.wrongInputMessage(402, null);
                } else {
                    ConsoleMessage.action(3, null);
                    var cardToBuy = setupBuyCard();
                    BuyCard.execute(game, cardToBuy);
                }
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
