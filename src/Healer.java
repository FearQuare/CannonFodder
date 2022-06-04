import java.util.ArrayList;
import java.util.Random;

public class Healer extends Character{

    private static Random rand = new Random();
    public Healer(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setIntelligence();
        setStrength();
        setVitality();
        super.intelligence = getIntelligence();
        super.strength = getStrength();
        super.vitality = getVitality();
    }

    public Healer() {
    }

    @Override
    public void setStrength() {
        super.strength = rand.nextInt(3,7);
    }

    @Override
    public void setVitality() {
        super.vitality = rand.nextInt(1,5);
    }

    @Override
    public void setIntelligence() {
        super.intelligence = rand.nextInt(6,10);
    }
}
