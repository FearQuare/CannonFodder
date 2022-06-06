import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class Game{
    private static Random rand = new Random();

    public static void main(String[] args) {
        int enemyAmount = 1; //Initialized enemy amount
        int level = 0; //Initialized level
        int turn = 0; //Turn count from the start

        //ArrayLists we'll use later
        ArrayList<EnemySoldier> enemies = new ArrayList<>();
        ArrayList<Items> levelItems = new ArrayList<>();
        ArrayList<Character> myCharacters = new ArrayList<>();

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

        //Arraylist of our characters:
        myCharacters.add(healer);
        myCharacters.add(tank);
        myCharacters.add(fighter);

        //Display screen for the player and a description of the games purpose
        System.out.println("Welcome to Cannon Fodder traveler! Another mysterious and yet dangerous adventure you are heading in! You have three characters:");
        healer.printInfo(healer);
        tank.printInfo(tank);
        fighter.printInfo(fighter);
        System.out.println("Each of them are significantly powerful and precious characters and among your journey, you need to keep them alive and clear all the levels of dungeons.");
        System.out.println("In each level, the amount of the enemy you need to fought with will increase 2 times.");
        System.out.println("***************************");
        System.out.println("The game starts now...");

        boolean gameFlag = true;
        while(gameFlag){
            if(!myCharacters.isEmpty()){
                System.out.println("You are at level " + level + ".");
                System.out.println("There are " + enemyAmount + " enemies.");
                setEnemy(enemyAmount, enemies);
                if(enemies.size() > 0){

                }
            }else{
                System.out.println("Wasted. Try your best next time.");
                gameFlag = false;
            }

            level ++;
            enemyAmount = (int) Math.pow(2,level);
        }

    }
    public static void setEnemy(int enemyAmount, ArrayList<EnemySoldier> enemies){
        //Attributes of enemies
        Weapons sword = new Swords("sword", 1,1,3);
        Weapons wand = new Wands("Wand", 1,1,1);
        Weapons shield = new Shields("Shield", 1,1,2);
        Clothings lightArmor = new LightArmor("armor", 1,1,2);

        //Enemy initialization
        for(int i = 0; i < enemyAmount; i++){
            String name = "Enemy ";
            name = name + (i+1);
            int a = rand.nextInt(1,10);
            if(a<=8 && a>0){
                EnemySoldier enemy = new EnemySoldier(name, sword, lightArmor);
                enemies.add(enemy);
            }else if(a==9){
                EnemySoldier enemy = new EnemySoldier(name, wand, lightArmor);
                enemies.add(enemy);
            }else{
                EnemySoldier enemy = new EnemySoldier(name, shield, lightArmor);
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
    public int turnCountEnemy(ArrayList<EnemySoldier> enemies){
        int turn = 0;
        if(turn<enemies.size()){
            turn++;
            return turn;
        }else{
            turn = 0;
            return turn;
        }
    }
}
