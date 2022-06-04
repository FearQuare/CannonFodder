public class MediumArmor extends Clothings{
    public MediumArmor() {
        this.category = "Clothing";
    }

    public MediumArmor(String name, double weight, int value, double protection) {
        super(name, weight, value, protection);
        this.category = "Clothing";
    }
}
