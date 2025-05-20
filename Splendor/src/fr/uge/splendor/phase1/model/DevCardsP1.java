package fr.uge.splendor.phase1.model;

import fr.uge.splendor.model.token.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.uge.splendor.model.token.Color.*;

public enum DevCardsP1 {
    GREEN_1(Map.of(GREEN,3)),
    GREEN_2(Map.of(GREEN,3)),
    GREEN_3(Map.of(GREEN,3)),
    GREEN_4(Map.of(GREEN,3)),
    GREEN_5(Map.of(GREEN,3)),
    GREEN_6(Map.of(GREEN,3)),
    GREEN_7(Map.of(GREEN,3)),
    GREEN_8(Map.of(GREEN,3)),

    BLUE_1(Map.of(BLUE,3)),
    BLUE_2(Map.of(BLUE,3)),
    BLUE_3(Map.of(BLUE,3)),
    BLUE_4(Map.of(BLUE,3)),
    BLUE_5(Map.of(BLUE,3)),
    BLUE_6(Map.of(BLUE,3)),
    BLUE_7(Map.of(BLUE,3)),
    BLUE_8(Map.of(BLUE,3)),

    RED_1(Map.of(RED,3)),
    RED_2(Map.of(RED,3)),
    RED_3(Map.of(RED,3)),
    RED_4(Map.of(RED,3)),
    RED_5(Map.of(RED,3)),
    RED_6(Map.of(RED,3)),
    RED_7(Map.of(RED,3)),
    RED_8(Map.of(RED,3)),

    WHITE_1(Map.of(WHITE,3)),
    WHITE_2(Map.of(WHITE,3)),
    WHITE_3(Map.of(WHITE,3)),
    WHITE_4(Map.of(WHITE,3)),
    WHITE_5(Map.of(WHITE,3)),
    WHITE_6(Map.of(WHITE,3)),
    WHITE_7(Map.of(WHITE,3)),
    WHITE_8(Map.of(WHITE,3)),

    BLACK_1(Map.of(BLACK,3)),
    BLACK_2(Map.of(BLACK,3)),
    BLACK_3(Map.of(BLACK,3)),
    BLACK_4(Map.of(BLACK,3)),
    BLACK_5(Map.of(BLACK,3)),
    BLACK_6(Map.of(BLACK,3)),
    BLACK_7(Map.of(BLACK,3)),
    BLACK_8(Map.of(BLACK,3));

    private final Map<Color, Integer> tokenRequire = new HashMap<>();
    private final int prestigePoints;
    private final int level;
    DevCardsP1(Map<Color, Integer> tokenRequire) {
        this.tokenRequire.putAll(tokenRequire);
        this.prestigePoints = 1;
        this.level = 1;
    }

    public List<CardP1> listDevCards() {
        List<CardP1> result = new ArrayList<>();
        for (DevCardsP1 card : DevCardsP1.values()) {
            result.add(new CardP1(card.tokenRequire));
        }
        return List.copyOf(result);
    }
}
