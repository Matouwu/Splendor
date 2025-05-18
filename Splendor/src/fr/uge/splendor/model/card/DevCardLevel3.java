package fr.uge.splendor.model.card;

import java.util.Map;
import java.util.Objects;

import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;

public enum DevCardLevel3 {

	ONYX_STREET_1(Map.of(WHITE, 3, BLUE, 3, GREEN, 5, RED, 3), BLACK, 3),
    ONYX_STREET_2(Map.of(RED, 7), BLACK, 4),
    ONYX_STREET_3(Map.of(GREEN, 3, RED, 6, BLACK, 3), BLACK, 4),
    ONYX_STREET_4(Map.of(RED, 7, BLACK, 3), BLACK, 5),

    SAPPHIRE_VENICE_1(Map.of(WHITE, 3, GREEN, 3, RED, 3, BLACK, 5), BLUE, 3),
    SAPPHIRE_VENICE_2(Map.of(WHITE, 7), BLUE, 4),
    SAPPHIRE_DIAMOND_SHOP_1(Map.of(WHITE, 6, BLUE, 3, BLACK, 3), BLUE, 4),
    SAPPHIRE_DIAMOND_SHOP_2(Map.of(WHITE, 7, BLUE, 3), BLUE, 5),

    DIAMOND_BUILDING_1(Map.of(BLUE, 3, GREEN, 3, RED, 5, BLACK, 3), WHITE, 3),
    DIAMOND_GIOIELLERIA_1(Map.of(BLACK, 7), WHITE, 4),
    DIAMOND_GIOIELLERIA_2(Map.of(WHITE, 3, RED, 3, BLACK, 6), WHITE, 4),
    DIAMOND_BUILDING_2(Map.of(WHITE, 3, BLACK, 7), WHITE, 5),

    EMERALD_TIMBERED_1(Map.of(WHITE, 5, BLUE, 3, RED, 3, BLACK, 3), GREEN, 3),
    EMERALD_BRIDGE_1(Map.of(BLUE, 7), GREEN, 4),
    EMERALD_BRIDGE_2(Map.of(WHITE, 3, BLUE, 6, GREEN, 3), GREEN, 4),
    EMERALD_TIMBERED_2(Map.of(BLUE, 7, GREEN, 3), GREEN, 5),

    RUBY_STATUE_1(Map.of(WHITE, 3, BLUE, 5, GREEN, 3, BLACK, 3), RED, 3),
    RUBY_STATUE_2(Map.of(GREEN, 7), RED, 4),
    RUBY_BUILDING_1(Map.of(BLUE, 3, GREEN, 6, RED, 3), RED, 4),
    RUBY_BUILDING_2(Map.of(GREEN, 7, RED, 3), RED, 5);

	
	 private final Map<Color, Integer> tokenRequire;
	 private final Color tokenReduction;
	 private final int prestigePoints;
	 private final int level = 1;
	 
	 DevCardLevel3(Map<Color, Integer> tokenRequire, Color tokenReduction, int prestigePoints) {
	        this.tokenRequire = Objects.requireNonNull(tokenRequire);
	        this.tokenReduction = Objects.requireNonNull(tokenReduction);
	        this.prestigePoints = prestigePoints;
	 }
}
