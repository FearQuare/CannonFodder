import java.util.Scanner;

public class Character {

    protected String name;
    protected String gender;
    protected int strength;
    protected int vitality;
    protected int intelligence;
    protected Weapons weapon;

    private Scanner sc = new Scanner(System.in);

    public Character() {
        this.name = "Unknown";
        this.gender = "Unknown";
        this.intelligence = 0;
        this.strength = 0;
        this.vitality = 0;
        this.weapon = new Weapons();
    }

    public double calculateDamage(){
        double dmg = this.weapon.damage;
        if(this.weapon.type.equals("Wand")){
            return dmg * intelligence;
        }else if(this.weapon.type.equals("Sword")){
            return dmg * strength;
        }else{
            return dmg * vitality;
        }
    }

    public Character(String name, String gender, int vitality, int intelligence, int strength, Weapons weapon) {
        this.name = name;
        this.gender = gender;
        this.vitality = vitality;
        this.strength = strength;
        this.intelligence = intelligence;
        this.weapon = weapon;

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon() {
        System.out.println("Please pick a default weapon: \nFor wand press 1\nFor sword press 2\nFor shield press 3");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                this.weapon = new Wands();
                break;
            case 2:
                this.weapon = new Swords();
                break;
            case 3:
                this.weapon = new Shields();
                break;
            default:
                System.out.println("Please enter a valid integer to pick a weapon.");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
