package fr.uge.splendor.application;

import fr.uge.splendor.model.items.Color;
import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.deck.DevDeck;
import fr.uge.splendor.model.items.deck.TokenDeck;
import fr.uge.splendor.model.utils.LoadCSV;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
    	try {
            // Créer le deck de développement
            DevDeck devDeck = new DevDeck();
            
            // Charger toutes les cartes depuis le CSV
            devDeck.loadAllCards();
            
            // Affichage exemple ici on va enlever biensur
            System.out.println("Cartes chargées avec succès !");
            System.out.println("Nombre de cartes niveau 1: " + devDeck.getCardsByLevel(1).size());
            System.out.println("Nombre de cartes niveau 2: " + devDeck.getCardsByLevel(2).size());
            System.out.println("Nombre de cartes niveau 3: " + devDeck.getCardsByLevel(3).size());
            // Affichage exemple ici on va enlever biensur
            System.out.println("\nExemples de cartes niveau 1:");
            devDeck.getCardsByLevel(1).stream()
                    .limit(3)
                    .forEach(System.out::println);
                    
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des cartes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}