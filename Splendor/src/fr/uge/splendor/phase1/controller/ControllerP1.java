package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.card.CardsP1;
import fr.uge.splendor.phase1.model.card.DevCardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;
import fr.uge.splendor.phase1.model.token.ColorP1;

import java.util.List;

public class ControllerP1 {

    public static int startPlayer(List<PlayerP1> playerP1List) {
        var p1 = playerP1List.get(0);
        var p2 = playerP1List.get(1);

        if(p1.getAge() < p2.getAge()) {
            return 0;
        }
        return 1;
    }

    public static boolean checkGameEnd(List<PlayerP1> playerP1List) {
        for(PlayerP1 p: playerP1List) {
            if(p.getPrestigePoints() >= 15) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEnum(String input) {
        for (ColorP1 color : ColorP1.values()) {
            if (color.name().equals(input.toUpperCase())) {
                return true; // Si la valeur existe dans l'énum, on retourne true
            }
        }
        return false; // Sinon, retourne false
    }


}
