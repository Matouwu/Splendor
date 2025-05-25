package fr.uge.splendor.phase1.model.gameboard.bank;

import fr.uge.splendor.phase1.model.item.token.ColorP1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TokenBank {
    private final Map<ColorP1, Integer> tokenPickaxe = new HashMap<>();

    public TokenBank() {
        setTokenPickaxe();
    }

    public void setTokenPickaxe() {
        tokenPickaxe.put(ColorP1.GREEN, 4);
        tokenPickaxe.put(ColorP1.BLUE, 4);
        tokenPickaxe.put(ColorP1.RED, 4);
        tokenPickaxe.put(ColorP1.WHITE, 4);
        tokenPickaxe.put(ColorP1.BLACK, 4);
    }

    public void addTokenPickaxe(ColorP1 color, int amount) {
        Objects.requireNonNull(color);
        tokenPickaxe.put(color, tokenPickaxe.get(color)+amount);
    }
    public void removeTokenPickaxe(ColorP1 color) {
        Objects.requireNonNull(color);
        if(tokenPickaxe.get(color) < 0) throw new IllegalArgumentException();
        tokenPickaxe.put(color, tokenPickaxe.get(color)-1);
    }
}
