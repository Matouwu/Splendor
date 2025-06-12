/*
package fr.uge.splendor.view.components;

import com.github.forax.zen.Application;
import com.github.forax.zen.ApplicationContext;
import java.util.Map;
import java.util.Objects;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;

public class TokenRenderer {

    public void drawToken(Graphics2D graphics, int x, int y, int radius,
                          Color tokenColor, int count) {
        // Token circulaire
        graphics.setColor(tokenColor);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        // Bordure
        graphics.setColor(Color.BLACK);
        graphics.drawOval(x - radius, y - radius, radius * 2, radius * 2);

        // Nombre de tokens
        graphics.setFont(new Font("Arial", Font.BOLD, 14));
        String countStr = String.valueOf(count);
        int textWidth = graphics.getFontMetrics().stringWidth(countStr);
        graphics.setColor(count > 0 ? Color.WHITE : Color.GRAY);
        graphics.drawString(countStr, x - textWidth/2, y + 5);
    }
}*/
