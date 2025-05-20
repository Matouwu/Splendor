package fr.uge.splendor.phase1.model;

import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.uge.splendor.model.token.Color.*;

public enum DevCardsP1 {
    GREEN_1(List.of(new Token(GREEN,3))),
    GREEN_2(List.of(new Token(GREEN,3))),
    GREEN_3(List.of(new Token(GREEN,3))),
    GREEN_4(List.of(new Token(GREEN,3))),
    GREEN_5(List.of(new Token(GREEN,3))),
    GREEN_6(List.of(new Token(GREEN,3))),
    GREEN_7(List.of(new Token(GREEN,3))),
    GREEN_8(List.of(new Token(GREEN,3))),

    BLUE_1(List.of(new Token(BLUE,3))),
    BLUE_2(List.of(new Token(BLUE,3))),
    BLUE_3(List.of(new Token(BLUE,3))),
    BLUE_4(List.of(new Token(BLUE,3))),
    BLUE_5(List.of(new Token(BLUE,3))),
    BLUE_6(List.of(new Token(BLUE,3))),
    BLUE_7(List.of(new Token(BLUE,3))),
    BLUE_8(List.of(new Token(BLUE,3))),

    RED_1(List.of(new Token(RED,3))),
    RED_2(List.of(new Token(RED,3))),
    RED_3(List.of(new Token(RED,3))),
    RED_4(List.of(new Token(RED,3))),
    RED_5(List.of(new Token(RED,3))),
    RED_6(List.of(new Token(RED,3))),
    RED_7(List.of(new Token(RED,3))),
    RED_8(List.of(new Token(RED,3))),

    WHITE_1(List.of(new Token(WHITE,3))),
    WHITE_2(List.of(new Token(WHITE,3))),
    WHITE_3(List.of(new Token(WHITE,3))),
    WHITE_4(List.of(new Token(WHITE,3))),
    WHITE_5(List.of(new Token(WHITE,3))),
    WHITE_6(List.of(new Token(WHITE,3))),
    WHITE_7(List.of(new Token(WHITE,3))),
    WHITE_8(List.of(new Token(WHITE,3))),

    BLACK_1(List.of(new Token(BLACK,3))),
    BLACK_2(List.of(new Token(BLACK,3))),
    BLACK_3(List.of(new Token(BLACK,3))),
    BLACK_4(List.of(new Token(BLACK,3))),
    BLACK_5(List.of(new Token(BLACK,3))),
    BLACK_6(List.of(new Token(BLACK,3))),
    BLACK_7(List.of(new Token(BLACK,3))),
    BLACK_8(List.of(new Token(BLACK,3)));

    private List<Token> tokenRequire = new ArrayList<>();
    private final int prestigePoints;
    private final int level;
    DevCardsP1(List<Token> tokenRequire) {
        this.tokenRequire= List.copyOf(tokenRequire);
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
