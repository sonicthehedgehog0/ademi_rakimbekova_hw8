package kg.geeks.game.players;

public class Berserk extends Hero{
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        System.out.println("BERSERK " + this.getName() + " blocked and reverted "
        + blockedDamage);
        boss.setHealth(boss.getHealth() - blockedDamage);
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
