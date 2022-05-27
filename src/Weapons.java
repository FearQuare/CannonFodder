public class Weapons extends Items{
    protected double damage;
    protected String type;
    protected int star;

    public Weapons() {
        this.damage = 0.0;
        this.star = 0;
    }

    public Weapons(String name, double weight, int value, double damage, int star) {
        super(name, weight, value);
        this.damage = damage;
        this.star = star;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
