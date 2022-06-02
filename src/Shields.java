public class Shields extends Weapons{

    public Shields() {
        super.type = "Shield";
        this.category = "Weapon";
    }

    public Shields(String name, double weight, int value, double damage) {
        super(name, weight, value,damage);
        super.type = "Shield";
        this.category = "Weapon";
    }

    public int stun(){
        //This will stun the enemy for one turn.
        return 0;
    }
}
