public class Wands extends Weapons{

    public Wands() {
        super.type = "Wand";
    }

    public Wands(String name, double weight, int value, double damage, int star) {
        super(name, weight, value, damage, star);
        super.type = "Wand";
    }

}
