package kg.geeks.game.players;

public class Magic extends Hero{

    private int magicalIncrease=5;
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage()+magicalIncrease);
        }
        System.out.println("Heroes' damage magically increased : "+magicalIncrease);


    }
}
