public class Wands extends Weapons{

    public Wands() {
        super.type = "Wand";
        this.category = "Weapon";
    }

    public Wands(String name, double weight, int value, double damage) {
        super(name, weight, value, damage);
        super.type = "Wand";
        this.category = "Weapon";
    }

    public double heal(){
        //This method will heal characters.
        return 0;
    }

}
