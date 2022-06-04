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
        setHP();
        super.HP = getHP();
    }

    public Tank() {
        super.name = "Unknown";
        setStrength();
        super.strength = getStrength();
        setIntelligence();
        super.intelligence = getIntelligence();
        setVitality();
        super.vitality = getVitality();
        setHP();
        super.HP = getHP();
        super.wieldedWeapon = new Weapons();
        super.wieldedClothing = new Clothings();
        super.inventoryC = new ArrayList<>();
        super.inventoryW = new ArrayList<>();
        super.inventory = new ArrayList<>();
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
