import java.util.ArrayList;

public class Healer extends Character{
    public Healer(String name, int strength, int vitality, int intelligence, Weapons wieldedWeapon, Clothings wieldedClothing) {
        super(name, strength, vitality, intelligence, wieldedWeapon, wieldedClothing);
    }

    public Healer() {
    }

    public Healer(String name, int strength, int vitality, int intelligence, ArrayList<Items> inventory, Weapons weapon, Clothings clothing) {
        super(name, strength, vitality, intelligence, inventory, weapon, clothing);
    }
}
