import java.util.Random;

public class Hacker extends Hero {
    private int stealAmount;

    public Hacker(String name, int health, int attack) {
        super(name, health, attack);
        this.stealAmount = 10; // Значение для примера, можно изменить
    }

    @Override
    public void useSpecialAbility(Boss boss, Hero[] heroes) {
        System.out.println(getName() + " ворует здоровье у " + boss.getName());
        int stolenHealth = boss.getHealth() > stealAmount ? stealAmount : boss.getHealth();
        boss.takeDamage(stolenHealth);
        setHealth(getHealth() + stolenHealth);
    }
}