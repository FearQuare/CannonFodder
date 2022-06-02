public class Swords extends Weapons{

    public Swords() {
        super.type = "Sword";
        this.category = "Weapon";
    }

    public Swords(String name, double weight, int value, double damage) {
        super(name, weight, value, damage);
        super.type = "Sword";
        this.category = "Weapon";
    }

    public int keepAway(){
        //This make enemies away
        int x = 1;
        return x;
    }

    public void block(){
        //This can block an enemy but consumes your turns.
    }

}
