public class Main {
    public static void main(String[] args) {
        Hero[] heroes = {
                new Witcher("Геральт", 100, 20),
                new Magic("Мерлин", 120, 18, 5),
                new Hacker("Эллиот", 90, 25)
        };

        Boss boss = new Boss("Злобный босс", 300, 30);

        System.out.println("--- Начало игры ---");

        int round = 1;
        while (boss.getHealth() > 0 && anyHeroAlive(heroes)) {
            System.out.println("--- Раунд " + round + " ---");

            // Атака героев
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && !hero.isBlocked()) {
                    hero.attack(boss);
                }
            }

            // Использование способностей героев
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && !hero.isBlocked()) {
                    hero.useSpecialAbility(boss, heroes);
                }
            }

            // Блокировка способности боссом
            boss.blockRandomAbility(heroes);

            // Атака босса после использования способностей
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && !hero.isBlocked()) {
                    boss.attackHero(hero);
                }
            }

            printStatus(boss);
            printStatus(heroes);
            round++;
        }

        // Определение победителя
        if (boss.getHealth() <= 0) {
            System.out.println("--- Конец игры ---");
            System.out.println("Победа героев! " + boss.getName() + " побежден!");
        } else {
            System.out.println("--- Конец игры ---");
            System.out.println("Победа " + boss.getName() + "! Все герои погибли.");
        }

        // Вывод состояния героев и босса
        System.out.println("--- Состояние героев и босса ---");
        printStatus(heroes);
        printStatus(boss);
    }

    private static boolean anyHeroAlive(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    private static void printStatus(Hero[] heroes) {
        for (Hero hero : heroes) {
            System.out.println(hero.getName() + " - Здоровье: " + hero.getHealth() +
                    ", Атака: " + hero.getAttack());
        }
    }
    private static void printStatus(Boss boss) {
        System.out.println(boss.getName() + " - Здоровье: " + boss.getHealth() +
                ", Атака: " + boss.getAttack());
    }
}