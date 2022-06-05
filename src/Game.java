import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Level{
    private static int level = 0; //Level starts with zero and with 1 enemy
    private static double enemyAmount = 1; // Enemy amount is 1
    private static int turn = 0; //Turns are counted beginning with a zero
    private ArrayList<EnemySoldier> enemies;
    private ArrayList<Items> levelItems;
    private static Random rand = new Random();

    public static void main(String[] args) {
        //Setting up the characters

        //Healer
        Weapons wand = new Weapons("Acaica", 1,2,3);
        Clothings armor = new LightArmor("Alchemy Mail", 1,2,1);
        Character healer = new Healer("Luna", wand, armor);

        //Tank
        Weapons shield = new Shields("Pikyu Pikyu", 2,1,3);
        Clothings armor1 = new HardArmor("Chestplate of Ending Wars",1,2,3);
        Character tank = new Tank("Doomsday", shield, armor1);

        //Fighter
        Weapons sword = new Swords("Diamond Pickaxe", 2,2, 3);
        Clothings armor2 = new MediumArmor("Whisper of Huntsman", 2,2,2);
        Character fighter = new Fighter("Fear", sword, armor2);

        //Display screen for the player and a description of the games purpose
        System.out.println("Welcome to Cannon Fodder traveler! Another mysterious and yet dangerous adventure you are heading in! You have three characters:");
        healer.printInfo(healer);
        tank.printInfo(tank);
        fighter.printInfo(fighter);
        System.out.println("Each of them are significantly powerful and precious characters and among your journey, you need to keep them alive and clear all the levels of dungeons.");
        System.out.println("In each level, the amount of the enemy you need to fought with will increase 2 times.");

    }
    public void setEnemy(){
        //Name initialization elements.
        ArrayList<String> names = new ArrayList<>();
        String name = "Enemy ";

        //Attributes of enemies
        Weapons sword = new Swords("sword", 1,1,3);
        Weapons wand = new Wands("Wand", 1,1,1);
        Weapons shield = new Shields("Shield", 1,1,2);
        Clothings lightArmor = new LightArmor("armor", 1,1,2);

        //Name initialization loop
        for(int i = 0; i < names.size(); i++){
            name = name + (i+1);
            names.add(name);
        }

        //Enemy initialization
        for(int i = 0; i < enemyAmount; i++){
            int a = rand.nextInt(1,10);
            if(a<8 && a>0){
                EnemySoldier enemy = new EnemySoldier(names.get(i), sword, lightArmor);
                enemies.add(enemy);
            }else if(a>8 && a<10){
                EnemySoldier enemy = new EnemySoldier(names.get(i), wand, lightArmor);
                enemies.add(enemy);
            }else{
                EnemySoldier enemy = new EnemySoldier(names.get(i), shield, lightArmor);
                enemies.add(enemy);
            }
        }
    }

    public Weapons dropWeapon(){
        Weapons[] drop = new Weapons[15];
        //Swords
        drop[0] = new Swords("Storm-Weaver",1,1,1);
        drop[1] = new Swords("Destiny's Song",2,2,3);
        drop[2] = new Swords("Gutrender",2,4,5);
        drop[3] = new Swords("Terror Deflector",3,1,2);
        drop[4] = new Swords("Hope's Swiftblade",1,5,4);
        //Shields
        drop[5] = new Shields("The Void", 1,1,1);
        drop[6] = new Shields("Malice",1,3,2);
        drop[7] = new Shields("Overture",2,5,5);
        drop[8] = new Shields("Whistling Barrier",2,1,1);
        drop[9] = new Shields("Storm-Forged Buffer",3,1,1);
        //Wands
        drop[10] = new Wands("Will of the Master",1,1,1);
        drop[11] = new Wands("Stormbringer",1,3,4);
        drop[12] = new Wands("Pansophy",1,2,2);
        drop[13] = new Wands("Blood Infused Branch",3,3,4);
        drop[14] = new Wands("Frozen Spire",1,2,1);

        int index  = rand.nextInt(0,9);
        return drop[index];
    }

    @Override
    public void attack() {

    }

    @Override
    public void specialAction() {

    }

    @Override
    public void pick() {

    }

    @Override
    public void wield() {

    }

    @Override
    public void wear() {

    }

    @Override
    public void examine() {

    }

    @Override
    public void listInventory() {

    }
}
