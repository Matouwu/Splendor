package fr.uge.splendor.phase1.application;

import fr.uge.splendor.phase1.controller.GameControllerP1;
import fr.uge.splendor.phase1.model.player.PlayerP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static fr.uge.splendor.phase1.controller.ControllerP1.startPlayer;

public class ApplicationP1 {
    public static void main(String[] args) {
        System.out.println("""
    Bienvenue sur la phase 1 de Splendor de Océane et Isabelle !
        Règle du jeu :
    Vous incarnez des marchands de pierres précieuses, cherchant à accumuler des points de prestige, il vous en faut 15
    pour terminer le jeu.
    Pour cela, vous avez 3 actions possibles :
        -   Prendre 3 pierres de couleurs différentes,
        -   Prendre 2 pierres de couleurs identiques,
        -   Acheter 1 carte de développement avec des pierres précieuses.
    Chaque carte rapportes 1 point de prestige pour un coût de 3 pierres précieuses.
    Un jeu simple à comprendre mais avec une profondeur stratégique qui garantit des heures de plaisir.
    Prêt à devenir le marchand le plus prestigieux de l'époque ?
    
    Pour cette première phase de jeu, j'aurais besoin de 2 joueurs :
    #============[ Joueur 1 ]============#
    #Rentrer un surnom :""");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("#Rentrer une âge :");
        int age = scan.nextInt();
        PlayerP1 p1 = new PlayerP1(name, age);
        System.out.println("#===>[" + p1.getName() + " " + p1.getAge() + "ans]\n");
        System.out.println("#============[ Joueur 2 ]============#\n Rentrer un surnom :");
        String name2 = scan.next();
        System.out.println("#Rentrer une âge :");
        int age2 = scan.nextInt();
        PlayerP1 p2 = new PlayerP1(name2, age2);
        System.out.println("#===>[" + p2.getName() + " " + p2.getAge() + "ans]");

        System.out.println("Démarrage de la partie entre [" + p1.getName() + "] vs [" + p2.getName() + "] !\nLe premier joueur à commencé est :" );

        List<PlayerP1> listPlayers = new ArrayList<>();
        listPlayers.add(p1);
        listPlayers.add(p2);
        var startPlayer = startPlayer(listPlayers);
        System.out.println(listPlayers.get(startPlayer).getName());

        GameControllerP1 game = new GameControllerP1(listPlayers, startPlayer);


        game.oneRound();



        scan.close();
    }
}
