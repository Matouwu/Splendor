package fr.uge.splendor.phase1.model;

import fr.uge.splendor.model.token.Color;
import fr.uge.splendor.model.token.Token;

import java.util.*;

public class CardP1 {
    private List<Token> tokenRequire = new ArrayList<>();
    private final int prestigePoints;
    private final int level;

    public CardP1(List<Token> tokenRequire) {
        Objects.requireNonNull(tokenRequire);

        this.tokenRequire = List.copyOf(tokenRequire);
        this.prestigePoints = 1;
        this.level = 1;
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
        return "DevCard : \ntokenRequire=" + tokenRequire + 
        		"\nprestigePoints=" + prestigePoints + 
        		"\nlevel=" + level;
    }

}
