public class Shields extends Weapons{

    public Shields() {
        super.type = "Shield";
    }

    public Shields(String name, double weight, int value, double damage) {
        super(name, weight, value,damage);
        super.type = "Shield";
    }

    public void stun(){
        //This will stun the enemy for one turn.
    }

}
