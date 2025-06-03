package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;

import java.util.Objects;

public record TakeSameCard(Player player, Game game) implements Action {
    public TakeSameCard {
        Objects.requireNonNull(player);
        Objects.requireNonNull(game);
    }

    public boolean excecute(){
        return true;
    }
}
