package fr.uge.splendor.phase1.controller;

import fr.uge.splendor.phase1.model.card.CardsP1;
import fr.uge.splendor.phase1.model.card.DevCardsP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.List;

public class ControllerP1 {
    private List<CardsP1> cards = DevCardsP1.listDevCards();


    public static int startPlayer(List<PlayerP1> playerP1List) {
        var p1 = playerP1List.get(0);
        var p2 = playerP1List.get(1);

        if(p1.getAge() < p2.getAge()) {
            return 0;
        }
        return 1;
    }



    public static void pickToken(){

    }
}
