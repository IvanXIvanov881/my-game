public class enemy {
    public static final String ENEMY_NAME = "ENEMY";
    public static final int ENEMY_HEALTH = 3;
    public static final int ENEMY_DMG = 1;

    protected String name;
    protected int HP;
    protected int damage;

    public void player() {
        this.name = ENEMY_NAME;
        this.HP = ENEMY_HEALTH;
        this.damage = ENEMY_DMG;
    }
}
