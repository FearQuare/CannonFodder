import java.lang.Math;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Random rand = new Random();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int level = 0;
        int enemyAmount = 1;
        int turn = 0;
        ArrayList<EnemySoldier> enemies = new ArrayList<>();
        ArrayList<Items> levelItems = new ArrayList<>();
        ArrayList<Character> myCharacters = new ArrayList<>();

        //Setting up the characters

        //Healer
        Weapons wand = new Wands("Acaica", 1,2,3);
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

        //Game begins
        boolean gameFlag = true;
        while(gameFlag){
            if(myCharacters.size()>0){
                //Level introduction:
                System.out.println(" ");
                System.out.println("You are at level " + level);
                System.out.println("There are " + enemyAmount + " enemies and the attributes of them are: ");
                setEnemy(enemyAmount,enemies);
                for(int i = 0; i < enemies.size(); i++){
                    System.out.println("Name: " + enemies.get(i).getName() +"\nHP: " + enemies.get(i).getHP());
                }
                System.out.println(" ");
                //Actions of the characters
                while(enemies.size()>0){
                    int i = 0; //If a character attacks or wield/wears an item than turn count increases one and when the turn count reaches 3(2) while loop will terminate
                    while(i < 3){
                        if(enemies.size()>0){
                            //Inputting the desired character.
                            System.out.println("With which character you want to make a move? Please type their names: ");
                            String charName = sc.nextLine();
                            charName = charName.toLowerCase();
                            switch (charName){
                                case "luna":
                                    System.out.println("You are playing with Luna.");
                                    int index = 0;
                                    for(int j = 0; j < myCharacters.size(); j++){
                                        if(myCharacters.get(j).getName().equals("Luna")){
                                            index = j;
                                        }
                                    }
                                    //Action list.
                                    System.out.println("Which move you want to do?");
                                    System.out.println("To attack type attack.");
                                    System.out.println("To make a special action type special action.");
                                    System.out.println("To check if there are any items on the ground type check."); //While checking, player will be asked if they want to examine it, take it or leave it.
                                    System.out.println("To check your inventory type inventory.");
                                    System.out.println("To wield a weapon in your inventory type wield.");//If there is nothing to wield print the situation.
                                    System.out.println("To wear an item in your inventory type wear.");//Same as the above comment
                                    System.out.println("Type your answer: ");
                                    //Choosing the action
                                    String choice = sc.nextLine();
                                    choice = choice.toLowerCase();
                                    switch(choice){
                                        case "attack":
                                            System.out.println("Which enemy you want to attack?");
                                            //Enemy list
                                            for(int b = 0; b < enemies.size(); b++){
                                                System.out.println("Name: " + enemies.get(b).getName() +"\nHP: " + enemies.get(b).getHP());
                                            }
                                            //Inputting
                                            System.out.println("Please type their name: ");
                                            String enemyChoice = sc.nextLine();
                                            enemyChoice = enemyChoice.toLowerCase();
                                            //Searching the index of the desired enemy.
                                            int index1 = 0;
                                            for(int a = 0; a < enemies.size(); a++){
                                                if(enemies.get(a).getName().toLowerCase().equals(enemyChoice)){
                                                    break;
                                                }
                                                index1++;
                                            }
                                            System.out.println("Luna is attacking to " + enemies.get(index1).getName());
                                            double damage = healer.damage();
                                            enemies.get(index1).updateHP(1, damage);
                                            System.out.println("Luna has attacked with " + damage +".");
                                            System.out.println(enemies.get(index1).getName() + " has " + enemies.get(index1).getHP() + " HP." );
                                            if(enemies.get(index1).getHP()<=0){
                                                System.out.println(enemies.get(index1).getName() + " is dead.");
                                                enemies.remove(index1);
                                            }
                                            if(enemies.size() > 0){
                                                System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                            }
                                            i++;
                                            break;
                                        case "special action":
                                            if(healer.getWieldedWeapon().getType().equals("Wand")){
                                                System.out.println("Which character you want to heal?");
                                                for(int c = 0; c < myCharacters.size(); c++){
                                                    System.out.println(myCharacters.get(c).getName() + " has " + myCharacters.get(c).getHP());
                                                }
                                                String input = sc.nextLine();
                                                input = input.toLowerCase();
                                                System.out.println(input);
                                                int index2 = 0;
                                                for(int d = 0; d < myCharacters.size(); d++){
                                                    if(myCharacters.get(d).getName().toLowerCase().equals(input)){
                                                        break;
                                                    }
                                                    index2++;
                                                }
                                                Wands wandOfHealer = (Wands) healer.getWieldedWeapon();
                                                double heal = wandOfHealer.heal(healer);
                                                System.out.println(heal);
                                                myCharacters.get(index2).updateHP(2, heal);
                                                System.out.println("Updated HP of " + myCharacters.get(index2).getName() + " is " + myCharacters.get(index2).getHP());
                                                i++;
                                            }else if(healer.getWieldedWeapon().getType().equals("Sword")){
                                                System.out.println("You can either stay away or block an enemy for one turn.");
                                            }else if(healer.getWieldedWeapon().getType().equals("Shield")){

                                            }else{
                                                System.out.println("Since Luna has no weapon, she has no special action too.");
                                            }
                                            break;
                                        case "check":
                                            break;
                                        case "inventory":
                                            break;
                                        case "wield":
                                            break;
                                        case "wear":
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case "doomsday":
                                    System.out.println("You are playing with Doomsday.");
                                    break;
                                case "fear":
                                    System.out.println("You are playing with Fear.");
                                    break;
                                default:
                                    System.out.println("Please try a valid input next time.");
                                    break;
                            }
                        }else{
                            System.out.println("You are going to level up.");
                            i = 3;
                        }
                        if(enemies.size()>0){
                            //Some actions for enemy forces but not rn.
                        }else{
                            System.out.println("You are going to level up. ");
                            i = 3;
                        }
                    }
                }
            }else{
                gameFlag = false;
            }
            level ++;
            enemyAmount = (int)Math.pow(2, level);
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
            String name = "Enemy " + (i+1);
            int a = rand.nextInt(1,10);
            if(a<8 && a>0){
                EnemySoldier enemy = new EnemySoldier(name, sword, lightArmor);
                enemies.add(enemy);
            }else if(a>8 && a<10){
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
}
