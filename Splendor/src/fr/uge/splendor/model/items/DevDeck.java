package fr.uge.splendor.model.items;

public class DevDeck {
	
	private final Map<Color, Integer> tokenRequire = new HashMap<>();
    private final Color tokenReduction;
    private final int prestigePoints;
    private final int level;

    public DevCard(Map<Color, Integer> tokenRequire, Color tokenReduction, int prestigePoints, int level) {
        Objects.requireNonNull(tokenRequire);
        Objects.requireNonNull(tokenReduction);
        if(prestigePoints < 0 || level < 0) throw new IllegalArgumentException();

        this.tokenRequire.putAll(tokenRequire);
        this.tokenReduction = tokenReduction;
        this.prestigePoints = prestigePoints;
        this.level = level;
    }

    @Override
    public Map<Color, Integer> tokenRequire() {
        return tokenRequire;
    }

    @Override
    public Color tokenReduction() {
        return tokenReduction;
    }

    @Override
    public int prestigePoints() {
        return prestigePoints;
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public String toString() {
        return "DevCard : \ntokenRequire=" + tokenRequire + "\ntokenReduction=" + tokenReduction + "\nprestigePoints=" + prestigePoints + "\nlevel=" + level;
    }
}
