import java.util.ArrayList;
import java.util.Scanner;
//The character will have a HP
public class Character {

    protected String name;
    protected int strength;
    protected int vitality;
    protected int intelligence;
    protected ArrayList<Items> inventoryW;
    protected ArrayList<Items> inventoryC;
    protected ArrayList<Items> inventory;
    protected Weapons wieldedWeapon;
    protected Clothings wieldedClothing;
    private Scanner sc = new Scanner(System.in);

    public double damage(){
        if(wieldedWeapon.type.equals("Sword")){
            return wieldedWeapon.damage*strength;
        }else if(wieldedWeapon.type.equals("Wand")){
            return wieldedWeapon.damage*intelligence;
        }else if(wieldedWeapon.type.equals("Shield")){
            return wieldedWeapon.damage*vitality;
        }else{
            return strength;
        }
    }

    public void updateInventory(){
        inventory.clear();
        for(int i = 0; i < inventoryW.size(); i++){
            inventory.add(inventoryW.get(i));
        }
        for (int i = 0; i < inventoryC.size(); i++){
            inventory.add(inventoryC.get(i));
        }
    }

    public void addInventory(Items item){ //Burayı Clothing ve Weapona özel olarak güncelle
        double totalWeight = 0;
        for(int i = 0; i < inventory.size(); i++){
            totalWeight = totalWeight + inventory.get(i).getWeight();
        }
        totalWeight = totalWeight + wieldedWeapon.weight + wieldedClothing.weight;
        
        if(item.category.equals("Clothing")){
            if((totalWeight + item.weight)<strength){
                inventoryC.add(item);
                updateInventory();
                System.out.println("The weapon named " + item.name + " has been picked up by " + name);
            }else{
                System.out.println("Your inventory is full. You can either drop your items in your inventory or drop this item. " +
                        "\nTo drop an item in your inventory press 1\nTo drop this item press 2:");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        dropInventory();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Enter a valid input next time.");
                        break;
                }
            }
        }
       /* 
        if((totalWeight + item.weight)<strength){
            inventory.add(item);
            System.out.println("The weapon named " + item.name + " has been picked up by " + name);
        }else{
            System.out.println("Your inventory is full. You can either drop your items in your inventory or drop this item. " +
                    "\nTo drop an item in your inventory press 1\nTo drop this item press 2:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    dropInventory();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Enter a valid input next time.");
                    break;
            }
        }*/
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
                inventory.add(wieldedWeapon);
                System.out.println(wieldedWeapon.name + " has been added to your inventory.");
                wieldedWeapon = null;
                System.out.println("Would you like to pick up some weapon from your inventory? \n" +
                        "For yes press 1 \n" +
                        "For no press some integer: ");
                int choice1 = sc.nextInt();
                sc.nextLine();
                switch (choice1){
                    case 1:
                        dropInventory();
                }
        }
    }
}
