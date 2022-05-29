import java.util.ArrayList;

public class Tank extends Character{
    public Tank() {
    }

    public Tank(String name, int strength, int vitality, int intelligence, ArrayList<Items> inventory, Weapons weapon, Clothings clothing) {
        super(name, strength, vitality, intelligence, inventory, weapon, clothing);
    }
}
