import java.lang.Math;

public class Game {

    private static int level = 0;
    private static double enemyAmount = 1;
    private static int turn = 0;

    public static void main(String[] args) {

        //Setting up the characters
        Character healer = new Healer();
        healer.name = "Luna";
        healer.gender = "Female";
        Character tank = new Tank();
        healer.name = "Doomsday";
        healer.gender = "Male";
        Character fighter = new Fighter();
        healer.name = "Fear";
        healer.gender = "Non-binary";

        //Display screen for the player and a description of the games purpose
        System.out.println("Welcome to Cannon Fodder traveler! Another mysterious and yet dangerous adventure you are heading in! You have three characters:\n" +
                "The healer: " + healer.name + " | " + healer.gender + "\n" +
                "The tank: " + tank.name + " | " + tank.gender + "\n" +
                "The fighter: " + fighter.name + " | " + fighter.gender);
        System.out.println("Each of them are significantly powerful and precious characters and among your journey, you need to keep them alive and clear all the levels of dungeons.");
        System.out.println("In each level, the amount of the enemy you need to fought with will increase 2 times.");

    }

    public static void increaseLevel(){
        //a method to increase level, we implemented this metod for the readibility purposes.
        level ++;
        enemyAmount = Math.pow(2, level);
    }

    public static int turnCount(int turn){
        if(turn<2){
            turn ++;
        }else {
            turn = 0;
        }
        return turn;
    }

}
