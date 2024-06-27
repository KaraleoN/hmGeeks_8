import java.util.Random;

public class Boss {
    private String name;
    private int health;
    private int attack;
    private Random random;

    public Boss(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.random = new Random();
    }

    public void attackHero(Hero hero) {
        int damage = random.nextInt(attack) + 1;
        hero.takeDamage(damage);
    }

    public void blockRandomAbility(Hero[] heroes) {
        if (random.nextBoolean()) {
            Hero randomHero = heroes[random.nextInt(heroes.length)];
            if (!randomHero.isBlocked()) {
                System.out.println(name + " блокирует способность у " + randomHero.getName());
                randomHero.setBlocked(true);
            }
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }
}