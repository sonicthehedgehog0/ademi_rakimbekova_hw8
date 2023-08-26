package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defense;

    public SuperAbility getDefense() {
        return defense;
    }

    public Boss(int health, int damage, String name) {
        super(health, damage, name);

    }

    public void chooseDefense() {
        SuperAbility[] values = SuperAbility.values();
        int index = RPG_Game.random.nextInt(values.length);
        this.defense = values[index];
    }

    public void attack(Hero[] heroes) {{
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0)
                if (heroes[i] instanceof Berserk && heroes[i].getAbility() != this.defense) {
                    int blocked;
                    if (RPG_Game.random.nextBoolean()) {
                        blocked = this.getDamage() / 2;
                    } else {
                        blocked = this.getDamage() / 5;
                    }
                    ((Berserk) heroes[i]).setBlockedDamage(blocked);
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage() - blocked);
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());

                }
            }
        }
    }


    @Override
    public String toString() {
        return "BOSS " + super.toString() + " DEFENSE " + this.defense + "\n";
    }
}

