import java.util.ArrayList;
import java.util.Random;

public class EnemySoldier extends Character{

    boolean block = false;
    private int stunCount;
    private static Random rand = new Random();
    public EnemySoldier(String name, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, wieldedWeapon, wieldedClothing);
        setStrength();
        setIntelligence();
        setVitality();
        super.vitality = getVitality();
        super.intelligence = getIntelligence();
        super.strength = getStrength();
        setHP();
        super.HP = getHP();
    }

    public EnemySoldier() {
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

    public int getStunCount() {
        return stunCount;
    }

    public void setStunCount(int stunCount) {
        this.stunCount = stunCount;
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

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
