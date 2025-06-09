package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.items.deck.TokenDeck;
import fr.uge.splendor.view.console.ConsoleMessage;

import java.util.Objects;

public class TakeToken {


    public static void execute(Game game, TokenDeck tokenDeck){
        Objects.requireNonNull(game);
        Objects.requireNonNull(tokenDeck);

        var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        player.addToken(tokenDeck);
        ConsoleMessage.successTakeMessage(tokenDeck);
        ConsoleMessage.tokenDeckMessage(game.getTokenDeck());
        System.out.println(player);
        game.nextPlayer();
    }
}
