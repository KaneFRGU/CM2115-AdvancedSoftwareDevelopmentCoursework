import java.util.HashMap;

public class Player {
    private String name;
    public int health;
    private Weapon weapon;
    int score;

    
    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public static void setHealth(int health) {
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
