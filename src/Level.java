import java.util.ArrayList;

interface Level {
    static void increaseLevel(int level, int enemyAmount){
        //a method to increase level, we implemented this metod for the readibility purposes.
        level ++;
        enemyAmount = Math.pow(2, level);
    }
    static int turnCountChar(){
        int turn = 0;
        if(turn<2){
            turn ++;
            return turn;
        }else {
            turn = 0;
            return turn;
        }
    }
    static int turnCountEnemy(int turnEn, ArrayList<EnemySoldier> enemies){
        int turn = 0;
        if(turn<enemies.size()){
            turn++;
            return turn;
        }else{
            turn = 0;
            return turn;
        }
    }
    void setEnemy();
    Weapons dropWeapon();
    void attack();
    void specialAction();
    void pick();
    void wield();
    void wear();
    void examine();
    void listInventory();

}
