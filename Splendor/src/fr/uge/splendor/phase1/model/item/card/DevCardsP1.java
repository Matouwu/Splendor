package fr.uge.splendor.phase1.model.item.card;

import fr.uge.splendor.phase1.model.item.token.TokenP1;

import java.util.List;

import static fr.uge.splendor.phase1.model.item.token.ColorP1.*;

public enum DevCardsP1 {
    GREEN_1(List.of(new TokenP1(GREEN,3))),
    GREEN_2(List.of(new TokenP1(GREEN,3))),
    GREEN_3(List.of(new TokenP1(GREEN,3))),
    GREEN_4(List.of(new TokenP1(GREEN,3))),
    GREEN_5(List.of(new TokenP1(GREEN,3))),
    GREEN_6(List.of(new TokenP1(GREEN,3))),
    GREEN_7(List.of(new TokenP1(GREEN,3))),
    GREEN_8(List.of(new TokenP1(GREEN,3))),

    BLUE_1(List.of(new TokenP1(BLUE,3))),
    BLUE_2(List.of(new TokenP1(BLUE,3))),
    BLUE_3(List.of(new TokenP1(BLUE,3))),
    BLUE_4(List.of(new TokenP1(BLUE,3))),
    BLUE_5(List.of(new TokenP1(BLUE,3))),
    BLUE_6(List.of(new TokenP1(BLUE,3))),
    BLUE_7(List.of(new TokenP1(BLUE,3))),
    BLUE_8(List.of(new TokenP1(BLUE,3))),

    RED_1(List.of(new TokenP1(RED,3))),
    RED_2(List.of(new TokenP1(RED,3))),
    RED_3(List.of(new TokenP1(RED,3))),
    RED_4(List.of(new TokenP1(RED,3))),
    RED_5(List.of(new TokenP1(RED,3))),
    RED_6(List.of(new TokenP1(RED,3))),
    RED_7(List.of(new TokenP1(RED,3))),
    RED_8(List.of(new TokenP1(RED,3))),

    WHITE_1(List.of(new TokenP1(WHITE,3))),
    WHITE_2(List.of(new TokenP1(WHITE,3))),
    WHITE_3(List.of(new TokenP1(WHITE,3))),
    WHITE_4(List.of(new TokenP1(WHITE,3))),
    WHITE_5(List.of(new TokenP1(WHITE,3))),
    WHITE_6(List.of(new TokenP1(WHITE,3))),
    WHITE_7(List.of(new TokenP1(WHITE,3))),
    WHITE_8(List.of(new TokenP1(WHITE,3))),

    BLACK_1(List.of(new TokenP1(BLACK,3))),
    BLACK_2(List.of(new TokenP1(BLACK,3))),
    BLACK_3(List.of(new TokenP1(BLACK,3))),
    BLACK_4(List.of(new TokenP1(BLACK,3))),
    BLACK_5(List.of(new TokenP1(BLACK,3))),
    BLACK_6(List.of(new TokenP1(BLACK,3))),
    BLACK_7(List.of(new TokenP1(BLACK,3))),
    BLACK_8(List.of(new TokenP1(BLACK,3)));

    public final List<TokenP1> tokenRequire;
    DevCardsP1(List<TokenP1> tokenRequire) {
        this.tokenRequire= List.copyOf(tokenRequire);
    }
}
