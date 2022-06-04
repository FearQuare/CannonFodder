public class Weapons extends Items{
    protected double damage;
    protected String type;

    public Weapons() {
        this.damage = 0.0;
        this.category = "Weapon";
    }

    public Weapons(String name, double weight, int value, double damage) {
        super(name, weight, value);
        this.damage = damage;
        this.category = "Weapon";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Damage: " + getDamage());
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
