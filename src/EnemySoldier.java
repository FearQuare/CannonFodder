import java.util.Random;

public class EnemySoldier extends Character{
    private static Random rand = new Random();
    public EnemySoldier(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setStrength();
        setIntelligence();
        setVitality();
        super.vitality = getVitality();
        super.intelligence = getIntelligence();
        super.strength = getStrength();
    }

    public EnemySoldier() {
    }

    @Override
    public void setStrength() {
        super.strength = rand.nextInt(1,5);
    }

    @Override
    public void setVitality() {
        super.vitality = rand.nextInt(1,5);
    }

    @Override
    public void setIntelligence() {
        super.intelligence = rand.nextInt(1,5);
    }
}
