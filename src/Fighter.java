import java.util.ArrayList;
import java.util.Random;

public class Fighter extends Character{

    public static Random rand = new Random();

    public Fighter() {
    }

    public Fighter(String name, int strength, int vitality, int intelligence, ArrayList<Items> inventory, Weapons weapon, Clothings clothing) {
        super(name, strength, vitality, intelligence, inventory, weapon, clothing);
    }
}
