public class Clothings extends Items{

    protected double protection;

    public Clothings() {
        super.category = "Clothing";
    }

    public Clothings(String name, double weight, int value, double protection) {
        super(name, weight, value);
        super.category = "Clothing";
        this.protection = protection;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Protection " + getProtection());
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }
}
