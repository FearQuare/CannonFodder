public class Wands extends Weapons{

    public Wands() {
        super.type = "Wand";
    }

    public Wands(String name, double weight, int value, double damage) {
        super(name, weight, value, damage);
        super.type = "Wand";
    }

    public double heal(){
        //This method will heal characters.
        return 0;
    }


}
