package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.player.PlayerP1;
import fr.uge.splendor.phase1.model.item.token.ColorP1;

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

    public static boolean isValidEnum(String input) {
        for (ColorP1 color : ColorP1.values()) {
            if (color.name().equals(input.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static int checkGameEnd(List<PlayerP1> playerP1List) {
        for(PlayerP1 p: playerP1List) {
            if(p.getPrestigePoints() >= 15) {
                return playerP1List.indexOf(p);
            }
        }
        return -1;
    }


}
