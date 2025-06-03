package fr.uge.splendor.model.items;

public interface Card {
	
	  Map<Color, Integer> tokenRequire();
	  Color tokenReduction();
	  int prestigePoints();
	  int level();

}
