package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;

public class TakeDiffCard {
    public static boolean excecute(Game game){
        System.out.println("Tu dois donc choisir 3 pierres précieuses entre : " + tokenPickaxe +
                "\nPour cela tu va rentrer les couleurs que tu veux (green, blue, red, white, black):");

        Map<ColorP1,Integer> tokenMap = new HashMap<>();
        Set<String> tmp = new HashSet<>();
        while(tokenMap.size() < 3) {
            var color = getInputColor(1);
            if(tmp.contains(color.name())){
                System.out.println("""
                    (Couleur invalide!)
                    ATTENTION A TOI, JE SAIS OU TU HABITE !
                    Tu dois rentrer une couleur different de ce que tu a déja rentré !""");
            } else {
                tokenPickaxe.put(color, tokenPickaxe.get(color)-1);
                tokenMap.put(color, 1);
                tmp.add(color.name());
            }
        }
        System.out.println("Tu a récupéré : " + tokenMap);
        System.out.println("Il ne reste plus que : " + tokenPickaxe);

        var player = players.get(currentPlayerIndex);
        player.addToken(tokenMap);
        System.out.println(player);
        nextPlayer();
        return true;
    }
}
