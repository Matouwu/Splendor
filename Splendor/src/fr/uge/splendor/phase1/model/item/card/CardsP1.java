package fr.uge.splendor.phase1.model.item.card;

import fr.uge.splendor.phase1.model.item.token.TokenP1;

import java.util.List;
import java.util.Objects;

public record CardsP1(List<TokenP1> tokenRequire, int prestigePoints, int level) {
    public CardsP1 (List<TokenP1> tokenRequire){
        this(tokenRequire, 1, 1);
        Objects.requireNonNull(tokenRequire);
    }

    public int getPrestigePoints() {
        return prestigePoints;
    }

    public List<TokenP1> getTokenRequire(){
        return tokenRequire;
    }
    public int prestigePoints() {return prestigePoints;}
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
