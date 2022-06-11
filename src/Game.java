import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.lang.Math;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Random rand = new Random();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try{
            File myObj = new File("Swords.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObjj = new File("Shileds.txt");
            if (myObjj.createNewFile()) {
                System.out.println("File created: " + myObjj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObjjj = new File("Wands.txt");
            if (myObjjj.createNewFile()) {
                System.out.println("File created: " + myObjjj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("Swords.txt");
            myWriter.write("Storm-Weaver 1 1 1\n");
            myWriter.write("Destiny 2 2 3\n");
            myWriter.write("Gutrender 2 4 5\n");
            myWriter.write("Terror 3 1 2\n");
            myWriter.write("Hope 1 5 4\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriterr = new FileWriter("Shields.txt");
            myWriterr.write("The-Void 1 1 1\n");
            myWriterr.write("Malice 1 3 2\n");
            myWriterr.write("Overtrue 2 5 5\n");
            myWriterr.write("Whistling-Barrier 2 1 1\n");
            myWriterr.write("Storm-Forged-Buffer 3 1 1\n");
            myWriterr.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriterrr = new FileWriter("Wands.txt");
            myWriterrr.write("Will-of-the-Master 1 1 1\n");
            myWriterrr.write("Malicious 1 3 2\n");
            myWriterrr.write("Overlock 2 5 5\n");
            myWriterrr.write("Whistling-Fairies 2 1 1\n");
            myWriterrr.write("Forge-Star 3 1 1\n");
            myWriterrr.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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
                    for(int a = 0; a < enemies.size(); a++){
                        if(enemies.get(a).isBlock()){
                            enemies.get(a).setBlock(false);
                        }
                    }
                    for(int bei = 0; bei < myCharacters.size(); bei++){
                        if(myCharacters.get(bei).getStayAway()>0){
                            int fung = myCharacters.get(bei).getStayAway() - 1;
                            myCharacters.get(bei).setStayAway(fung);
                        }
                    }
                    while(i < 3){
                        if(enemies.size()>0 && myCharacters.size()>0){
                            //Inputting the desired character.
                            System.out.println("With which character you want to make a move? Please type their names: ");
                            String charName = sc.nextLine();
                            charName = charName.toLowerCase();
                            switch (charName){
                                case "luna":
                                    if (healer.getHP() <= 0) {
                                        System.out.println("Luna is dead :/");
                                    }else{
                                        if(healer.getStayAway()>0){
                                            System.out.println("Luna is not available for " + healer.getStayAway() + " turns.");
                                        }else{
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
                                            System.out.println("To wield a weapon in your inventory type wield and wear.");//If there is nothing to wield print the situation.
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
                                                        } else if (index1 == (enemies.size() - 1)) {
                                                            System.out.println("Erm... You've entered a wrong name ://");
                                                            System.out.println("You are going to hurt someone else.");
                                                            index1 = 0;
                                                        }else{
                                                            index1++;
                                                        }
                                                    }
                                                    System.out.println("Luna is attacking to " + enemies.get(index1).getName());
                                                    double damage = healer.damage();
                                                    enemies.get(index1).updateHP(1, damage);
                                                    System.out.println("Luna has attacked with " + damage +".");
                                                    System.out.println(enemies.get(index1).getName() + " has " + enemies.get(index1).getHP() + " HP." );
                                                    if(enemies.get(index1).getHP()<=0){
                                                        System.out.println(enemies.get(index1).getName() + " is dead.");
                                                        Weapons newWeapon = dropWeapon();
                                                        System.out.println(newWeapon.getName() + " has been dropped.");
                                                        levelItems.add(newWeapon);
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
                                                        System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                        i++;
                                                    }else if(healer.getWieldedWeapon().getType().equals("Sword")){
                                                        System.out.println("You can either stay away or block an enemy for one turn.");
                                                        System.out.println("To stay away press 1, to block press 2");
                                                        int piao = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (piao){
                                                            case 1:
                                                                Swords swordOfHealer = (Swords) healer.getWieldedWeapon();
                                                                int stayAway = (int) swordOfHealer.stayAway(healer);
                                                                healer.setStayAway(stayAway);
                                                                break;
                                                            case 2:
                                                                int enemyCount = enemies.size();
                                                                enemyCount = enemyCount - 1;
                                                                if(enemyCount == 0){
                                                                    enemies.get(0).setBlock(true);
                                                                }else {
                                                                    int randEnemy = rand.nextInt(0,enemyCount);
                                                                    enemies.get(randEnemy).setBlock(true);
                                                                    System.out.println(enemies.get(randEnemy).getName() + " has been blocked for one turn.");
                                                                }
                                                                System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                                i++;
                                                                break;
                                                            default:
                                                                System.out.println("Please enter a valid integer.");
                                                                break;
                                                        }

                                                    }else if(healer.getWieldedWeapon().getType().equals("Shield")){
                                                        System.out.println("The special action of the shield is only activated if and only if when an enemy attacks.");
                                                    }else{
                                                        System.out.println("Since Luna has no weapon, she has no special action too.");
                                                    }
                                                    break;
                                                case "check":
                                                    if(levelItems.isEmpty()){
                                                        System.out.println("Instantly there are no items on the ground in this level.");
                                                    }else{
                                                        System.out.println("There are: ");
                                                        for(int k = 0; k<levelItems.size(); k++){
                                                            System.out.println("Item " + (k+1) + ":");
                                                            levelItems.get(k).printInfo();
                                                            System.out.println(" ");
                                                        }
                                                        System.out.println("Would you like to pick up an item? If yes please enter their index number. Else enter a number other than the indexes.");
                                                        int itemIndex = sc.nextInt();
                                                        sc.nextLine();
                                                        itemIndex = itemIndex - 1;
                                                        if(levelItems.get(itemIndex) == null){
                                                            System.out.println("See you later.");
                                                        }else{
                                                            healer.addInventory(levelItems.get(itemIndex));
                                                            levelItems.remove(itemIndex);
                                                        }
                                                    }
                                                    break;
                                                case "inventory":
                                                    if(healer.getInventory().isEmpty()){
                                                        System.out.println("The inventory is empty.");
                                                    }else{
                                                        healer.printInventory();
                                                    }
                                                    break;
                                                case "wield and wear":
                                                    healer.switchWielded();
                                                    break;
                                                default:
                                                    System.out.println("Please enter a valid input next time.");
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                case "doomsday":
                                    if(tank.getHP() <= 0){
                                        System.out.println("Doomsday is dead :/");
                                    }else{
                                        if(tank.getStayAway()>0){
                                            System.out.println("Doomsday is not available for " + tank.getStayAway() + " turns.");
                                        }else{
                                            System.out.println("You are playing with Doomsday.");
                                            int indexd = 0;
                                            for(int j = 0; j < myCharacters.size(); j++){
                                                if(myCharacters.get(j).getName().equals("Luna")){
                                                    indexd = j;
                                                }
                                            }
                                            //Action list.
                                            System.out.println("Which move you want to do?");
                                            System.out.println("To attack type attack.");
                                            System.out.println("To make a special action type special action.");
                                            System.out.println("To check if there are any items on the ground type check."); //While checking, player will be asked if they want to examine it, take it or leave it.
                                            System.out.println("To check your inventory type inventory.");
                                            System.out.println("To wield a weapon in your inventory type wield and wear.");//If there is nothing to wield print the situation.
                                            System.out.println("Type your answer: ");
                                            //Choosing the action
                                            String choiced = sc.nextLine();
                                            choiced = choiced.toLowerCase();
                                            switch(choiced){
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
                                                        } else if (index1 == (enemies.size() - 1)) {
                                                            System.out.println("Erm... You've entered a wrong name ://");
                                                            System.out.println("You are going to hurt someone else.");
                                                            index1 = 0;
                                                        }else{
                                                            index1++;
                                                        }
                                                    }
                                                    System.out.println("Doomsday is attacking to " + enemies.get(index1).getName());
                                                    double damage = tank.damage();
                                                    enemies.get(index1).updateHP(1, damage);
                                                    System.out.println("Doomsday has attacked with " + damage +".");
                                                    System.out.println(enemies.get(index1).getName() + " has " + enemies.get(index1).getHP() + " HP." );
                                                    if(enemies.get(index1).getHP()<=0){
                                                        System.out.println(enemies.get(index1).getName() + " is dead.");
                                                        Weapons newWeapon = dropWeapon();
                                                        System.out.println(newWeapon.getName() + " has been dropped.");
                                                        levelItems.add(newWeapon);
                                                        enemies.remove(index1);
                                                    }
                                                    if(enemies.size() > 0){
                                                        System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                    }
                                                    i++;
                                                    break;
                                                case "special action":
                                                    if(tank.getWieldedWeapon().getType().equals("Wand")){
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
                                                        Wands wandOfTank = (Wands) tank.getWieldedWeapon();
                                                        double heal = wandOfTank.heal(tank);
                                                        System.out.println(heal);
                                                        myCharacters.get(index2).updateHP(2, heal);
                                                        System.out.println("Updated HP of " + myCharacters.get(index2).getName() + " is " + myCharacters.get(index2).getHP());
                                                        System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                        i++;
                                                    }else if(tank.getWieldedWeapon().getType().equals("Sword")){
                                                        System.out.println("You can either stay away or block an enemy for one turn.");
                                                        System.out.println("To stay away press 1, to block press 2");
                                                        int piao = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (piao){
                                                            case 1:
                                                                Swords swordOfTank = (Swords) tank.getWieldedWeapon();
                                                                int stayAway = (int) swordOfTank.stayAway(tank);
                                                                tank.setStayAway(stayAway);
                                                                System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                                i++;
                                                                break;
                                                            case 2:
                                                                int enemyCount = enemies.size();
                                                                enemyCount = enemyCount - 1;
                                                                if(enemyCount == 0){
                                                                    enemies.get(0).setBlock(true);
                                                                }else {
                                                                    int randEnemy = rand.nextInt(0,enemyCount);
                                                                    enemies.get(randEnemy).setBlock(true);
                                                                    System.out.println(enemies.get(randEnemy).getName() + " has been blocked for one turn.");
                                                                }
                                                                System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                                i++;
                                                                break;
                                                            default:
                                                                System.out.println("Please enter a valid integer.");
                                                                break;
                                                        }
                                                    }else if(tank.getWieldedWeapon().getType().equals("Shield")){
                                                        System.out.println("The special action of the shield is only activated if and only if when an enemy attacks.");
                                                    }else{
                                                        System.out.println("Since Doomsday has no weapon, she has no special action too.");
                                                    }
                                                    break;
                                                case "check":
                                                    if(levelItems.isEmpty()){
                                                        System.out.println("Instantly there are no items on the ground in this level.");
                                                    }else{
                                                        System.out.println("There are: ");
                                                        for(int k = 0; k<levelItems.size(); k++){
                                                            System.out.println("Item " + (k+1) + ":");
                                                            levelItems.get(k).printInfo();
                                                            System.out.println(" ");
                                                        }
                                                        System.out.println("Would you like to pick up an item? If yes please enter their index number. Else enter a number other than the indexes.");
                                                        int itemIndex = sc.nextInt();
                                                        sc.nextLine();
                                                        itemIndex = itemIndex - 1;
                                                        if(levelItems.get(itemIndex) == null){
                                                            System.out.println("See you later.");
                                                        }else{
                                                            tank.addInventory(levelItems.get(itemIndex));
                                                            levelItems.remove(itemIndex);
                                                        }
                                                    }
                                                    break;
                                                case "inventory":
                                                    if(tank.getInventory().isEmpty()){
                                                        System.out.println("The inventory is empty.");
                                                    }else{
                                                        tank.printInventory();
                                                    }
                                                    break;
                                                case "wield and wear":
                                                    tank.switchWielded();
                                                    break;
                                                default:
                                                    System.out.println("Please enter a valid input next time.");
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                case "fear":
                                    if(fighter.getHP() <= 0){
                                        System.out.println("Fear is dead :/");
                                    }else{
                                        if(fighter.getStayAway()>0){
                                            System.out.println("Fear is not available for " + fighter.getStayAway() + " turns.");
                                        }else{
                                            System.out.println("You are playing with Fear.");
                                            int indexf = 0;
                                            for(int j = 0; j < myCharacters.size(); j++){
                                                if(myCharacters.get(j).getName().equals("Luna")){
                                                    indexf = j;
                                                }
                                            }
                                            //Action list.
                                            System.out.println("Which move you want to do?");
                                            System.out.println("To attack type attack.");
                                            System.out.println("To make a special action type special action.");
                                            System.out.println("To check if there are any items on the ground type check."); //While checking, player will be asked if they want to examine it, take it or leave it.
                                            System.out.println("To check your inventory type inventory.");
                                            System.out.println("To wield a weapon in your inventory type wield and wear.");//If there is nothing to wield print the situation.
                                            System.out.println("Type your answer: ");
                                            //Choosing the action
                                            String choicef = sc.nextLine();
                                            choicef = choicef.toLowerCase();
                                            switch(choicef){
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
                                                        } else if (index1 == (enemies.size() - 1)) {
                                                            System.out.println("Erm... You've entered a wrong name ://");
                                                            System.out.println("You are going to hurt someone else.");
                                                            index1 = 0;
                                                        }else{
                                                            index1++;
                                                        }
                                                    }
                                                    System.out.println("Fear is attacking to " + enemies.get(index1).getName());
                                                    double damage = fighter.damage();
                                                    enemies.get(index1).updateHP(1, damage);
                                                    System.out.println("Fear has attacked with " + damage +".");
                                                    System.out.println(enemies.get(index1).getName() + " has " + enemies.get(index1).getHP() + " HP." );
                                                    if(enemies.get(index1).getHP()<=0){
                                                        System.out.println(enemies.get(index1).getName() + " is dead.");
                                                        Weapons newWeapon = dropWeapon();
                                                        System.out.println(newWeapon.getName() + " has been dropped.");
                                                        levelItems.add(newWeapon);
                                                        enemies.remove(index1);
                                                    }
                                                    if(enemies.size() > 0){
                                                        System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                    }
                                                    i++;
                                                    break;
                                                case "special action":
                                                    if(fighter.getWieldedWeapon().getType().equals("Wand")){
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
                                                        Wands wandOfFighter = (Wands) fighter.getWieldedWeapon();
                                                        double heal = wandOfFighter.heal(fighter);
                                                        System.out.println(heal);
                                                        myCharacters.get(index2).updateHP(2, heal);
                                                        System.out.println("Updated HP of " + myCharacters.get(index2).getName() + " is " + myCharacters.get(index2).getHP());
                                                        System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                        i++;
                                                    }else if(fighter.getWieldedWeapon().getType().equals("Sword")){
                                                        System.out.println("You can either stay away or block an enemy for one turn.");
                                                        System.out.println("To stay away press 1, to block press 2");
                                                        int piao = sc.nextInt();
                                                        sc.nextLine();
                                                        switch (piao){
                                                            case 1:
                                                                Swords swordOfFighter = (Swords) fighter.getWieldedWeapon();
                                                                int stayAway = (int) swordOfFighter.stayAway(fighter);
                                                                fighter.setStayAway(stayAway);
                                                                break;
                                                            case 2:
                                                                int enemyCount = enemies.size();
                                                                enemyCount = enemyCount - 1;
                                                                if(enemyCount == 0){
                                                                    enemies.get(0).setBlock(true);
                                                                }else {
                                                                    int randEnemy = rand.nextInt(0,enemyCount);
                                                                    enemies.get(randEnemy).setBlock(true);
                                                                    System.out.println(enemies.get(randEnemy).getName() + " has been blocked for one turn.");
                                                                }
                                                                System.out.println("You have used 1 turn for this action. Remaining turns: " + (3-(i+1)));
                                                                i++;
                                                                break;
                                                            default:
                                                                System.out.println("Please enter a valid integer.");
                                                                break;
                                                        }
                                                    }else if(fighter.getWieldedWeapon().getType().equals("Shield")){
                                                        System.out.println("The special action of the shield is only activated if and only if when an enemy attacks.");
                                                    }else{
                                                        System.out.println("Since Fear has no weapon, she has no special action too.");
                                                    }
                                                    break;
                                                case "check":
                                                    if(levelItems.isEmpty()){
                                                        System.out.println("Instantly there are no items on the ground in this level.");
                                                    }else{
                                                        System.out.println("There are: ");
                                                        for(int k = 0; k<levelItems.size(); k++){
                                                            System.out.println("Item " + (k+1) + ":");
                                                            levelItems.get(k).printInfo();
                                                            System.out.println(" ");
                                                        }
                                                        System.out.println("Would you like to pick up an item? If yes please enter their index number. Else enter a number other than the indexes.");
                                                        int itemIndex = sc.nextInt();
                                                        sc.nextLine();
                                                        itemIndex = itemIndex - 1;
                                                        if(levelItems.get(itemIndex) == null){
                                                            System.out.println("See you later.");
                                                        }else{
                                                            fighter.addInventory(levelItems.get(itemIndex));
                                                            levelItems.remove(itemIndex);
                                                        }
                                                    }
                                                    break;
                                                case "inventory":
                                                    if(fighter.getInventory().isEmpty()){
                                                        System.out.println("The inventory is empty.");
                                                    }else{
                                                        fighter.printInventory();
                                                    }
                                                    break;
                                                case "wield and wear":
                                                    fighter.switchWielded();
                                                    break;
                                                default:
                                                    System.out.println("Please enter a valid input next time.");
                                                    break;
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Please try a valid input next time.");
                                    break;
                            }
                        }else{
                            if(myCharacters.size() <= 0){
                                gameFlag = false;
                            }else{
                                System.out.println("You are going to level up.");
                                i = 3;
                            }
                        }
                    }
                    //Enemy turn
                    if(enemies.size()>0){
                        for(int xue = 0; xue < enemies.size(); xue++){ //Traversing enemies
                            int hua = myCharacters.size();
                            hua = hua -1; //Finding the bound of the characters
                            if(hua == 0){
                                if(!enemies.get(xue).isBlock()){
                                    if(myCharacters.get(0).getStayAway()==0){
                                        if(myCharacters.get(0).getWieldedWeapon().getType().equals("Shield")){
                                            boolean isBlock = rand.nextBoolean();
                                            if(!isBlock){
                                                System.out.println(enemies.get(xue).getName() + " is attacking to " + myCharacters.get(0).getName() + " with a damage " + enemies.get(xue).damage());
                                                double damage = enemies.get(xue).damage();
                                                myCharacters.get(0).updateHP(1,damage);
                                                System.out.println("Remaining HP of " + myCharacters.get(0).getHP());
                                            }else{
                                                System.out.println(enemies.get(xue).getName() + " has been blocked.");
                                            }
                                        }else{
                                            System.out.println(enemies.get(xue).getName() + " is attacking to " + myCharacters.get(0).getName() + " with a damage " + enemies.get(xue).damage());
                                            double damage = enemies.get(xue).damage();
                                            myCharacters.get(0).updateHP(1,damage);
                                            System.out.println("Remaining HP of " + myCharacters.get(0).getHP());
                                        }
                                    }
                                    if(myCharacters.get(0).getHP()<=0){
                                        System.out.println(myCharacters.get(0).getName() + " is dead T-T");
                                        myCharacters.remove(0);
                                    }
                                }else{
                                    System.out.println(enemies.get(xue).getName() + " is not able to move for one turn.");
                                }
                            }else if(hua > 0){
                                int randomXue = rand.nextInt(0, hua);
                                if(!enemies.get(xue).isBlock()){
                                    if(myCharacters.get(randomXue).getStayAway()==0){
                                        if(myCharacters.get(randomXue).getWieldedWeapon().getType().equals("Shield")){
                                            boolean isBlock = rand.nextBoolean();
                                            if(!isBlock){
                                                System.out.println(enemies.get(xue).getName() + " is attacking to " + myCharacters.get(randomXue).getName() + " with a damage " + enemies.get(xue).damage());
                                                double damage = enemies.get(xue).damage();
                                                myCharacters.get(randomXue).updateHP(1,damage);
                                                System.out.println("Remaining HP of " + myCharacters.get(randomXue).getHP());
                                            }else{
                                                System.out.println(enemies.get(xue).getName() + " has been blocked.");
                                            }
                                        }else{
                                            System.out.println(enemies.get(xue).getName() + " is attacking to " + myCharacters.get(randomXue).getName() + " with a damage " + enemies.get(xue).damage());
                                            double damage = enemies.get(xue).damage();
                                            myCharacters.get(randomXue).updateHP(1,damage);
                                            System.out.println("Remaining HP of " + myCharacters.get(randomXue).getHP());
                                        }
                                    }
                                    if(myCharacters.get(randomXue).getHP()<=0){
                                        System.out.println(myCharacters.get(randomXue).getName() + " is dead T-T");
                                        myCharacters.remove(randomXue);
                                    }
                                }else{
                                    System.out.println(enemies.get(xue).getName() + " is not able to move for one turn.");
                                }
                            }else{
                                gameFlag = false;
                                System.out.println("Exiting the game...");
                                enemies.clear();
                            }
                        }
                    }else{
                        System.out.println("You are going to level up. ");
                        i = 3;
                    }
                }
            }else{
                gameFlag = false;
            }
            level ++;
            enemyAmount = (int)Math.pow(2, level);
            levelItems.clear();
        }
        File file = new File("maxxLevel.txt");
        try {
            if(file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println("An error ocurreed.");
            e.printStackTrace();
        }

        try{
            FileWriter fw = new FileWriter(file);
            fw.write(level);
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Successfully implemented.");
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

    public static Weapons dropWeapon(){
        Weapons[] drop = new Weapons[15];

        try(Scanner input = new Scanner(Paths.get("Swords.txt"))){
            int i = 0;
            while(input.hasNext()){
                drop[i] = new Swords(input.next(), input.nextInt(), input.nextInt(), input.nextInt());
                i++;
            }
        }catch (NoSuchElementException | IllegalStateException | IOException e){
            e.printStackTrace();
        }

        try(Scanner input = new Scanner(Paths.get("Shields.txt"))){
            int j = 5;
            while(input.hasNext()){
                drop[j] = new Shields(input.next(), input.nextInt(), input.nextInt(), input.nextInt());
                j++;
            }
        }catch (NoSuchElementException | IllegalStateException | IOException e){
            e.printStackTrace();
        }

        try(Scanner input = new Scanner(Paths.get("Wands.txt"))){
            int k = 10;
            while(input.hasNext()){
                drop[k] = new Swords(input.next(), input.nextInt(), input.nextInt(), input.nextInt());
                k++;
            }
        }catch (NoSuchElementException | IllegalStateException | IOException e){
            e.printStackTrace();
        }

        int index  = rand.nextInt(1,14);
        return drop[index];
    }
}
