import java.util.ArrayList;
import java.util.Scanner;

//The character will have HP
public class Character {

    //Instance variables.
    protected String name;
    protected int strength;
    protected int vitality;
    protected int intelligence;
    protected ArrayList<Items> inventoryW;
    protected ArrayList<Items> inventoryC;
    protected ArrayList<Items> inventory; //If we want to manipulate the inventory regardless their category.
    protected Weapons wieldedWeapon;
    protected Clothings wieldedClothing;
    private final Scanner sc = new Scanner(System.in);

    //Damage calculating function. Also, can be used to give damage.
    public double damage(){

        return switch (wieldedWeapon.type) {
            case "Sword" -> wieldedWeapon.damage * strength;
            case "Wand" -> wieldedWeapon.damage * intelligence;
            case "Shield" -> wieldedWeapon.damage * vitality;
            default -> strength;
        };

    }

    //update the inventory via inventoryC + inventoryW
    public void updateInventory(){

        //clear the inventory to avoid redundancy.
        inventory.clear();

        //Add inventoryW's objets to inventory
        inventory.addAll(inventoryW);

        //Add inventoryC's objects to inventory
        inventory.addAll(inventoryC);

    }


    public double calculateTotalWeight(){
        double totalWeight = 0;
        for(int i = 0; i < inventory.size(); i++){
            totalWeight = totalWeight + inventory.get(i).getWeight();
        }
        totalWeight = totalWeight + wieldedWeapon.weight + wieldedClothing.weight;
        return totalWeight;
    }

    public void addInventory(Items item){ //!!Later on, you might need to add return statements to add the item on the levels inventory

        double totalWeight = calculateTotalWeight();

        //If the item is clothing
        if(item.category.equals("Clothing")){
            if((totalWeight + item.weight)<=strength){ //And strength is greater than total weight + item's weight
                inventoryC.add(item);
                updateInventory();

                System.out.println("The clothing named " + item.name + " has been picked up by " + name);
            }else{//Or our inventory is full
                boolean flag = true;
                while(flag){
                    System.out.println("Your inventory is full. You can either drop your items in your inventory or drop this item. " +
                            "\nTo drop an item in your inventory press 1\nTo drop this item press 2:");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            dropInventory();
                            break;
                        case 2:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter a valid input next time.");
                            break;
                    }
                    if(strength >= totalWeight + item.weight){
                        flag = false;
                    }
                }
                if(strength>= totalWeight + item.weight){
                    inventoryC.add(item);
                }
            }
        }else if(item.category.equals("Weapon")){ //If the item is a weapon
            if((totalWeight + item.weight)<=strength){ //And strength is greater than total weight + items weight
                inventoryW.add(item);
                updateInventory();
                System.out.println("The weapon named " + item.name + " has been picked up by " + name);
            }else{//Or our inventory is full
                boolean flag1 = true;
                while(flag1){
                    System.out.println("Your inventory is full. You can either drop your items in your inventory or drop this item. " +
                            "\nTo drop an item in your inventory press 1\nTo drop this item press 2:");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            dropInventory();
                            break;
                        case 2:
                            flag1 = false;
                            break;
                        default:
                            System.out.println("Enter a valid input next time.");
                            break;
                    }
                    if(strength >= totalWeight + item.weight){
                        flag1 = false;
                    }
                }
                if(strength>= totalWeight + item.weight){
                    inventoryW.add(item);
                }
            }
        }
    }

    public Items dropInventory(){
        //Listing all items in the inventory.
        System.out.println("You have those items in your inventory: ");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println((i+1) + ": " + inventory.get(i).name + "| Weight: " + inventory.get(i).weight);
        }

        //Choosing which one to drop.
        System.out.println("Which one would you like to drop? Enter the number: ");
        int drop = sc.nextInt();
        drop = drop - 1;
        sc.nextLine();

        //Dropping functions.
        if(inventory.get(drop).category.equals("Clothing")){
            System.out.println(inventory.get(drop).name + " has been removed.");
            int counter = 0;
            while(counter < inventoryC.size()){
                if(inventoryC.get(counter) == inventory.get(drop)){
                    break;
                }else{
                    counter++;
                }
            }
            Items temp = inventory.get(drop);
            inventoryC.remove(counter);
            updateInventory();
            return temp;
        }
        else if(inventory.get(drop).category.equals("Weapon")){
            System.out.println(inventory.get(drop).name + " has been removed.");
            int counter = 0;
            while(counter < inventoryW.size()){
                if(inventoryW.get(counter) == inventory.get(drop)){
                    break;
                }else{
                    counter++;
                }
            }
            Items temp = inventory.get(drop);
            inventoryW.remove(counter);
            updateInventory();
            return temp;
        }else{
            return null;
        }
    }

    public void switchWielded(){
        System.out.println("Which type of wielded item would you like to put back to your inventory: " +
                "\n1 for Weapon" +
                "\n2 for Clothing");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                //Adding wielded weapon to your inventory
                inventoryW.add(wieldedWeapon);
                System.out.println(wieldedWeapon.name + " has been added to your inventory.");
                wieldedWeapon = null; //Empty hand

                //Take a weapon in your hand or not?
                System.out.println("Would you like to pick up some weapon from your inventory? \n" +
                        "For yes press 1 \n" +
                        "For no press some integer: ");
                int choice1 = sc.nextInt();
                sc.nextLine();
                switch (choice1){
                    case 1:
                        System.out.println("You have those weapons in your inventory: ");
                        for(int i = 0; i<inventoryW.size(); i++){
                            System.out.println((i+1) + ": " + inventoryW.get(i).name);
                        }
                        System.out.println("Please select the weapon you wish to wear: ");
                        int wield = sc.nextInt();
                        sc.nextLine();
                        wield = wield - 1;
                        if(inventoryW.get(wield) == null){
                            System.out.println("Please enter a valid integer next time.");
                        }else{
                            wieldedWeapon = (Weapons) inventoryW.get(wield);
                            inventoryW.remove(wield);
                        }
                        break;
                    default:
                        break;
                }
            case 2:
                //Adding wielded clothing to your inventory
                inventoryC.add(wieldedClothing);
                System.out.println(wieldedClothing.name + " has been added to your inventory.");
                wieldedClothing = null; //Empty hand

                //Take a clothing in your hand or not?
                System.out.println("Would you like to pick up some clothing from your inventory? \n" +
                        "For yes press 1 \n" +
                        "For no press some integer: ");
                int choice2 = sc.nextInt();
                sc.nextLine();
                switch (choice2){
                    case 1:
                        System.out.println("You have those clothings in your inventory: ");
                        for(int i = 0; i<inventoryC.size(); i++){
                            System.out.println((i+1) + ": " + inventoryC.get(i).name);
                        }
                        System.out.println("Please select the clothing you wish to wear: ");
                        int wield1 = sc.nextInt();
                        sc.nextLine();
                        wield1 = wield1 - 1;
                        if(inventoryC.get(wield1) == null){
                            System.out.println("Please enter a valid integer next time.");
                        }else{
                            wieldedClothing = (Clothings) inventoryC.get(wield1);
                            inventoryC.remove(wield1);
                        }
                        break;
                    default:
                        break;
                }
            default:
                System.out.println("Please enter a valid integer next time.");
                break;
        }
    }
}
