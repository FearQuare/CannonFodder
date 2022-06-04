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

    public long stun(Character character, EnemySoldier enemy){
        return Math.round(character.damage()/enemy.getVitality());
    }
}
