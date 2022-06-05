import java.util.ArrayList;

interface Level {
    public void increaseLevel();
    public static int turnCountChar(){
        int turn = 0;
        if(turn<2){
            turn ++;
            return turn;
        }else {
            turn = 0;
            return turn;
        }
    }
    public static int turnCountEnemy(int turnEn, ArrayList<EnemySoldier> enemies){
        int turn = 0;
        if(turn<enemies.size()){
            turn++;
            return turn;
        }else{
            turn = 0;
            return turn;
        }
    }
    public void setEnemy();
    public Weapons dropWeapon();
    public void attack();
    public void specialAction();
    public void pick();
    public void wield();
    public void wear();
    public void examine();
    public void listInventory();

}
