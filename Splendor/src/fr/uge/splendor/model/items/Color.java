package fr.uge.splendor.model.items;

public enum Color {
	GREEN, BLUE, RED, WHITE, BLACK, YELLOW;


	public static boolean isValidEnum(String input) {
		for (Color color : Color.values()) {
			if (input.equalsIgnoreCase("YELLOW")){
				return false;
			}
			if (color.name().equals(input.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
}
