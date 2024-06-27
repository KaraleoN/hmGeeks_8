import java.util.Random;

public class Magic extends Hero {
    private int bonusAttack;

    public Magic(String name, int health, int attack, int bonusAttack) {
        super(name, health, attack);
        this.bonusAttack = bonusAttack;
    }

    @Override
    public void useSpecialAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        if (random.nextBoolean()) {
            System.out.println(getName() + " увеличивает атаку каждого героя на " + bonusAttack + "!");
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    // Увеличиваем атаку каждого живого героя на bonusAttack
                    hero.increaseAttack(bonusAttack);
                }
            }
        }
    }
}