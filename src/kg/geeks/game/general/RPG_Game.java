package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Rayasha");
        Warrior warrior = new Warrior(290, 10, "Hedgehog");
        Warrior warrior2 = new Warrior(280, 15, "Silver");
        Magic magic = new Magic(270, 20, "Riven");
        Medic doc = new Medic(260, 5, 15, "Hudson");
        Medic assistant = new Medic(300, 5, 5, "Kaworu");
        Berserk berserk = new Berserk(290, 15, "Lelouch");
        Witcher witcher = new Witcher(270,10,"Michail");
        Thor thor = new Thor(270,10,"Kendall");
        Golem golem = new Golem(330,5,"Tracker");
        Hero[] heroes = {warrior, warrior2, magic, doc, assistant, berserk,witcher,thor,golem };
        ShowStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void ShowStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + "---------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);

        }
        System.out.println("++++++++++++++++");
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("HEROES WON!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("BOSS WON!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefense();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDefense() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
            ShowStatistics(boss, heroes);
    }
}