package fr.uge.splendor.model.action;

import fr.uge.splendor.model.entity.Game;
import fr.uge.splendor.model.entity.Player;

public interface Action {
	
    Player player();
    Game game(); 
    boolean excecute();
    
}
