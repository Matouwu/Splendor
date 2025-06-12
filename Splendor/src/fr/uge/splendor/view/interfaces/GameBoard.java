package fr.uge.splendor.view.interfaces;

import fr.uge.splendor.model.items.card.DevCard;
import fr.uge.splendor.model.items.deck.TokenDeck;
import fr.uge.splendor.model.utils.LoadCSV;
import com.github.forax.zen.Application;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class GameBoard {

    private static final int CARD_WIDTH = 140;
    private static final int CARD_HEIGHT = 180;
    private static final int CARD_SPACING = 20;
    private static final int ROW_SPACING = 200;
    private static final int MARGIN = 50;

    private static final int WINDOW_WIDTH = 2560;
    private static final int WINDOW_HEIGHT = 1680;

    // Cache pour les images
    private static final Map<String, BufferedImage> imageCache = new HashMap<>();
    private static BufferedImage backgroundImage;
    private static Map<Color, BufferedImage> gemImages;

    // Données du jeu
    private Map<Integer, List<DevCard>> developmentCards;

    static {
        loadGameImages();
    }

    public GameBoard() {
        try {
            this.developmentCards = LoadCSV.loadCardFromCSV();
            System.out.println("Cartes chargées depuis CSV:");
            developmentCards.forEach((level, cards) ->
                    System.out.println("Niveau " + level + ": " + cards.size() + " cartes"));
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des cartes: " + e.getMessage());
            this.developmentCards = new HashMap<>();
        }
    }


    private static void loadGameImages() {
        backgroundImage = loadImage("view/utils/images/cards/diamondbuilding1.jpg");


        gemImages = new HashMap<>();
        gemImages.put(Color.WHITE, loadImage("gem_white.png"));
        gemImages.put(Color.BLUE, loadImage("gem_blue.png"));
        gemImages.put(Color.GREEN, loadImage("gem_green.png"));
        gemImages.put(Color.RED, loadImage("gem_red.png"));
        gemImages.put(Color.BLACK, loadImage("gem_black.png"));
    }

    private static BufferedImage loadImage(String imageName) {
        if (imageCache.containsKey(imageName)) {
            return imageCache.get(imageName);
        }

        try (InputStream input = GameBoard.class.getResourceAsStream("/fr/uge/splendor/view/utils/" + imageName)) {
            if (input != null) {
                BufferedImage image = ImageIO.read(input);
                imageCache.put(imageName, image);
                System.out.println("Image chargée: " + imageName);
                return image;
            } else {
                System.err.println("Image non trouvée: " + imageName);
                return null;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de " + imageName + ": " + e.getMessage());
            return null;
        }
    }

    public void displayBoard() {
        Application.run(Color.DARK_GRAY, context -> {
            context.renderFrame(graphics -> {
                drawGameBoard(graphics);
            });
        });
    }

    private void drawGameBoard(Graphics2D graphics) {

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        drawBackground(graphics);

        drawTitle(graphics);

        drawDevelopmentCards(graphics);

        drawGameInfo(graphics);
    }


    private void drawBackground(Graphics2D graphics) {
        if (backgroundImage != null) {
            graphics.drawImage(backgroundImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
            graphics.setColor(new Color(0, 0, 0, 100));
            graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        } else {
            GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(45, 45, 45),
                    0, WINDOW_HEIGHT, new Color(25, 25, 25)
            );
            graphics.setPaint(gradient);
            graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        }
    }


    private void drawTitle(Graphics2D graphics) {
        graphics.setFont(new Font("Arial", Font.BOLD, 36));
        FontMetrics fm = graphics.getFontMetrics();
        String title = "SPLENDOR - PLATEAU DE JEU";
        int titleWidth = fm.stringWidth(title);
        int titleX = (WINDOW_WIDTH - titleWidth) / 2;

        graphics.setColor(Color.BLACK);
        graphics.drawString(title, titleX + 2, 42);

        graphics.setColor(Color.WHITE);
        graphics.drawString(title, titleX, 40);
    }


    private void drawDevelopmentCards(Graphics2D graphics) {
        int startY = 80;

        for (int level = 3; level >= 1; level--) {
            List<DevCard> cards = developmentCards.get(level);
            if (cards != null && !cards.isEmpty()) {
                drawCardLevel(graphics, cards, level, startY);
            }
            startY += ROW_SPACING;
        }
    }

    private void drawCardLevel(Graphics2D graphics, List<DevCard> cards, int level, int y) {
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.setColor(Color.BLACK);
        graphics.drawString("Niveau " + level + " :", MARGIN + 1, y - 9);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Niveau " + level + " :", MARGIN, y - 10);

        int visibleCards = Math.min(4, cards.size());
        int totalWidth = visibleCards * CARD_WIDTH + (visibleCards - 1) * CARD_SPACING;
        int startX = (WINDOW_WIDTH - totalWidth) / 2;

        for (int i = 0; i < visibleCards; i++) {
            DevCard card = cards.get(i);
            int cardX = startX + i * (CARD_WIDTH + CARD_SPACING);
            drawDevelopmentCard(graphics, card, cardX, y);
        }

        if (cards.size() > 4) {
            graphics.setFont(new Font("Arial", Font.ITALIC, 14));
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.drawString("+" + (cards.size() - 4) + " autres cartes",
                    startX + visibleCards * (CARD_WIDTH + CARD_SPACING), y + CARD_HEIGHT/2);
        }
    }


    private void drawDevelopmentCard(Graphics2D graphics, DevCard card, int x, int y) {
        RoundRectangle2D cardShape = new RoundRectangle2D.Double(x, y, CARD_WIDTH, CARD_HEIGHT, 15, 15);

        Color cardColor = getGemColor(card.tokenReduction());
        graphics.setColor(cardColor);
        graphics.fill(cardShape);


        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(3));
        graphics.draw(cardShape);

        if (card.prestigePoint() > 0) {
            drawPrestigePoints(graphics, card.prestigePoint(), x, y);
        }

        drawGemBonus(graphics, card.tokenReduction(), x, y);

        drawCardCost(graphics, card.tokenRequire(), x, y);

        drawCardLevel(graphics, card.level(), x, y);
    }


    private void drawPrestigePoints(Graphics2D graphics, int prestige, int x, int y) {
        graphics.setColor(new Color(255, 215, 0, 200));
        graphics.fillOval(x + CARD_WIDTH - 35, y + 5, 30, 30);

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2));
        graphics.drawOval(x + CARD_WIDTH - 35, y + 5, 30, 30);

        graphics.setFont(new Font("Arial", Font.BOLD, 16));
        graphics.setColor(Color.BLACK);
        String prestigeText = String.valueOf(prestige);
        FontMetrics fm = graphics.getFontMetrics();
        int textWidth = fm.stringWidth(prestigeText);
        graphics.drawString(prestigeText, x + CARD_WIDTH - 20 - textWidth/2, y + 24);
    }

    public void drawToken(Graphics2D graphics, int x, int y, int radius,
                          Color tokenColor, int count) {
        graphics.setColor(tokenColor);
        graphics.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        graphics.setColor(Color.BLACK);
        graphics.drawOval(x - radius, y - radius, radius * 2, radius * 2);

        graphics.setFont(new Font("Arial", Font.BOLD, 14));
        String countStr = String.valueOf(count);
        int textWidth = graphics.getFontMetrics().stringWidth(countStr);
        graphics.setColor(count > 0 ? Color.WHITE : Color.GRAY);
        graphics.drawString(countStr, x - textWidth/2, y + 5);
    }


    private void drawCardLevel(Graphics2D graphics, int level, int x, int y) {
        graphics.setColor(new Color(0, 0, 0, 150));
        graphics.fillRoundRect(x + 5, y + 5, 25, 20, 5, 5);

        graphics.setFont(new Font("Arial", Font.BOLD, 12));
        graphics.setColor(Color.WHITE);
        graphics.drawString("L" + level, x + 8, y + 18);
    }


    private void drawGemBonus(Graphics2D graphics, fr.uge.splendor.model.items.Color color, int x, int y) {
        BufferedImage gemImage = gemImages.get(color);

        if (gemImage != null) {
            int gemSize = 50;
            int gemX = x + (CARD_WIDTH - gemSize) / 2;
            int gemY = y + (CARD_HEIGHT - gemSize) / 2;
            graphics.drawImage(gemImage, gemX, gemY, gemSize, gemSize, null);
        } else {
            graphics.setFont(new Font("Arial", Font.BOLD, 40));
            graphics.setColor(Color.WHITE);
            String symbol = getGemSymbol(color);
            FontMetrics fm = graphics.getFontMetrics();
            int symbolWidth = fm.stringWidth(symbol);
            int symbolX = x + (CARD_WIDTH - symbolWidth) / 2;
            int symbolY = y + CARD_HEIGHT / 2 + 10;

            graphics.setColor(Color.BLACK);
            graphics.drawString(symbol, symbolX + 1, symbolY + 1);
            graphics.setColor(Color.WHITE);
            graphics.drawString(symbol, symbolX, symbolY);
        }
    }

    private void drawCardCost(Graphics2D graphics, TokenDeck tokenRequire, int x, int y) {
        graphics.setColor(new Color(0, 0, 0, 180));
        graphics.fillRoundRect(x + 5, y + CARD_HEIGHT - 45, CARD_WIDTH - 10, 40, 8, 8);

        graphics.setFont(new Font("Arial", Font.BOLD, 11));
        Map<fr.uge.splendor.model.items.Color, Integer> costs = tokenRequire.getTokenDeck();

        int currentX = x + 8;
        int costY = y + CARD_HEIGHT - 20;

        for (Entry<fr.uge.splendor.model.items.Color, Integer> entry : costs.entrySet()) {
            if (entry.getValue() > 0) {
                fr.uge.splendor.model.items.Color tokenColor = entry.getKey();
                int amount = entry.getValue();

                graphics.setColor(getGemColor(tokenColor));
                String costText = amount + getGemSymbol(tokenColor);
                graphics.drawString(costText, currentX, costY);

                FontMetrics fm = graphics.getFontMetrics();
                currentX += fm.stringWidth(costText) + 8;

                if (currentX > x + CARD_WIDTH - 20) {
                    currentX = x + 8;
                    costY += 15;
                }
            }
        }
    }

    private void drawGameInfo(Graphics2D graphics) {
        graphics.setFont(new Font("Arial", Font.PLAIN, 14));
        graphics.setColor(Color.LIGHT_GRAY);

        int infoY = WINDOW_HEIGHT - 30;
        int totalCards = developmentCards.values().stream()
                .mapToInt(List::size)
                .sum();

        String info = "Total des cartes chargées: " + totalCards;
        graphics.drawString(info, MARGIN, infoY);

        String legend = "W=Blanc, B=Bleu, G=Vert, R=Rouge, K=Noir";
        FontMetrics fm = graphics.getFontMetrics();
        int legendWidth = fm.stringWidth(legend);
        graphics.drawString(legend, WINDOW_WIDTH - legendWidth - MARGIN, infoY);
    }


    private Color getGemColor(fr.uge.splendor.model.items.Color tokenColor) {
        return switch (tokenColor) {
            case WHITE -> new Color(240, 240, 240);
            case BLUE -> new Color(70, 130, 180);
            case GREEN -> new Color(34, 139, 34);
            case RED -> new Color(220, 20, 60);
            case BLACK -> new Color(60, 60, 60);
            default -> Color.GRAY;
        };
    }

    private String getGemSymbol(fr.uge.splendor.model.items.Color color) {
        return switch (color) {
            case WHITE -> "W";
            case BLUE -> "B";
            case GREEN -> "G";
            case RED -> "R";
            case BLACK -> "K";
            default -> "?";
        };
    }



    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        board.displayBoard();
    }
}