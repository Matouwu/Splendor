package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;

import java.util.Objects;

public record TakeDiffCard(Player player, Game game) implements Action {
    public TakeDiffCard{
        Objects.requireNonNull(player);
        Objects.requireNonNull(game);
    }

    public boolean excecute(){
        return true;
    }
}
