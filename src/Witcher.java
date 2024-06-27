import java.util.Random;

public class Witcher extends Hero {
    private boolean revived;

    public Witcher(String name, int health, int attack) {
        super(name, health, attack);
        this.revived = false;
    }

    @Override
    public void useSpecialAbility(Boss boss, Hero[] heroes) {
        if (!revived) {
            Random random = new Random();
            if (random.nextInt(2) == 0) {
                Hero firstDeadHero = findFirstDeadHero(heroes);
                if (firstDeadHero != null) {
                    System.out.println(getName() + " оживляет " + firstDeadHero.getName() +
                            ", пожертвовав своей жизнью.");
                    firstDeadHero.setHealth(1); // оживляем с 1 здоровьем
                    takeDamage(getHealth()); // погибаем, отдавая свою жизнь
                    revived = true;
                }
            }
        }
    }

    private Hero findFirstDeadHero(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.isDead()) {
                return hero;
            }
        }
        return null;
    }
}