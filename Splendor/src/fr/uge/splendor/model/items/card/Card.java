package fr.uge.splendor.model.items.card;

import fr.uge.splendor.model.items.Color;

import java.util.Map;

public interface Card {
	
	
    int level();
    int prestigePoints();
    Map<Color, Integer> tokenRequire();
    Color tokenReduction();

}
