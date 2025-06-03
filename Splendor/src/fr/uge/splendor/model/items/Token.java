package fr.uge.splendor.model.items;

import java.util.Objects;

public record Token(Color color, int number) {
	
	 public Token {
		 
	        Objects.requireNonNull(color);
	        if(number < 0) throw new IllegalArgumentException();
	    }

	    @Override
	    public String toString() {
	        return color.toString() + " :"+ number;
	    }
	    
}
