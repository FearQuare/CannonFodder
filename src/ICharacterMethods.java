public interface ICharacterMethods {
    void printInfo(Character character);
    double damage();
    void updateInventory();
    double calculateTotalWeight();
    void printInventory();
    void addInventory(Items item);
    Items dropInventory();
    void switchWielded();

}
