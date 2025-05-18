package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public enum DevCardLevel1 {

	
	 ONYX_MINE_1(Map.of(WHITE, 1, BLUE, 1, GREEN, 1, RED, 1), BLACK, 0),
	 ONYX_MINE_2(Map.of(WHITE, 1, BLUE, 2,GREEN, 1, RED, 1), BLACK, 0),
	 ONYX_MINE_3(Map.of(WHITE, 2, BLUE, 2, RED, 1),BLACK, 0),
	 ONYX_MINE_4(Map.of(GREEN, 1, RED, 3, BLACK, 1), BLACK, 0),
	 ONYX_MINE_5(Map.of(GREEN, 2, RED, 1), BLACK, 0),
	 ONYX_MINE_6(Map.of(WHITE, 2, GREEN, 2), BLACK, 0),
	 ONYX_MINE_7(Map.of(GREEN, 3), BLACK, 0),
	 ONYX_MINE_8(Map.of(BLUE, 4), BLACK, 1),
	
	
	 SAPHIRE_MINE_1(Map.of(WHITE, 1, GREEN, 1, RED, 1, BLACK, 1), BLUE, 0),
	 SAPHIRE_MINE_2(Map.of(WHITE, 1, GREEN, 1, RED, 2, BLACK, 1), BLUE, 0),
	 SAPHIRE_MINE_3(Map.of(WHITE, 1, GREEN, 2, RED, 2), BLUE, 0),
	 SAPHIRE_MINE_4(Map.of(BLUE, 1, GREEN, 3, RED, 1), BLUE, 0),
	 SAPHIRE_MINE_5(Map.of(WHITE, 1, BLACK, 2), BLUE, 0),
	 SAPHIRE_MINE_6(Map.of(GREEN, 2, BLACK, 2), BLUE, 0),
	 SAPHIRE_MINE_7(Map.of(BLACK, 3), BLUE, 0),
	 SAPHIRE_MINE_8(Map.of(RED, 4), BLUE, 1),
	
	 DIAMOND_MINE_1(Map.of(BLUE, 1, GREEN, 1, RED, 1, BLACK, 1), WHITE, 0),
	 DIAMOND_MINE_2(Map.of(BLUE, 1, GREEN, 2, RED, 1, BLACK, 1), WHITE, 0),
	 DIAMOND_MINE_3(Map.of(BLUE, 2, GREEN, 2, BLACK, 1), WHITE, 0),
	 DIAMOND_MINE_4(Map.of(WHITE, 3, BLUE, 1, BLACK, 1), WHITE, 0),
	 DIAMOND_MINE_5(Map.of(RED, 2, BLACK, 1), WHITE, 0),
	 DIAMOND_MINE_6(Map.of(BLUE, 2, BLACK, 2), WHITE, 0),
	 DIAMOND_MINE_7(Map.of(BLUE, 3), WHITE, 0),
	 DIAMOND_MINE_8(Map.of(GREEN, 4), WHITE, 1),

    
	 EMERALD_MINE_1(Map.of(WHITE, 1, BLUE, 1, RED, 1, BLACK, 1), GREEN, 0),
	 EMERALD_MINE_2(Map.of(WHITE, 1, BLUE, 1, RED, 1, BLACK, 2), GREEN, 0),
	 EMERALD_MINE_3(Map.of(BLUE, 1, RED, 2, BLACK, 2), GREEN, 0),
	 EMERALD_MINE_4(Map.of(WHITE, 1, BLUE, 3, GREEN, 1), GREEN, 0),
	 EMERALD_MINE_5(Map.of(WHITE, 2, BLUE, 1), GREEN, 0),
	 EMERALD_MINE_6(Map.of(BLUE, 2, RED, 2), GREEN, 0),
	 EMERALD_MINE_7(Map.of(RED, 3), GREEN, 0),
	 EMERALD_MINE_8(Map.of(BLACK, 4), GREEN, 1),
    
	 RUBY_MINE_1(Map.of(WHITE, 1, BLUE, 1, GREEN, 1, BLACK, 1), RED, 0),
	 RUBY_MINE_2(Map.of(WHITE, 2, BLUE, 1, GREEN, 1, BLACK, 1), RED, 0),
	 RUBY_MINE_3(Map.of(WHITE, 2, GREEN, 1, BLACK, 2), RED, 0),
	 RUBY_MINE_4(Map.of(WHITE, 1, RED, 1, BLACK, 3), RED, 0),
	 RUBY_MINE_5(Map.of(BLUE, 2, GREEN, 1), RED, 0),
	 RUBY_MINE_6(Map.of(WHITE, 2, RED, 2), RED, 0),
	 RUBY_MINE_7(Map.of(WHITE, 3), RED, 0),
	 RUBY_MINE_8(Map.of(WHITE, 4), RED, 1); 
	
	 private final Map<Color, Integer> tokenRequire;
	 private final Color tokenReduction;
	 private final int prestigePoints;
	 private final int level = 1;
	 
	 DevCardLevel1(Map<Color, Integer> tokenRequire, Color tokenReduction, int prestigePoints) {
	        this.tokenRequire = Objects.requireNonNull(tokenRequire);
	        this.tokenReduction = Objects.requireNonNull(tokenReduction);
	        this.prestigePoints = prestigePoints;
	 }

}
