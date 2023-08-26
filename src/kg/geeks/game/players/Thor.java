package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero{
    public Thor( int health, int damage,String name) {
        super( health, damage, SuperAbility.DEAFEN,name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boolean thorAttack = RPG_Game.random.nextBoolean();
        if (this.getHealth() > 0 && thorAttack) {
            boss.setDamage(0);
            thorAttack=false;
            System.out.println("Thor deafened");

        } else {
            boss.setDamage(50);
        }
    }
}
