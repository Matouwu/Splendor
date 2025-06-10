package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.view.console.ConsoleMessage;

import java.util.Objects;

public class BuyCard {
    public static void execute(Game game, DevCard devCard){
        Objects.requireNonNull(game);
        Objects.requireNonNull(devCard);

        var player = game.getPlayerList().get(game.getCurrentPlayerIndex());
        player.addCardsList(devCard);
        game.getTokenDeck().addTokenDeck(devCard.tokenRequire());
        ConsoleMessage.successBuyMessage();
        System.out.println(player);
        game.nextPlayer();
    }
}
