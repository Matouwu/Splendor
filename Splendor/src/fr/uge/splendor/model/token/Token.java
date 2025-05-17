package fr.uge.splendor.model.token;

import java.util.Objects;

public record Token(Color colorToken) {
	
    public Token {
        Objects.requireNonNull(colorToken);
    }
    
  
    
    
}
