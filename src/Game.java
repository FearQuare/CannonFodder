import java.lang.Math;
import java.sql.Wrapper;
import java.util.ArrayList;

public class Game {

    private static int level = 0; //Level starts with zero and with 1 enemy
    private static double enemyAmount = 1; // Enemy amount is 1
    private static int turn = 0; //Turns are counted beginning with a zero
    private ArrayList<EnemySoldier> enemies;

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
    //Level increasing function
    public static void increaseLevel(){
        //a method to increase level, we implemented this metod for the readibility purposes.
        level ++;
        enemyAmount = Math.pow(2, level);
    }
    //Turn counter, because there are 3 characters there will be 3 turns.
    public static int turnCount(int turn){
        if(turn<2){
            turn ++;
        }else {
            turn = 0;
        }
        return turn;
    }

}
