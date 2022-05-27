public class Shields extends Weapons{

    public Shields() {
        super.type = "Shield";
    }

    public Shields(String name, double weight, int value, double damage, int star) {
        super(name, weight, value,damage,star);
        super.type = "Shield";
    }

}
