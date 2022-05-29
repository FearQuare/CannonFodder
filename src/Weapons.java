public class Weapons extends Items{
    protected double damage;
    protected String type;

    public Weapons() {
        this.damage = 0.0;
    }

    public Weapons(String name, double weight, int value, double damage) {
        super(name, weight, value);
        this.damage = damage;
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
