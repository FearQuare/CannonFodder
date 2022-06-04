import java.util.ArrayList;
import java.util.Random;

public class Fighter extends Character{
    private static Random rand = new Random();

    public Fighter(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setStrength();
        super.strength = getStrength();
        setIntelligence();
        super.intelligence = getIntelligence();
        setVitality();
        super.vitality = getVitality();
    }

    public Fighter() {
    }

    @Override
    public void setStrength() {
        super.strength = rand.nextInt(6,10);
    }

    @Override
    public void setVitality() {
        super.vitality = rand.nextInt(3,7);
    }

    @Override
    public void setIntelligence() {
        super.intelligence = rand.nextInt(1,5);
    }


}
