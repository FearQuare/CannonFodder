import java.util.ArrayList;
import java.util.Random;

public class Tank extends Character{
    private static Random rand = new Random();
    public Tank(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setStrength();
        setIntelligence();
        setVitality();
        super.intelligence = getIntelligence();
        super.vitality = getVitality();
        super.strength = getStrength();
    }

    public Tank() {
    }

    @Override
    public void setStrength() {
        super.strength = rand.nextInt(1,5);
    }

    @Override
    public void setVitality() {
        super.vitality = rand.nextInt(6,10);
    }

    @Override
    public void setIntelligence() {
        super.intelligence = rand.nextInt(3,7);
    }
}
