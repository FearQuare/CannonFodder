public class Swords extends Weapons{

    public Swords() {
        super.type = "Sword";
    }

    public Swords(String name, double weight, int value, double damage, int star) {
        super(name, weight, value, damage, star);
        super.type = "Sword";
    }

}
