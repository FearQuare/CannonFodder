import java.util.ArrayList;

public class Healer extends Character{
    public Healer() {
    }

    public Healer(String name, int strength, int vitality, int intelligence, ArrayList<Items> inventory, Weapons weapon, Clothings clothing) {
        super(name, strength, vitality, intelligence, inventory, weapon, clothing);
    }
}
