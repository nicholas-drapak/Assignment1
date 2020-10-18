import java.lang.Math;
public class CPUPlayer extends Player{
    public Monster monster;
    public CPUPlayer(){

    }
    public CPUPlayer(Monster monster){
        super(monster);
    }
    public Move chooseMove(){
        return this.getMonster().getMove((int)(Math.random() * (4 - 1 + 1) + 1));
    }
}