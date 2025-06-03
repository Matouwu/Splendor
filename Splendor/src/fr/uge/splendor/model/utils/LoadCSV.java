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
		
	    Map<Integer, List<DevCard>> CardByLevel = new HashMap<>();
	    
	   
	    for (int i = 1; i <= 3; i++) {
	    	
	        CardByLevel.put(i, new ArrayList<>());
	    }
	    
	    InputStream inputStream = DevCard.class.getResourceAsStream("utils/cards-dev.csv"); 
	    if (inputStream == null) {
	        throw new IOException("Fichier cards-dev.csv non trouvé dans les resources");
	    }
	    
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line = reader.readLine(); 
	        
	        while ((line = reader.readLine()) != null) {
	            line = line.trim();
	            if (line.isEmpty()) {
	                continue;
	            }
	            
	            DevCard card = parseCardFromCSVLine(line);
	            if (card != null) {
	                CardByLevel.get(card.level()).add(card);
	            }
	        }
	    }
	    
	    return CardByLevel;
	}

	private static DevCard parseCardFromCSVLine(String csvLine) {
	    try {
	        String[] parts = csvLine.split(",");
	        if (parts.length < 8) {
	            System.err.println("Ligne CSV invalide: " + csvLine);
	            return null;
	        }
	        
	        var level = Integer.parseInt(parts[0].trim());
	        Color tokenReduction = parseColor(parts[1].trim());
	        var prestigePoints = Integer.parseInt(parts[2].trim());

	        
	        // Coûts en gemmes
	        
	        Map<Color, Integer> costs = new HashMap<>();
	        costs.put(Color.WHITE, Integer.parseInt(parts[3].trim()));
	        costs.put(Color.BLUE, Integer.parseInt(parts[4].trim()));
	        costs.put(Color.GREEN, Integer.parseInt(parts[5].trim()));
	        costs.put(Color.RED, Integer.parseInt(parts[6].trim()));
	        costs.put(Color.BLACK, Integer.parseInt(parts[7].trim()));
	        
	        // Illustration
	        String illustration = parts.length > 4 ? parts[4].trim() : "";
	        
	        //Très moche comme code a modifier 
	        TokenDeck tokenRequire = (TokenDeck) costs.entrySet(); 
	        
	        return new DevCard(level, tokenReduction, prestigePoints, tokenRequire,  illustration);
	       
	    } catch (IllegalArgumentException e) {
	        System.err.println("Erreur de parsing pour la ligne: " + csvLine + " - " + e.getMessage());
	        return null;
	    }
	}

	private static Color parseColor(String colorStr) {
		
	    return switch (colorStr.toLowerCase()) {
	    
	        case "white" -> Color.WHITE;
	        case "blue" -> Color.BLUE;
	        case "green" -> Color.GREEN;
	        case "red" -> Color.RED;
	        case "black" -> Color.BLACK;
	        default -> throw new IllegalArgumentException("Couleur inconnue: " + colorStr);
	        
	    };
	}

}
