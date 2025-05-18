package fr.uge.splendor.model.card;

import java.util.Map;
import java.util.Objects;

import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public enum DevCardLevel2 {
	
	ONYX_CAMELS_1(Map.of(WHITE, 3, BLUE, 2, GREEN, 2), BLACK, 1),
    ONYX_CAMELS_2(Map.of(WHITE, 3, GREEN, 3, BLACK, 2), BLACK, 1),
    ONYX_CAMELS_3(Map.of(BLUE, 1, GREEN, 4, RED, 2), BLACK, 2),
    ONYX_LAPIDARY_1(Map.of(GREEN, 5, RED, 3), BLACK, 2),
    ONYX_LAPIDARY_2(Map.of(WHITE, 5), BLACK, 2),
    ONYX_LAPIDARY_3(Map.of(BLACK, 6), BLACK, 3),

    SAPPHIRE_ELEPHANTS_1(Map.of(BLUE, 2, GREEN, 2, RED, 3), BLUE, 1),
    SAPPHIRE_ELEPHANTS_2(Map.of(BLUE, 2, GREEN, 3, BLACK, 3), BLUE, 1),
    SAPPHIRE_ELEPHANTS_3(Map.of(WHITE, 5, BLUE, 3), BLUE, 2),
    SAPPHIRE_LAPIDARY_1(Map.of(WHITE, 2, RED, 1, BLACK, 4), BLUE, 2),
    SAPPHIRE_LAPIDARY_2(Map.of(BLUE, 5), BLUE, 2),
    SAPPHIRE_LAPIDARY_3(Map.of(BLUE, 6), BLUE, 3),

    DIAMOND_SNOW_1(Map.of(GREEN, 3, RED, 2, BLACK, 2), WHITE, 1),
    DIAMOND_SNOW_2(Map.of(WHITE, 2, BLUE, 3, RED, 3), WHITE, 1),
    DIAMOND_SNOW_3(Map.of(GREEN, 1, RED, 4, BLACK, 2), WHITE, 2),
    DIAMOND_LAPIDARY_1(Map.of(RED, 5, BLACK, 3), WHITE, 2),
    DIAMOND_LAPIDARY_2(Map.of(RED, 5), WHITE, 2),
    DIAMOND_LAPIDARY_3(Map.of(WHITE, 6), WHITE, 3),

    EMERALD_GUY_1(Map.of(WHITE, 3, GREEN, 2, RED, 3), GREEN, 1),
    EMERALD_GUY_2(Map.of(WHITE, 2, BLUE, 3, BLACK, 2), GREEN, 1),
    EMERALD_GUY_3(Map.of(WHITE, 4, BLUE, 2, BLACK, 1), GREEN, 2),
    EMERALD_CARRACK_1(Map.of(BLUE, 5, GREEN, 3), GREEN, 2),
    EMERALD_CARRACK_2(Map.of(GREEN, 5), GREEN, 2),
    EMERALD_CARRACK_3(Map.of(GREEN, 6), GREEN, 3),

    RUBY_FELUCCA_1(Map.of(WHITE, 2, RED, 2, BLACK, 3), RED, 1),
    RUBY_FELUCCA_2(Map.of(BLUE, 3, RED, 2, BLACK, 3), RED, 1),
    RUBY_FELUCCA_3(Map.of(WHITE, 1, BLUE, 4, GREEN, 2), RED, 2),
    RUBY_LAPIDARY_1(Map.of(WHITE, 3, BLACK, 5), RED, 2),
    RUBY_LAPIDARY_2(Map.of(BLACK, 5), RED, 2),
    RUBY_LAPIDARY_3(Map.of(RED, 6), RED, 3);
	
	 private final Map<Color, Integer> tokenRequire;
	 private final Color tokenReduction;
	 private final int prestigePoints;
	 private final int level = 2;
	 
	 DevCardLevel2(Map<Color, Integer> tokenRequire, Color tokenReduction, int prestigePoints) {
	        this.tokenRequire = Objects.requireNonNull(tokenRequire);
	        this.tokenReduction = Objects.requireNonNull(tokenReduction);
	        this.prestigePoints = prestigePoints;
	 }

}
