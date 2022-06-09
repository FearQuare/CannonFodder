import java.util.ArrayList;
import java.util.Random;

public class Fighter extends Character{
    private int stayAway = 0;
    private static Random rand = new Random();

    public Fighter(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setStrength();
        super.strength = getStrength();
        setIntelligence();
        super.intelligence = getIntelligence();
        setVitality();
        super.vitality = getVitality();
        setHP();
        super.HP = getHP();
    }

    public Fighter() {
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

    @Override
    public int getStayAway() {
        return stayAway;
    }

    @Override
    public void setStayAway(int stayAway) {
        this.stayAway = stayAway;
    }
}
