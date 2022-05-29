import java.lang.Math;

public class Game {

    private static int level = 0; //Level starts with zero and with 1 enemy
    private static double enemyAmount = 1; // Enemy amount is 1
    private static int turn = 0; //Turns are counted beginning with a zero

    public static void main(String[] args) {
        //Setting up the characters
        Character healer = new Healer();
        healer.name = "Luna";
        Character tank = new Tank();
        tank.name = "Doomsday";
        Character fighter = new Fighter();
        fighter.name = "Fear";

        //Display screen for the player and a description of the games purpose
        System.out.println("Welcome to Cannon Fodder traveler! Another mysterious and yet dangerous adventure you are heading in! You have three characters:\n" +
                "The healer: " + healer.name + "\n" +
                "The tank: " + tank.name + "\n" +
                "The fighter: " + fighter.name);
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
