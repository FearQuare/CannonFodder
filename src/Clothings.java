public class Clothings extends Items{

    public Clothings() {
        super.category = "Clothing";
    }

    public Clothings(String name, double weight, int value) {
        super(name, weight, value);
        super.category = "Clothing";
    }


}
