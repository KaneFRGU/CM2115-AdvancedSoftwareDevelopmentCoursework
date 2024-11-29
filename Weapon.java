public class Weapon {
    private String name;
    private int level;
    private int damage;

    public Weapon(String name, int level, int damage) {
        this.name = name;
        this.level = level;
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
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    } 


}
