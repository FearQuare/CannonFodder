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

    public long stayAway(Character character){
        return Math.round(character.getStrength()/5);
    }


}
