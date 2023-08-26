package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Witcher extends Hero {
    public Witcher(int health, int damage,String name) {
        super(health, damage, SuperAbility.SACRIFICE,name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boolean witcherAttack = RPG_Game.random.nextBoolean();
        if(this.getHealth()>0 && witcherAttack==true){
            for (int i = 0; i < heroes.length; i++) {
                if(heroes[i].getHealth()<=0 ){
                    heroes[i].setHealth(this.getHealth()+heroes[i].getHealth());
                    this.setHealth(0);
                    break;
                }

            }
            System.out.println("Witcher saved hero");
        }
    }
    }

