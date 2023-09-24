public class player {

    public static final String PLAYER_NAME = "PLAYER";
    public static final int PLAYER_HEALTH = 5;
    public static final int PLAYER_DMG = 2;

    protected String name;
    protected int HP;
    protected int damage;

    public player(String name, int HP, int damage) {
        this.name = PLAYER_NAME;
        this.HP = PLAYER_HEALTH;
        this.damage = PLAYER_DMG;
    }
}
