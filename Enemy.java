public class Enemy {

    private String name;
    private int level;
    private int health;
    private int damage;

    public Enemy(String name, int level, int health, int damage) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
