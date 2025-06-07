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

        InputStream inputStream = DevCard.class.getResourceAsStream("/fr/uge/splendor/model/utils/cards-dev.csv");
        if (inputStream == null) {
            throw new IOException("Fichier cards-dev.csv non trouvé dans les ressources");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            boolean isFirstLine = true;
            int currentLevel = 0;
            Color currentGemColor = null;
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                // Skip empty lines and header lines
                if (line.isEmpty() || isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                // Skip lines that start with "Level" or other headers
                if (line.startsWith("Level") || line.startsWith("Detailed")) {
                    continue;
                }
                
                String[] parts = line.split(",", -1); // -1 to keep empty strings
                if (parts.length < 10) continue;
                
                // Check if this line defines a new level and gem color
                if (!parts[0].isEmpty() && !parts[1].isEmpty()) {
                    try {
                        currentLevel = Integer.parseInt(parts[0].trim());
                        currentGemColor = parseColorOrNull(parts[1].trim());
                    } catch (NumberFormatException e) {
                        continue; // Skip invalid level lines
                    }
                }
                
                // Parse card data
                DevCard card = parseCardFromCSVLine(parts, currentLevel, currentGemColor);
                if (card != null && currentLevel >= 1 && currentLevel <= 3) {
                    cardByLevel.get(currentLevel).add(card);
                }
            }
        }

        return cardByLevel;
    }

    private static DevCard parseCardFromCSVLine(String[] parts, int level, Color gemColor) {
        try {
            // verif des niveaux possibles
            if (level < 1 || level > 3) return null;
            
            // parser le champs des points de prestiges
            int prestigePoints = parseIntOrDefault(parts[2], 0);
            
            // parser le champs illustration
            String illustration = (parts.length > 4 && !parts[4].isBlank()) ? 
                                parts[4].trim().replace("\"", "") : "default";
            
        
            if (parts.length < 10) return null;
            
            Map<Color, Integer> costs = new HashMap<>();
            costs.put(Color.WHITE, parseIntOrDefault(parts[5], 0));
            costs.put(Color.BLUE, parseIntOrDefault(parts[6], 0));
            costs.put(Color.GREEN, parseIntOrDefault(parts[7], 0));
            costs.put(Color.RED, parseIntOrDefault(parts[8], 0));
            costs.put(Color.BLACK, parseIntOrDefault(parts[9], 0));
            
            // renvoie null si le champs cout est vide dans le fichier
            if (costs.values().stream().allMatch(cost -> cost == 0)) {
                return null;
            }
            
            // ici je stocke la couleur de la gemme issue du csv
            Color tokenReduction = gemColor;
            
            TokenDeck tokenDeck = new TokenDeck(costs);
            return new DevCard(level, tokenReduction, prestigePoints, tokenDeck, illustration);
            
        } catch (Exception e) {
            // renvoie null en cas d'erreur (a modif a voir)
            return null;
        }
    }

    private static int parseIntOrDefault(String value, int defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static Color parseColorOrNull(String colorStr) {
        if (colorStr == null || colorStr.isBlank()) return null;
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