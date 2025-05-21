package fr.uge.splendor.phase1.model.card;

import fr.uge.splendor.model.token.Token;

import java.util.List;
import java.util.Objects;

public record CardsP1(List<Token> tokenRequire, int prestigePoints, int level) {
    public CardsP1 (List<Token> tokenRequire){
        this(tokenRequire, 1, 1);
        Objects.requireNonNull(tokenRequire);
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public List<Token> getTokenRequire(){
        return tokenRequire;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "(DevCard : \ntokenRequire=" + tokenRequire +
                "\nprestigePoints=" + prestigePoints +
                "\nlevel=" + level +
                ")\n";
    }
}
