import java.util.Random;

public abstract class Hero {
    private String name;
    private int health;
    private int attack;
    private boolean blocked;

    public Hero(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.blocked = false;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " получает " + damage + " урона.");
        if (this.health <= 0) {
            System.out.println(this.name + " погибает!");
        }
    }

    public void attack(Boss boss) {
        System.out.println(this.name + " атакует " + boss.getName() + "!");
        boss.takeDamage(this.attack);
    }

    public abstract void useSpecialAbility(Boss boss, Hero[] heroes);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack() {
        this.attack = attack;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void increaseAttack(int bonus) {
        this.attack += bonus;
    }
}