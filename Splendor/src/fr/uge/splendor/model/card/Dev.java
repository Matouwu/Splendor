package fr.uge.splendor.model.card;

import fr.uge.splendor.model.token.Color;
import static fr.uge.splendor.model.token.Color.*;

import java.util.*;


public enum Dev {
    ONYX_MINE_1(Map.of(WHITE, 1, BLUE, 1, GREEN, 1, RED, 1), BLACK, 0, 1),
    ONYX_MINE_2(Map.of(WHITE, 1, BLUE, 2,GREEN, 1, RED, 1), BLACK, 0, 1),
    ONYX_MINE_3(Map.of(WHITE, 2, BLUE, 2, RED, 1),BLACK, 0, 1),
    ONYX_MINE_4(Map.of(GREEN, 1, RED, 3, BLACK, 1), BLACK, 0, 1),
    ONYX_MINE_5(Map.of(GREEN, 2, RED, 1), BLACK, 0, 1),
    ONYX_MINE_6(Map.of(WHITE, 2, GREEN, 2), BLACK, 0, 1),
    ONYX_MINE_7(Map.of(GREEN, 3), BLACK, 0, 1),
    ONYX_MINE_8(Map.of(BLUE, 4), BLACK, 1, 1),

    SAPHIRE_MINE_1(Map.of(WHITE, 1, GREEN, 1, RED, 1, BLACK, 1), BLUE, 0, 1),
    SAPHIRE_MINE_2(Map.of(WHITE, 1, GREEN, 1, RED, 2, BLACK, 1), BLUE, 0, 1),
    SAPHIRE_MINE_3(Map.of(WHITE, 1, GREEN, 2, RED, 2), BLUE, 0, 1),
    SAPHIRE_MINE_4(Map.of(BLUE, 1, GREEN, 3, RED, 1), BLUE, 0, 1),
    SAPHIRE_MINE_5(Map.of(WHITE, 1, BLACK, 2), BLUE, 0, 1),
    SAPHIRE_MINE_6(Map.of(GREEN, 2, BLACK, 2), BLUE, 0, 1),
    SAPHIRE_MINE_7(Map.of(BLACK, 3), BLUE, 0, 1),
    SAPHIRE_MINE_8(Map.of(RED, 4), BLUE, 1, 1),

    DIAMOND_MINE_1(Map.of(BLUE, 1, GREEN, 1, RED, 1, BLACK, 1), WHITE, 0, 1),
    DIAMOND_MINE_2(Map.of(BLUE, 1, GREEN, 2, RED, 1, BLACK, 1), WHITE, 0, 1),
    DIAMOND_MINE_3(Map.of(BLUE, 2, GREEN, 2, BLACK, 1), WHITE, 0, 1),
    DIAMOND_MINE_4(Map.of(WHITE, 3, BLUE, 1, BLACK, 1), WHITE, 0, 1),
    DIAMOND_MINE_5(Map.of(RED, 2, BLACK, 1), WHITE, 0, 1),
    DIAMOND_MINE_6(Map.of(BLUE, 2, BLACK, 2), WHITE, 0, 1),
    DIAMOND_MINE_7(Map.of(BLUE, 3), WHITE, 0, 1),
    DIAMOND_MINE_8(Map.of(GREEN, 4), WHITE, 1, 1),

    EMERALD_MINE_1(Map.of(WHITE, 1, BLUE, 1, RED, 1, BLACK, 1), GREEN, 0, 1),
    EMERALD_MINE_2(Map.of(WHITE, 1, BLUE, 1, RED, 1, BLACK, 2), GREEN, 0, 1),
    EMERALD_MINE_3(Map.of(BLUE, 1, RED, 2, BLACK, 2), GREEN, 0, 1),
    EMERALD_MINE_4(Map.of(WHITE, 1, BLUE, 3, GREEN, 1), GREEN, 0, 1),
    EMERALD_MINE_5(Map.of(WHITE, 2, BLUE, 1), GREEN, 0, 1),
    EMERALD_MINE_6(Map.of(BLUE, 2, RED, 2), GREEN, 0, 1),
    EMERALD_MINE_7(Map.of(RED, 3), GREEN, 0, 1),
    EMERALD_MINE_8(Map.of(BLACK, 4), GREEN, 1, 1),

    RUBY_MINE_1(Map.of(WHITE, 1, BLUE, 1, GREEN, 1, BLACK, 1), RED, 0, 1),
    RUBY_MINE_2(Map.of(WHITE, 2, BLUE, 1, GREEN, 1, BLACK, 1), RED, 0, 1),
    RUBY_MINE_3(Map.of(WHITE, 2, GREEN, 1, BLACK, 2), RED, 0, 1),
    RUBY_MINE_4(Map.of(WHITE, 1, RED, 1, BLACK, 3), RED, 0, 1),
    RUBY_MINE_5(Map.of(BLUE, 2, GREEN, 1), RED, 0, 1),
    RUBY_MINE_6(Map.of(WHITE, 2, RED, 2), RED, 0, 1),
    RUBY_MINE_7(Map.of(WHITE, 3), RED, 0, 1),
    RUBY_MINE_8(Map.of(WHITE, 4), RED, 1, 1),


    ONYX_CAMELS_1(Map.of(WHITE, 3, BLUE, 2, GREEN, 2), BLACK, 1, 2),
    ONYX_CAMELS_2(Map.of(WHITE, 3, GREEN, 3, BLACK, 2), BLACK, 1, 2),
    ONYX_CAMELS_3(Map.of(BLUE, 1, GREEN, 4, RED, 2), BLACK, 2, 2),
    ONYX_LAPIDARY_1(Map.of(GREEN, 5, RED, 3), BLACK, 2, 2),
    ONYX_LAPIDARY_2(Map.of(WHITE, 5), BLACK, 2, 2),
    ONYX_LAPIDARY_3(Map.of(BLACK, 6), BLACK, 3, 2),

    SAPPHIRE_ELEPHANTS_1(Map.of(BLUE, 2, GREEN, 2, RED, 3), BLUE, 1, 2),
    SAPPHIRE_ELEPHANTS_2(Map.of(BLUE, 2, GREEN, 3, BLACK, 3), BLUE, 1, 2),
    SAPPHIRE_ELEPHANTS_3(Map.of(WHITE, 5, BLUE, 3), BLUE, 2, 2),
    SAPPHIRE_LAPIDARY_1(Map.of(WHITE, 2, RED, 1, BLACK, 4), BLUE, 2, 2),
    SAPPHIRE_LAPIDARY_2(Map.of(BLUE, 5), BLUE, 2, 2),
    SAPPHIRE_LAPIDARY_3(Map.of(BLUE, 6), BLUE, 3, 2),

    DIAMOND_SNOW_1(Map.of(GREEN, 3, RED, 2, BLACK, 2), WHITE, 1, 2),
    DIAMOND_SNOW_2(Map.of(WHITE, 2, BLUE, 3, RED, 3), WHITE, 1, 2),
    DIAMOND_SNOW_3(Map.of(GREEN, 1, RED, 4, BLACK, 2), WHITE, 2, 2),
    DIAMOND_LAPIDARY_1(Map.of(RED, 5, BLACK, 3), WHITE, 2, 2),
    DIAMOND_LAPIDARY_2(Map.of(RED, 5), WHITE, 2, 2),
    DIAMOND_LAPIDARY_3(Map.of(WHITE, 6), WHITE, 3, 2),

    EMERALD_GUY_1(Map.of(WHITE, 3, GREEN, 2, RED, 3), GREEN, 1, 2),
    EMERALD_GUY_2(Map.of(WHITE, 2, BLUE, 3, BLACK, 2), GREEN, 1, 2),
    EMERALD_GUY_3(Map.of(WHITE, 4, BLUE, 2, BLACK, 1), GREEN, 2, 2),
    EMERALD_CARRACK_1(Map.of(BLUE, 5, GREEN, 3), GREEN, 2, 2),
    EMERALD_CARRACK_2(Map.of(GREEN, 5), GREEN, 2, 2),
    EMERALD_CARRACK_3(Map.of(GREEN, 6), GREEN, 3, 2),

    RUBY_FELUCCA_1(Map.of(WHITE, 2, RED, 2, BLACK, 3), RED, 1, 2),
    RUBY_FELUCCA_2(Map.of(BLUE, 3, RED, 2, BLACK, 3), RED, 1, 2),
    RUBY_FELUCCA_3(Map.of(WHITE, 1, BLUE, 4, GREEN, 2), RED, 2, 2),
    RUBY_LAPIDARY_1(Map.of(WHITE, 3, BLACK, 5), RED, 2, 2),
    RUBY_LAPIDARY_2(Map.of(BLACK, 5), RED, 2, 2),
    RUBY_LAPIDARY_3(Map.of(RED, 6), RED, 3, 2),


    ONYX_STREET_1(Map.of(WHITE, 3, BLUE, 3, GREEN, 5, RED, 3), BLACK, 3, 3),
    ONYX_STREET_2(Map.of(RED, 7), BLACK, 4, 3),
    ONYX_STREET_3(Map.of(GREEN, 3, RED, 6, BLACK, 3), BLACK, 4, 3),
    ONYX_STREET_4(Map.of(RED, 7, BLACK, 3), BLACK, 5, 3),

    SAPPHIRE_VENICE_1(Map.of(WHITE, 3, GREEN, 3, RED, 3, BLACK, 5), BLUE, 3, 3),
    SAPPHIRE_VENICE_2(Map.of(WHITE, 7), BLUE, 4, 3),
    SAPPHIRE_DIAMOND_SHOP_1(Map.of(WHITE, 6, BLUE, 3, BLACK, 3), BLUE, 4, 3),
    SAPPHIRE_DIAMOND_SHOP_2(Map.of(WHITE, 7, BLUE, 3), BLUE, 5, 3),

    DIAMOND_BUILDING_1(Map.of(BLUE, 3, GREEN, 3, RED, 5, BLACK, 3), WHITE, 3, 3),
    DIAMOND_GIOIELLERIA_1(Map.of(BLACK, 7), WHITE, 4, 3),
    DIAMOND_GIOIELLERIA_2(Map.of(WHITE, 3, RED, 3, BLACK, 6), WHITE, 4, 3),
    DIAMOND_BUILDING_2(Map.of(WHITE, 3, BLACK, 7), WHITE, 5, 3),

    EMERALD_TIMBERED_1(Map.of(WHITE, 5, BLUE, 3, RED, 3, BLACK, 3), GREEN, 3, 3),
    EMERALD_BRIDGE_1(Map.of(BLUE, 7), GREEN, 4, 3),
    EMERALD_BRIDGE_2(Map.of(WHITE, 3, BLUE, 6, GREEN, 3), GREEN, 4, 3),
    EMERALD_TIMBERED_2(Map.of(BLUE, 7, GREEN, 3), GREEN, 5, 3),

    RUBY_STATUE_1(Map.of(WHITE, 3, BLUE, 5, GREEN, 3, BLACK, 3), RED, 3, 3),
    RUBY_STATUE_2(Map.of(GREEN, 7), RED, 4, 3),
    RUBY_BUILDING_1(Map.of(BLUE, 3, GREEN, 6, RED, 3), RED, 4, 3),
    RUBY_BUILDING_2(Map.of(GREEN, 7, RED, 3), RED, 5, 3);
	
	 private final Map<Color, Integer> tokenRequire = new HashMap<>();
	 private final Color tokenReduction;
	 private final int prestigePoints;
	 private final int level;
	 
	 Dev(Map<Color, Integer> tokenRequire, Color tokenReduction, int prestigePoints, int level) {
         Objects.requireNonNull(tokenRequire);
         Objects.requireNonNull(tokenReduction);
         if(prestigePoints < 0 || level < 0) throw new IllegalArgumentException();

         this.tokenRequire.putAll(tokenRequire);
         this.tokenReduction = tokenReduction;
         this.prestigePoints = prestigePoints;
         this.level = level;
	 }

     public Map<Integer, List<DevCard>> listDevCards() {
         Map<Integer, List<DevCard>> devCardMap = new HashMap<>();
         for(Dev card : Dev.values()) {
             devCardMap.computeIfAbsent(card.level, k -> new ArrayList<>())
             .add(new DevCard(tokenRequire, tokenReduction, prestigePoints, level));
         }

         return devCardMap;
     }

}
