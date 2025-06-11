package fr.uge.splendor.model.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.deck.TokenDeck;

public class LoadCSV {

    public static Map<Integer, List<DevCard>> loadCardFromCSV() throws IOException {
        Map<Integer, List<DevCard>> cardByLevel = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            cardByLevel.put(i, new ArrayList<>());
        }

        InputStream inputStream = LoadCSV.class.getResourceAsStream("/fr/uge/splendor/model/utils/cards-dev.csv");
        if (inputStream == null) {
            throw new IOException("Fichier cards-dev.csv non trouvé dans les ressources");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        int currentLevel = 0;
        Color currentGemColor = null;
        boolean skipFirstLine = true;
        
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            
            if (skipFirstLine) {
                skipFirstLine = false;
            } else if (!line.isEmpty() && !line.startsWith("Level") && !line.startsWith("Detailed")) {
                String[] parts = line.split(",", -1);
                
                if (parts.length >= 10) {
                    if (!parts[0].isEmpty() && !parts[1].isEmpty()) {
                        currentLevel = parseIntOrDefault(parts[0], currentLevel);
                        currentGemColor = parseColorOrNull(parts[1]);
                    }
                    
                    DevCard card = parseCardFromCSVLine(parts, currentLevel, currentGemColor);
                    if (card != null && isValidLevel(currentLevel)) {
                        cardByLevel.get(currentLevel).add(card);
                    }
                }
            }
        }
        
        reader.close();
        inputStream.close();
        
        return cardByLevel;
    }

    private static DevCard parseCardFromCSVLine(String[] parts, int level, Color gemColor) {
        if (!isValidLevel(level) || parts.length < 10) {
            return null;
        }
        
        int prestigePoints = parseIntOrDefault(parts[2], 0);
        String illustration = parts.length > 4 && !parts[4].isBlank() ? 
                            parts[4].trim().replace("\"", "") : "default";
        
        Map<Color, Integer> costs = new HashMap<>();
        costs.put(Color.WHITE, parseIntOrDefault(parts[5], 0));
        costs.put(Color.BLUE, parseIntOrDefault(parts[6], 0));
        costs.put(Color.GREEN, parseIntOrDefault(parts[7], 0));
        costs.put(Color.RED, parseIntOrDefault(parts[8], 0));
        costs.put(Color.BLACK, parseIntOrDefault(parts[9], 0));
        
        if (costs.values().stream().allMatch(cost -> cost == 0)) {
            return null;
        }
        
        TokenDeck tokenDeck = new TokenDeck(costs);
        return new DevCard(level, gemColor, prestigePoints, tokenDeck, illustration, false);
    }

    private static boolean isValidLevel(int level) {
        return level >= 1 && level <= 3;
    }

    private static int parseIntOrDefault(String value, int defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return Integer.parseInt(value.trim());
    }

    private static Color parseColorOrNull(String colorStr) {
        if (colorStr == null || colorStr.isBlank()) {
            return null;
        }
        return switch (colorStr.toLowerCase().trim()) {
            case "white" -> Color.WHITE;
            case "blue" -> Color.BLUE;
            case "green" -> Color.GREEN;
            case "red" -> Color.RED;
            case "black" -> Color.BLACK;
            default -> null;
        };
    }
}